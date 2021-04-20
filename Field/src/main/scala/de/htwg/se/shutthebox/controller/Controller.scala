package de.htwg.se.shutthebox.controller

import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.http.scaladsl.Http
import akka.http.scaladsl.client.RequestBuilding.{Get, Post}
import akka.http.scaladsl.model.{HttpResponse, StatusCode, StatusCodes}
import akka.http.scaladsl.unmarshalling.Unmarshal

import com.google.inject.{Guice, Injector}
import de.htwg.se.shutthebox.FieldModule
import de.htwg.se.shutthebox.model.fieldComponent.fieldBaseImpl.{Die, Field}
import de.htwg.se.shutthebox.model.fieldComponent.{dieInterface, fieldInterface}
import com.google.inject.{Guice, Inject, Injector}
import com.google.inject.name.Names
import net.codingwell.scalaguice.InjectorExtensions.ScalaInjector
import play.api.libs.json.{JsArray, JsValue, Json, __}

class Controller {

  var matchfield : fieldInterface = _
  val injector: Injector = Guice.createInjector(new FieldModule)

  var dice:Array[dieInterface] = Array.ofDim[dieInterface](2)

  //createField(9)
  //createDice()
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
    for (i <- 0 until matchfield.field.length) {
      matchfield.field(i) = matchfield.field(i).copy(isShut = false)
    }
  }

  def rollDice : Unit = {
    dice(0) = dice(0).roll
    Thread.sleep(100)
    dice(1) = dice(1).roll
  }

  override def toString : String = {

    var field: Array[Boolean] = Array()
    for (i <- 0 until this.matchfield.field.length) {
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