package de.htwg.se.shutthebox


import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.Directives._
import de.htwg.se.shutthebox.controller.Controller
import play.api.libs.json.{JsObject, JsValue, Json}

import scala.concurrent.ExecutionContextExecutor
import scala.io.StdIn

object FieldAPI {
  val connectionInterface = "0.0.0.0"
  val connectionPort: Int = sys.env.getOrElse("PORT", 9003).toString.toInt

  def main(args: Array[String]) {
    implicit val actorSystem: ActorSystem = ActorSystem("actorSystem")
    implicit val executionContext: ExecutionContextExecutor = actorSystem.dispatcher

    val controller: Controller = new Controller()

    val route = concat(
      pathPrefix("field") {
        concat(
          get {
            complete(HttpEntity(ContentTypes.`application/json`, controller.controllerToJson.toString()))
          }, post {
            entity(as[String]) { jsonString => {
              println(jsonString)
              val json = Json.parse(jsonString)
              val bigMatchfield = (json \ "bigMatchfield").as[Boolean]
              if (bigMatchfield) {
                controller.createField(12)
              } else {
                controller.createField(9)
              }
              controller.createDice()
              complete(HttpEntity(ContentTypes.`application/json`, controller.controllerToJson.toString()))
              }
            }
            }
        )
      },
      pathPrefix("rollDice") {
        get {
          controller.rollDice
          complete(HttpEntity(ContentTypes.`application/json`, controller.controllerToJson.toString()))
        }
      },
      pathPrefix("shut") {
        post {
          entity(as[String]) { jsonString =>{
            println(jsonString)
            val json = Json.parse(jsonString)
            val index = (json \ "index").as[Int]
            controller.shut(index)
            complete(HttpEntity(ContentTypes.`application/json`, controller.controllerToJson.toString()))
          }}
        }
      },
    )

    val bindingFuture = Http().bindAndHandle(route, connectionInterface, connectionPort)

    println(s"Server online at http://$connectionInterface:$connectionPort/\nPress RETURN to stop...")
    StdIn.readLine() // let it run until user presses return
    bindingFuture
      .flatMap(_.unbind()) // trigger unbinding from the port
      .onComplete(_ => actorSystem.terminate()) // and shutdown when done
  }
}
