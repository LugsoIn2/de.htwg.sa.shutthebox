package de.htwg.se.shutthebox

import de.htwg.se.shutthebox.controller.Controller
import play.api.libs.json.Json

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.Directives._
import de.htwg.se.shutthebox.controller.Controller
import play.api.libs.json.{JsObject, JsValue, Json}

import scala.concurrent.ExecutionContextExecutor
import scala.io.StdIn

object FileIOAPI {
  val connectionInterface = "0.0.0.0"
  val connectionPort: Int = sys.env.getOrElse("PORT", 9004).toString.toInt

  def main(args: Array[String]) {
    implicit val actorSystem: ActorSystem = ActorSystem("actorSystem")
    implicit val executionContext: ExecutionContextExecutor = actorSystem.dispatcher

    val controller: Controller = new Controller()

    val route = concat(
      pathPrefix("load") {
        post {
          entity(as[String]) { jsonString => {
            println(jsonString)
            //Function aufruf load Controller
            complete(HttpEntity(ContentTypes.`application/json`, controller.toString()))
          }
          }
        }
      }
    )
    pathPrefix("save") {
      get {
        //function aufruf save Controller
        complete(HttpEntity(ContentTypes.`application/json`, controller.toString()))
      }
    }
  }
}
