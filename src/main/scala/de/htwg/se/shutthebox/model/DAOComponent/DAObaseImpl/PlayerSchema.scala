package de.htwg.se.shutthebox.model.DAOComponent.DAObaseImpl

import slick.jdbc.PostgresProfile.api._


class PlayerSchema(tag: Tag) extends Table[(Int, Int)] (tag,"playertable"){
  //column
  def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
  def score = column[Int]("score")

  def * = (id, score)

}

