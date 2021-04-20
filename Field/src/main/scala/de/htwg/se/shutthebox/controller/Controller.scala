package de.htwg.se.shutthebox.controller

import de.htwg.se.shutthebox.FieldModule
import de.htwg.se.shutthebox.model.fieldComponent.fieldBaseImpl.Die
import de.htwg.se.shutthebox.model.fieldComponent.{dieInterface, fieldInterface}
import com.google.inject.{Guice, Inject, Injector}
import com.google.inject.name.Names
import net.codingwell.scalaguice.InjectorExtensions.ScalaInjector

class Controller {

  var matchfield : fieldInterface = _
  val injector: Injector = Guice.createInjector(new FieldModule)

  var dice:Array[dieInterface] = Array.ofDim[dieInterface](2)

  def loadMatchfield(): Unit = {

  }

  def createField(t:Integer) : Unit = {
    if (t == 0)
      matchfield = injector.instance[fieldInterface](Names.named("normal"))
    else {
      matchfield = injector.instance[fieldInterface](Names.named("big"))
    }
  }


  def saveField(): Unit = {

  }

  def createDice(): Unit = {
    //dice = Array(new Die, new Die)
    for (i <- 0 to 1) {
      dice(i) = Die()
    }
  }

  def shut(i : Int) : Unit = {
    matchfield.shut(i, matchfield)
  }

  def resetMatchfield(): Unit = {
    for (i <- matchfield.field.indices) {
      matchfield.field(i) = matchfield.field(i).copy(isShut = false)
    }
  }

  def loadFileIO(field : Array[Boolean]) : Unit = {
    if (field.length == 9) {
      createField(0)
    } else {
      createField(1)
    }
    shutCells(field)
  }

  def shutCells(field : Array[Boolean]): Unit = {
    for (i <- field.indices) {
      matchfield.field(i) = matchfield.field(i).copy(isShut = field(i))
    }
  }

  def rollDice() : Unit = {
    dice(0) = dice(0).roll
    Thread.sleep(100)
    dice(1) = dice(1).roll
  }

  override def toString : String = {

    var field: Array[Boolean] = Array()
    for (i <- this.matchfield.field.indices) {
      field = field :+ this.matchfield.field(i).isShut
    }
    val jsonString: String =
      """
      {
          "field": """ + field.mkString("[", ", ", "]") + """,
          "dice" : {
            "die1" : """ + dice(0).value + """,
            "die2" : """ + dice(1).value + """
          }
      }
      """.stripMargin
    jsonString
  }

}