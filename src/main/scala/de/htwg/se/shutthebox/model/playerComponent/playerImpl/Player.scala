package de.htwg.se.shutthebox.model.playerComponent.playerImpl

import de.htwg.se.shutthebox.model.playerComponent.playerInterface

case class Player(name: String, score: Int = 0) extends playerInterface {

  override def updateScore(newScore: Int): playerInterface = copy(score = newScore)

}
