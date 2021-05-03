package de.htwg.se.shutthebox.model.DAOComponent.DAObaseImpl

import de.htwg.se.shutthebox.model.DAOComponent.PlayerDAOInterface
import slick.dbio.DBIO
import slick.jdbc.JdbcBackend.Database
import slick.lifted.TableQuery
import slick.jdbc.PostgresProfile.api._



class PlayerDAO extends PlayerDAOInterface {

  val db = Database.forConfig("application.conf")
  //val player = TableQuery[PlayerSchema]
  //val ddl = (PlayerSchema.ddl)
  val playertablequery = TableQuery[PlayerSchema]

  val setup = DBIO.seq(
    (playertablequery.schema).create,
      playertablequery += (100, 20),
    playertablequery += (200, 10)

  )


  override def create(): Unit = ???

  override def read(): AnyRef = ???

  override def update(): Unit = ???

  override def delete(): Unit = ???

}
