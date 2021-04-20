package de.htwg.se.shutthebox.controller

import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.http.scaladsl.Http
import akka.http.scaladsl.client.RequestBuilding.{Get, Post}
import akka.http.scaladsl.model.{HttpResponse, StatusCodes}
import akka.http.scaladsl.unmarshalling.Unmarshal
import com.google.inject.{Guice, Inject, Injector}
import com.google.inject.name.Names
import de.htwg.se.shutthebox.FileIOModule
import de.htwg.se.shutthebox.model.fileIoComponent.FileIOInterface
import net.codingwell.scalaguice.InjectorExtensions.ScalaInjector
import play.api.libs.json.{JsObject, JsValue, Json}

import scala.concurrent.{ExecutionContextExecutor, Future}
import scala.util.{Failure, Success}

class FileIOController {

  val injector = Guice.createInjector(new FileIOModule)
  val fileIO = injector.instance[FileIOInterface]
  var postBody = ""

  def save():Unit = {
    getCall("field")
  }

  def load():String = {
    //var matchfield =
    //matchfield = fileIO.load
    val payload = fileIO.load
    postCall(payload.as[JsObject], "loadFileIO")
    Thread.sleep(1000)
    println("Postbuddy in load: " + postBody)
    postBody
    //response zurück an Main Coontroller
  }


  def postCall(payload: JsObject, requestURL: String) : Unit = {
    implicit val system: ActorSystem[Nothing] = ActorSystem(Behaviors.empty, "SingleRequest")
    implicit val executionContext: ExecutionContextExecutor = system.executionContext
    val responseFuture: Future[HttpResponse] =
      Http().singleRequest(Post("http://localhost:9003/" + requestURL, payload.toString()))
    responseFuture.onComplete{
      case Success(res) =>
        if (res.status == StatusCodes.OK) {
          val responseBody : Future[String] = Unmarshal(res.entity).to[String]
          responseBody.onComplete{
            case Success(body) =>
              val JsonRes = Json.parse(body)
              println("post: " + body)
              postBody = body
          }
        }
    }
  }

  def getCall(requestURL: String) : Unit = {
    implicit val system: ActorSystem[Nothing] = ActorSystem(Behaviors.empty, "SingleRequest")
    // needed for the future flatMap/onComplete in the end
    implicit val executionContext: ExecutionContextExecutor = system.executionContext
    val responseFuture: Future[HttpResponse] = Http().singleRequest(Get("http://localhost:9003/" + requestURL))
    responseFuture.onComplete{
      case Success(res) =>
        val entityAsText : Future[String] = Unmarshal(res.entity).to[String]
        entityAsText.onComplete{
          case Success(body) =>
            val JsonRes = Json.parse(body)
            fileIO.save(JsonRes)
          case Failure(_) => println("something Wrong")
        }
      case Failure(_) => sys.error("something wrong")
    }
  }
}
