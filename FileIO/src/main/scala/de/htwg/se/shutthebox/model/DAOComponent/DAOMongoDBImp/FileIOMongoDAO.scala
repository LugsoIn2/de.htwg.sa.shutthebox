package de.htwg.se.shutthebox.model.DAOComponent.DAOMongoDBImp

import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import de.htwg.se.shutthebox.model.DAOComponent.FileIODAOInterface
import play.api.libs.json.JsValue
import org.mongodb.scala._

import scala.concurrent.ExecutionContextExecutor

case class FileIOMongoDAO() extends FileIODAOInterface {

  implicit val system: ActorSystem[Nothing] = ActorSystem(Behaviors.empty, "my-system")
  implicit val executionContext: ExecutionContextExecutor = system.executionContext

  val uri: String = "mongodb://localhost:27017/test?retryWrites=true&w=majority"
  //System.setProperty("org.mongodb.async.type", "netty")
  val client: MongoClient = MongoClient(uri)
  val db: MongoDatabase = client.getDatabase("test")

  override def create(field: JsValue): Unit = {
    println("FILEIOMONGOCREATE")
    val collection : MongoCollection[Document] = db.getCollection("test")
    val doc: Document = Document("_id" -> 0, "field" -> List(true, true))
    //collection.insertOne(doc)
    val observable: Observable[Completed] = collection.insertOne(doc)

    observable.subscribe(new Observer[Completed] {
      override def onNext(result: Completed): Unit = println(s"onNext: $result")
      override def onError(e: Throwable): Unit = println(s"onError: $e")
      override def onComplete(): Unit = println("onComplete")
    })
  }

  override def read(): String = ???

  override def update(): Unit = ???

  override def delete(): Unit = ???




}
