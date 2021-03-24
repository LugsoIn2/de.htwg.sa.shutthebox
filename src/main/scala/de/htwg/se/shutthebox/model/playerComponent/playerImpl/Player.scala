package de.htwg.se.shutthebox.model.playerComponent.playerImpl

import de.htwg.se.shutthebox.model.playerComponent.playerInterface

case class Player(name: String, score: Int = 0) extends playerInterface {

  /*
  def setName(index:Integer) : String = {
    plrName = "Player " + index
    plrName
  }

  def updateScore(n:Integer) : Integer = {
    score = n
    score
  }*/
  override def updateScore(newScore: Int): Player = {
    val newPlayer = copy(this.name, newScore)
    return newPlayer
  }
}
