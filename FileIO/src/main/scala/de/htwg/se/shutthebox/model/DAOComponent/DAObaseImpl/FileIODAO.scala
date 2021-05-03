package de.htwg.se.shutthebox.model.DAOComponent.DAObaseImpl

import de.htwg.se.shutthebox.model.DAOComponent.FileIODAOInterface
import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import play.api.libs.json.JsValue
import slick.jdbc
import slick.dbio.DBIO
import slick.lifted.TableQuery
import slick.jdbc.JdbcBackend.Database
import slick.jdbc.MySQLProfile.api._

//import scala.concurrent.Await
import scala.concurrent.duration.DurationInt
import scala.concurrent.{Await, ExecutionContextExecutor}

case class FileIODAO() extends FileIODAOInterface{
  implicit val system: ActorSystem[Nothing] = ActorSystem(Behaviors.empty, "my-system")
  implicit val executionContext: ExecutionContextExecutor = system.executionContext

  val db: jdbc.JdbcBackend.DatabaseDef = Database.forURL(
    url = "jdbc:mysql://localhost:3306/fileiodb?serverTimezone=UTC",
    user = "fileiodbuser",
    password = "Abc123",
    driver = "com.mysql.cj.jdbc.Driver",
  )
  println("Connect to: FIELLLLLLLLLLLD: ")

  val fieldSchema = TableQuery[FieldSchema]
  val diceSchema = TableQuery[DiceSchema]

  val setup = DBIO.seq((
    fieldSchema.schema
      ++ diceSchema.schema
  ).createIfNotExists)

  override def create(json: JsValue): Unit = {
    Await.result(db.run(setup), atMost = 10.second)
    println("deine mama hat eine datenbank :)")

    initFieldTable(_, json, fieldSchema)


  }

  override def read(): AnyRef = ???

  override def update(): Unit = ???

  override def delete(): Unit = ???

  private def initFieldTable(id: Int, json: JsValue, query: TableQuery[FieldSchema]) : Unit = {
    val updateQuery = {
      query.filter(_.id === id).exists.result.flatMap(exists =>
        if (!exists) {
          val field = (json \ "field").as[Array[Boolean]]
          query += (id,field(1), field(2), field(3), field(4), field(5), field(6),
                    field(7), field(8), field(9), field(10), field(11), field(12))
        } else {
          DBIO.successful(None)
        }
      ).transactionally
    }
    Await.result(db.run(updateQuery), atMost = 10.second)
  }
}
