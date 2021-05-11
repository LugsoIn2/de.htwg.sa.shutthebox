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

  val uri: String = "mongodb+srv://<username>:<password>@<cluster-address>/test?retryWrites=true&w=majority"
  System.setProperty("org.mongodb.async.type", "netty")
  val client: MongoClient = MongoClient(uri)
  val db: MongoDatabase = client.getDatabase("test")



  override def create(field: JsValue): Unit = ???

  override def read(): String = ???

  override def update(): Unit = ???

  override def delete(): Unit = ???
}
