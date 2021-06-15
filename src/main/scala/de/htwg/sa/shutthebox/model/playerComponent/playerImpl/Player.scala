package de.htwg.se.shutthebox.model.playerComponent.playerImpl

import de.htwg.se.shutthebox.model.playerComponent.playerInterface

case class Player(name: String, score: Int = 0) extends playerInterface {

  def updateName(newName: String) : playerInterface = copy(name = newName)
  override def updateScore(newScore: Int): playerInterface = copy(score = newScore)
  
}
