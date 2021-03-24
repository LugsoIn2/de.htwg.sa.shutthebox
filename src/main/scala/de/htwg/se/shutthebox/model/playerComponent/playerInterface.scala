package de.htwg.se.shutthebox.model.playerComponent

trait playerInterface {
  
  def name:String
  def score:Int

  def setName(name: String): playerInterface
  def updateScore(score: Int): playerInterface
  
}
