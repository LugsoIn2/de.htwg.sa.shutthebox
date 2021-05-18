package de.htwg.se.shutthebox.model.DAOComponent.DAOMongoDBImp

import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import com.google.common.collect.Range.atMost
import de.htwg.se.shutthebox.model.DAOComponent.FileIODAOInterface
import org.mongodb.scala._
import org.mongodb.scala.bson.ObjectId
import org.mongodb.scala.model.Filters.equal
import org.mongodb.scala.result.UpdateResult
import play.api.libs.json.{JsObject, JsValue, Json}

import scala.concurrent.duration.DurationInt
import scala.concurrent.{Await, ExecutionContextExecutor}

case class FileIOMongoDAO() extends FileIODAOInterface {

  implicit val system: ActorSystem[Nothing] = ActorSystem(Behaviors.empty, "my-system")
  implicit val executionContext: ExecutionContextExecutor = system.executionContext

  val uri: String = "mongodb://localhost:27017/test?retryWrites=true&w=majority"
  val client: MongoClient = MongoClient(uri)
  val db: MongoDatabase = client.getDatabase("fileIoDatabase")
  val gameCollection : MongoCollection[Document] = db.getCollection("game")
  val IDCollection : MongoCollection[Document] = db.getCollection("id")
  var id = 0
  /*
  override def create(json: JsValue): Unit = {
    val IDDoc : Document = Document("_id" -> id.toString, "id" -> id)
    observableHandler(IDCollection.insertOne(IDDoc))

    val idDoc = Await.result(IDCollection.find(equal("_id", id.toString)).first().head(), atMost = 10.second).toJson()
    println("idDoc" + idDoc)
    val tmp = Json.parse(idDoc)
    val oldId = (tmp \ "id").as[Int]
    println("oldID" + oldId)
    val newId = oldId + 1
    observableHandlerUpdate(IDCollection.replaceOne(equal("_id", id.toString), Document("id" -> newId.toString)))
    id = newId

    val field = (json \ "field").as[Array[Boolean]].toList
    val fieldDoc : Document = Document("_id" -> newId.toString, "field" -> field)

    observableHandler(gameCollection.insertOne(fieldDoc))
  }
  */

  override def create(json: JsValue): Unit = {

    val field = (json \ "field").as[Array[Boolean]].toList
    val fieldDoc: Document = Document("field" -> field)

    observableHandler(gameCollection.insertOne(fieldDoc))
  }

  override def read(): String = {

    val field = Await.result(gameCollection.find().first().head(), atMost = 10.second)
    field.toJson()
  }

  override def update(): Unit = {

  }

  override def delete(): Unit = {
      //gameCollection.deleteOne(equal("_id", fieldDoc))
  }

  private def observableHandler(observable: SingleObservable[Completed]) : Unit = {
    observable.subscribe(new Observer[Completed] {
      override def onNext(result: Completed): Unit = println(s"onNext: $result")
      override def onError(e: Throwable): Unit = println(s"onError: $e")
      override def onComplete(): Unit = println("onComplete")
    })
  }

  private def observableHandlerUpdate(observable: SingleObservable[UpdateResult]) : Unit = {
    observable.subscribe(new Observer[UpdateResult] {
      override def onNext(result: UpdateResult): Unit = println(s"onNext: $result")
      override def onError(e: Throwable): Unit = println(s"onError: $e")
      override def onComplete(): Unit = println("onComplete")
    })
  }

}
