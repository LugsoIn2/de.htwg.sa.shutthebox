package de.htwg.se.shutthebox

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.Directives._
import de.htwg.se.shutthebox.controller.FileIOController
import play.api.libs.json.{JsObject, JsValue, Json}

import scala.concurrent.ExecutionContextExecutor
import scala.io.StdIn


object FileIOAPI {
  val connectionInterface = "0.0.0.0"
  val connectionPort: Int = sys.env.getOrElse("PORT", 9004).toString.toInt

  def main(args: Array[String]) {
    implicit val actorSystem: ActorSystem = ActorSystem("actorSystem")
    implicit val executionContext: ExecutionContextExecutor = actorSystem.dispatcher

    val FileIOController: FileIOController = new FileIOController()

    val route = concat(
      pathPrefix("load") {
        concat(
          post {
            entity(as[String]) { jsonString => {
              println(jsonString)
              val body = FileIOController.load
              println("Boddy: " + body)
              complete(HttpEntity(ContentTypes.`application/json`, body))
            }
            }
          }
        )
      },
      pathPrefix("save") {
        get {
          FileIOController.save()
          println("savecall erhalten")
          complete(HttpEntity(ContentTypes.`application/json`, "Saved Success"))
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
