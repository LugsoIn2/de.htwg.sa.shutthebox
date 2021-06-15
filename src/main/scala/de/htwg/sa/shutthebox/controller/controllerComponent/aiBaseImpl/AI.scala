package de.htwg.se.shutthebox.controller.controllerComponent.aiBaseImpl

import de.htwg.se.shutthebox.ShutTheBox
import de.htwg.se.shutthebox.controller.controllerComponent.controllerBaseImpl.Controller
import de.htwg.se.shutthebox.controller.controllerComponent.aiInterface
import de.htwg.se.shutthebox.model.playerComponent.playerImpl.Player
import de.htwg.se.shutthebox.model.playerComponent.playerInterface

import scala.concurrent.ExecutionContext.Implicits._
import scala.concurrent.Future
import scala.swing.{Frame, Swing}
import scala.util.{Failure, Success}

class AI(controller:Controller) extends Player("AI") with aiInterface {

  //var gui:Frame = ShutTheBox.gui
  var validShuts:Array[Int] = Array.ofDim[Int](4)
  var singleShuts:Array[Int] = Array.ofDim[Int](2)
  var allowFuture = false

  def randomTimeMillis(min:Int, max:Int) : Int = {
    var value = min + scala.util.Random.nextInt((max - min) + 1)
    value
  }

  def calcValidShuts(): Unit = {
    validShuts = Array(controller.validSum, controller.validDiff, controller.validProd, controller.validDiv)
    singleShuts = controller.validNumber
  }

  def giveUp(): Unit = {
    println("That's it! :-(")
    Thread.sleep(2000)
    controller.setCurrentPlayer()
  }

  def analyze(): Future[Unit] = Future {
    if (allowFuture) {
      println("AI is thinking ...")
      Thread.sleep(randomTimeMillis(500, 2000))

      var currentMax = validShuts.max
      var currentMaxIndex = validShuts.indexOf(validShuts.max)

      // if maximum is in range of matchfield
      if (currentMax > 0 && currentMax <= controller.matchfield.field.length ) {
        // if the cell isn't already shut
        if (!controller.matchfield.field(currentMax-1).isShut) {
          controller.doShut(validShuts.max) match {
            case Success(value) => ""
            case Failure(exception) => exception.getMessage
          }
          think()
        } else {
          validShuts(currentMaxIndex) = 0

          if (singleShuts(0) != 0 & singleShuts(1) != 0) {
            // if the two single dice values aren't already shut
            if ((singleShuts(0) != singleShuts(1)) & !controller.matchfield.field(singleShuts(0) - 1).isShut && !controller.matchfield.field(singleShuts(1) - 1).isShut) {
              // shut the single die values
              controller.doShut(singleShuts(0)) match {
                case Success(value) => ""
                case Failure(exception) => exception.getMessage
              }
              Thread.sleep(700) // so human player can follow along
              controller.doShut(singleShuts(1)) match {
                case Success(value) => ""
                case Failure(exception) => exception.getMessage
              }
              think()
            }

            else if ((singleShuts(0) == singleShuts(1)) | !controller.matchfield.field(singleShuts(0) - 1).isShut | !controller.matchfield.field(singleShuts(1) - 1).isShut) {
              analyze()
            }
          } else
            giveUp()
        }
      } else {
        validShuts(currentMaxIndex) = 0 // set current max to 0, if result > matchfield
        analyze()
      }
    }
  }

  analyze() onComplete {
    result => controller.update()//Swing.onEDT //{
    //gui.repaint()
    //}
  }

  def think(): Unit = {
    //gui.repaint()
    controller.rollDice match {
      case Some(value) => ""
      case None  => ""
    }

    Thread.sleep(randomTimeMillis(500, 2000))
    calcValidShuts()
    allowFuture = true
    analyze()
  }
}