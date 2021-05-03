package de.htwg.se.shutthebox.model.DAOComponent.DAObaseImpl
import akka.actor.TypedActor.dispatcher
import de.htwg.se.shutthebox.model.DAOComponent.PlayerDAOInterface
import slick.jdbc
//import slick.jdbc

//import slick.jdbc.PostgresProfile
//import slick.dbio.DBIO
//import slick.jdbc.JdbcBackend.Database
//import slick.lifted.TableQuery
//import slick.jdbc.PostgresProfile.api._
//import slick.jdbc.JdbcBackend
//import slick.jdbc.JdbcBackend.Database


import slick.jdbc.JdbcBackend
import slick.jdbc.JdbcBackend.Database
import slick.lifted.TableQuery
import slick.jdbc.MySQLProfile.api._
import scala.concurrent.{Await, ExecutionContextExecutor}
import scala.concurrent.duration.{Duration, DurationInt}

case class PlayerDAO() extends PlayerDAOInterface {

  //val db = Database.forConfig("db.conf")
  //val player = TableQuery[PlayerSchema]
  //val ddl = (PlayerSchema.ddl)
  //val connectionUrl = "jdbc:postgresql://localhost/my-db?user=postgres&password=postgres"

  val db: jdbc.JdbcBackend.DatabaseDef = Database.forURL(
    url = "jdbc:mysql://localhost/playerdb",
    user = "playerdbuser",
    password = "Abc123",
    driver = "com.mysql.cj.jdbc.Driver",
  )



  val playertablequery = TableQuery[PlayerSchema]

  /*val setup = DBIO.seq(
    (playertablequery.schema).create,
      playertablequery += (100, 20),
    playertablequery += (200, 10)

  )*/

  val setup = DBIO.seq((
    playertablequery.schema
    ).createIfNotExists,
  )

  //val setupFuture = db.run(setup)


  override def create(): Unit = {
    initPlayerTable(1, 20, playertablequery)
  }

  override def read(): AnyRef = ???

  override def update(): Unit = ???

  override def delete(): Unit = ???


  private def initPlayerTable(id: Int, score: Int, query: TableQuery[PlayerSchema]): Unit = {
    val updateQuery = {
      query.filter(_.id === id).exists.result.flatMap(exists =>
        if (!exists) {
          query += (id, score)
        } else {
          DBIO.successful(None)
        }
      ).transactionally
    }
    Await.result(db.run(updateQuery), atMost = 10.second)
  }

}
