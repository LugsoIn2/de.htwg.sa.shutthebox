package de.htwg.se.shutthebox.model.fieldComponent

trait dieInterface {
  def start:Int
  def end:Int
  def value:Int

  def roll:dieInterface
}
