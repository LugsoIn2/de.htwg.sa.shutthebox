package de.htwg.se.shutthebox.model.DAOComponent.DAObaseImpl

import de.htwg.se.shutthebox.model.DAOComponent.FileIODAOInterface
import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import play.api.libs.json.{JsObject, JsValue}
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
  println("Connect to: FieldDatabase ")

  val fieldSchema = TableQuery[FieldSchema]
  val diceSchema = TableQuery[DiceSchema]

  val setup = DBIO.seq((
    fieldSchema.schema
      ++ diceSchema.schema
  ).createIfNotExists)

  override def create(json: JsValue): Unit = {
    Await.result(db.run(setup), atMost = 10.second)
    val field = (json \ "field").as[Array[Boolean]]

    if (field.length == 9) {
      val insertqueryfield = DBIO.seq(fieldSchema += (1,field(0), field(1), field(2), field(3), field(4), field(5), field(6), field(7), field(8), None, None,None))
      Await.result(db.run(insertqueryfield), atMost = 10.second)
    } else {
      val insertqueryfield = DBIO.seq(fieldSchema += (1,field(0), field(1), field(2), field(3), field(4), field(5), field(6), field(7), field(8), Some(field(9)), Some(field(10)), Some(field(11))))
      Await.result(db.run(insertqueryfield), atMost = 10.second)
    }

    val dices = (json \ "dice").as[JsObject]
    val insertquerydice = DBIO.seq(diceSchema += (1, (dices \ "die1").as[Int], (dices \ "die2").as[Int]))
    Await.result(db.run(insertquerydice), atMost = 10.second)
  }

  override def read(): String = {
    val resultdice = Await.result(db.run(diceSchema.sortBy(_.id.desc).take(1).result), atMost = 10.second)
    val resultfield = Await.result(db.run(fieldSchema.sortBy(_.id.desc).take(1).result), atMost = 10.second)

    var field = "[" + resultfield.head._2 + "," + resultfield.head._3 + "," + resultfield.head._4 + "," +
                      resultfield.head._5 + "," + resultfield.head._6 + "," + resultfield.head._7 + "," +
                      resultfield.head._8 + "," + resultfield.head._9 + "," + resultfield.head._10
    if (resultfield.head._11.isDefined && resultfield.head._12.isDefined && resultfield.head._13.isDefined) {
      field = field + "," + resultfield.head._11.get + "," + resultfield.head._12.get + "," + resultfield.head._13.get + "]"
    } else {
      field = field + "]"
    }
    val jsonString: String = {
      """
      {
          "field": """ + field + """,
          "dice" : {
            "die1" : """ + resultdice.head._1 + """,
            "die2" : """ + resultdice.head._2 + """
          }
      }
      """.stripMargin

    }
    jsonString
  }
  override def update(): Unit = ???

  override def delete(): Unit = ???

  private def initFieldTable(id: Int, json: JsValue, query: TableQuery[FieldSchema]) : Unit = {
    val updateQuery = {
      query.filter(_.id === id).exists.result.flatMap(exists =>
        if (!exists) {
          val field = (json \ "field").as[Array[Boolean]]

          if (field.length == 9) {
            query += (id, field(0), field(1), field(2), field(3), field(4), field(5),
              field(6), field(7), field(8), None, None, None)
          } else {
            val field = (json \ "field").as[Array[Boolean]]
            query += (id, field(0), field(1), field(2), field(3), field(4), field(5),
              field(6), field(7), field(8), Some(field(9)), Some(field(10)), Some(field(11)))
          }
        } else {
          DBIO.successful(None)
        }
      ).transactionally
    }
    Await.result(db.run(updateQuery), atMost = 10.second)
  }

}
