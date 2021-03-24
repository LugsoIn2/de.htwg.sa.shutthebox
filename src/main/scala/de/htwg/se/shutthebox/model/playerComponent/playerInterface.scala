package de.htwg.se.shutthebox.model.playerComponent

trait playerInterface {
  
  def name:String
  def score:Int

  def updateScore(score: Int): playerInterface
  
}
