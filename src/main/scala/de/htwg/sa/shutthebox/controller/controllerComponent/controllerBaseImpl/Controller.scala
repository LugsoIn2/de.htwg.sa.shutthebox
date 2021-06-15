package de.htwg.se.shutthebox.controller.controllerComponent.controllerBaseImpl

import de.htwg.se.shutthebox.controller.controllerComponent.GameState._
import de.htwg.se.shutthebox.controller.controllerComponent.ShutState.{apply => _, _}
import com.google.inject.{Guice, Inject, Injector}
import com.google.inject.name.Names
import de.htwg.se.shutthebox.ShutTheBoxModule
import de.htwg.se.shutthebox.controller.controllerComponent._
import de.htwg.se.shutthebox.controller.controllerComponent.aiBaseImpl.AI
import de.htwg.se.shutthebox.model.fieldComponent.{dieInterface, fieldInterface}
import de.htwg.se.shutthebox.model.fieldComponent.fieldBaseImpl.Die
import de.htwg.se.shutthebox.model.playerComponent.playerInterface
import de.htwg.se.shutthebox.util.UndoManager

import scala.collection.mutable
import scala.swing.Publisher

import scala.util.{Failure, Success, Try}

class Controller extends ControllerInterface with Publisher :
  var players:Array[playerInterface] = Array.ofDim[playerInterface](2)
  var currentPlayer:playerInterface = players(0)
  var currentPlayerIndex = 0 // to determine, when to show scoreboard
  var matchfield : fieldInterface = _
  var dice:Array[dieInterface] = Array.ofDim[dieInterface](2)
  var gameState : GameState = MENU
  var shutState : ShutState = SHUTSTATE0

  var validNumber: Array[Int] = Array(0,0)
  var validSum = 0
  var validDiff = 0
  var validProd = 0
  var validDiv = 0

  private val undoManager = new UndoManager
  private var lastShut = mutable.Stack[Int]()
  private var tmpLastShut = mutable.Stack[Int]()

  val injector: Injector = Guice.createInjector(new ShutTheBoxModule)


  def startGame(t:Integer, ai:Boolean): Unit = 
    //t 0 = SmallField, t 1 = BigField
    //ai 0 = no AI, ai 1 = AI
    createField(t)
    createDice()
    createPlayers(ai)
    resetMatchfield()
    gameState = GameState.INGAME
    
  


  def createField(t:Integer) : Unit = 
    if (t == 0) then
      matchfield = injector.getInstance(classOf[fieldInterface])
    else
      matchfield = injector.getInstance(classOf[fieldInterface])
    publish(new FieldCreated)
  

  def getField : fieldInterface = 
    matchfield
  

  def createDice(): Unit = 
    for (i <- 0 to 1) 
      dice(i) = Die()
    publish(new DiceCreated)
  


  def createPlayers(ai:Boolean): Unit = 
    players(0) = injector.getInstance(classOf[playerInterface]).updateName("Player1")
    if (ai) then
      players(1) = new AI(this)
    else 
      players(1) = injector.getInstance(classOf[playerInterface]).updateName("Player2")
    end if
    currentPlayer = players(0)
    currentPlayerIndex = 0
    print("PLAYER1: " + players(0).name + "\n")
    print("PLAYER2: " + getPlayers(1).name + "\n")

    publish(new PlayersCreated)
  

  def getPlayers: Array[playerInterface] = 
    players


  def getCurrentPlayer : playerInterface = 
    currentPlayer
  

  def setCurrentPlayer(): Unit = 
    currentPlayerIndex += 1
    if (currentPlayerIndex < 2) then
      if (currentPlayer == players(0)) then
        currentPlayer = currentPlayer.updateScore(getScore)
        players(0) = currentPlayer
      else
        currentPlayer = currentPlayer.updateScore(getScore)
        players(1) = currentPlayer
      end if
      resetMatchfield()

      if (currentPlayer == players(0)) then
        currentPlayer = players(1)
        if (currentPlayer.isInstanceOf[AI]) then
          // set states, so AI is able to roll the dice
          gameState = INGAME
          shutState = SHUTSTATE0
          players(1).asInstanceOf[AI].think()
        end if
      end if  
      publish(new CurrentPlayerSet)
    else 
      if (currentPlayer == players(0)) then
        currentPlayer = currentPlayer.updateScore(getScore)
        players(0) = currentPlayer
      else 
        currentPlayer = currentPlayer.updateScore(getScore)
        players(1) = currentPlayer
      end if
      publish(new ShowScoreBoard)
    end if
    gameState = INGAME
    shutState = SHUTSTATE0


  def getScore : Int =
    var score = 0
    for (i <- 1 to matchfield.field.length) 
      score += i
      if (matchfield.field(i - 1).isShut) then
        score -= i
      end if
    
    publish(new ScoreUpdated)
    score
  

  def resetMatchfield() : Unit =
    for (i <- 1 to matchfield.field.length) 
      matchfield.field(i-1) = matchfield.field(i-1).copy(isShut = false)
    
  


  def cmdShut(value:Int) : Unit = 
    undoManager.doStep(new SetCommand(value, this))
  

  def cmdUnShut() : Unit = 
    undoManager.undoStep
  

  def cmdRedoShut() : Unit = 
    undoManager.redoStep
  

  def redoShut(): Unit =
    if (tmpLastShut.nonEmpty)

      doShut(tmpLastShut.top) match 
        case Success(value) => ""
        case Failure(exception) => exception.getMessage
      
      //doShut(tmpLastShut.top)
      tmpLastShut.pop()
    end if
    publish(new Redone)
  

  def undoShut(): Unit = 
    if (lastShut.nonEmpty) then
      shutState = SHUTSTATE0
      gameState = UNDOSTATE
      matchfield.field(lastShut.top - 1) = matchfield.field(lastShut.top - 1).copy(isShut = false)
      tmpLastShut.push(lastShut.top)
      lastShut.pop()
    end if
    publish(new Undone)
  
  
  def doShut(i:Int) : Try[String] = 
    var message = " "
    if (gameState == ROLLDICE | gameState == SHUT | gameState == UNDOSTATE) then

      if((validNumber(0) == i | validNumber(1) == i) & shutState == SHUTSTATE0) then
        shut(i)
        shutState = SHUTSTATE5
      else if((validNumber(0) == i | validNumber(1) == i) & shutState == SHUTSTATE5) then
        shut(i)
        shutState = SHUTSTATE5
      else if(validSum == i & shutState == SHUTSTATE0) then
        shut(i)
        shutState = SHUTSTATE1
      else if(validDiff == i & shutState == SHUTSTATE0) then
        shut(i)
        shutState = SHUTSTATE2
      else if(validProd == i & shutState == SHUTSTATE0) then
        shut(i)
        shutState = SHUTSTATE3
      else if(validDiv == i & shutState == SHUTSTATE0) then
        shut(i)
        shutState = SHUTSTATE4
      else
        message = "This shut is not allowed"
        println(message)
      end if
    else
      message = "Please roll the dice first!"
      println(message)
    end if
    Try(message)
  


  def shut(i : Int) : Unit = 
    matchfield.shut(i, matchfield)
    lastShut.push(i)
    gameState=SHUT

    // check, if field is completely shut
    var allShut = true
    for (i <- matchfield.field.indices) 
      if (!matchfield.field(i).isShut) then
        allShut = false
      end if
    
    publish(new CellShut)
    if (allShut)
      publish(new AllCellsShut)
    end if
  


  def calcValidShuts() : Unit = 
    //Aufruf der regeln methode.
    //Soll in validNumber dann die erlaubten Zahlen schreiben
    // 1, 3
    if (!matchfield.field(dice(0).value - 1).isShut && !matchfield.field(dice(1).value - 1).isShut) then
      validNumber(0) = dice(0).value
      validNumber(1) = dice(1).value
    else 
      validNumber(0) = 0
      validNumber(1) = 0
    end if
    validSum = calcDice(add)
    validProd = calcDice(mult)
    validDiff = calcDice(sub)
    validDiv = calcDice(div)
  

  def calcDice: ((Int, Int) => Int) => Int = calc(_)(dice(0).value, dice(1).value)

  def calc(op:(Int, Int)=> Int) (x:Int, y:Int): Int = 
    op(x,y)
  

  def add(x:Int, y:Int): Int = x + y
  def sub(x:Int, y:Int): Int = 
    if (x - y) > 0 then
      x-y
    else 
      y-x
    end if
  
  
  def mult(x:Int, y:Int): Int = x * y
  
  def div(x:Int, y:Int): Int = 
    if (x>=y) then
      x/y
    else 
      y/x
    end if
  

  def rollDice : Option[String] = 
    var message = ""
    lastShut.clear()
    tmpLastShut.clear()
    if gameState == INGAME | gameState == SHUT then
      dice(0) = dice(0).roll
      Thread.sleep(100)
      dice(1) = dice(1).roll
      calcValidShuts()
      gameState=ROLLDICE
      shutState=SHUTSTATE0
      publish(new DiceRolled)
    else
      message = "Dice roll not allowed!"
      println(message)
    end if
    if !message.isEmpty then
      Some(message)
    else 
      None
    end if
  

  def printOutput : String = 
    gameState match 
      case GameState.MENU => ""
      case GameState.ROLLDICE => rollToString
      case GameState.SHUT => fieldToString
      case GameState.INGAME => fieldToString
      case GameState.UNDOSTATE => fieldToString
    
  

  def fieldToString : String = matchfield.toString

  def rollToString : String =  
    dice(0).toString + dice(1).toString
  

  def save():Unit = 
    //gameState = LOADED
    publish(new CellShut)
  

  def load():Unit = 
    publish(new GameLoaded)
    publish(new CellShut)
  


  def update() : Unit = 
    publish(new AIThink)
  
