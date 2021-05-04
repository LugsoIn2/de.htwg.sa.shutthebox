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

    //Theoretisch würde das reichen und wir nehmen dann beim load immer das mit der höchsten ID
    //also das zuletzt gespeicherte
    //funzt auch genauso wie methode 2 unten
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



    //oder das bringt aber nicht viel, da auto encrease von db gemacht wird
    //initFieldTable(0, json, fieldSchema)
  }

  override def read(): String = {
    val resultdice = Await.result(db.run(diceSchema.sortBy(_.id.desc).take(1).result), atMost = 10.second)
    val resultfield = Await.result(db.run(fieldSchema.sortBy(_.id.desc).take(1).result), atMost = 10.second)

    println("YIELD:" + resultfield)
    println("YIELD:" + resultfield.head)
    println("YIELD:" + resultfield.head._1)
    println("YIELD:" + resultfield.head._2)
    println("LENGTHSDDSD:" + resultfield.length)
    /*
    var field: Array[Boolean] = Array()
    val tmp = resultfield.head
    field :+  resultfield.head._2
    field :+  tmp._3
    field :+  tmp._4
    field :+  tmp._5
    field :+  tmp._6
    field :+  tmp._7
    field :+  tmp._8
    field :+  tmp._9
    field :+  tmp._10

    if (tmp._11.isDefined) {
      field :+  tmp._11.asInstanceOf[Boolean]
      field :+  tmp._12.asInstanceOf[Boolean]
      field :+  tmp._13.asInstanceOf[Boolean]
    }*/
    var field = "[" + resultfield.head._2 + "," + resultfield.head._3 + "," + resultfield.head._4 + "," +
                      resultfield.head._5 + "," + resultfield.head._6 + "," + resultfield.head._7 + "," +
                      resultfield.head._8 + "," + resultfield.head._9 + "," + resultfield.head._10
    if (resultfield.head._11.isDefined && resultfield.head._12.isDefined && resultfield.head._13.isDefined) {
      field = resultfield.head._11 + "," + resultfield.head._12 + "," + resultfield.head._13 + "]"
    } else {
      field = field + "]"
    }
    //"field": """ + field.mkString("[", ", ", "]") + """,
    println(field)
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
    println("jsonString" + jsonString)
    jsonString
  }
  override def update(): Unit = ???

  override def delete(): Unit = ???

  /*private def initFieldTable(id: Int, json: JsValue, query: TableQuery[FieldSchema]) : Unit = {
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
  }*/

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
