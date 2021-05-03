package de.htwg.se.shutthebox.model.DAOComponent.DAObaseImpl

import slick.jdbc.MySQLProfile.api._

class DiceSchema (tag: Tag) extends Table[(Int, Int, Int)] (tag,"dicetable") {

  def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
  def dice1 = column[Int]("dice1")
  def dice2 = column[Int]("dice2")

  override def * =
    (id, dice1, dice2)

}
