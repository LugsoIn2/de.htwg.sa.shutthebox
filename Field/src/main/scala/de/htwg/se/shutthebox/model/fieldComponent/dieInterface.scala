package de.htwg.se.shutthebox.model.fieldComponent

import play.api.libs.json.JsValue

trait dieInterface {
  def start:Int
  def end:Int
  def value:Int

  def roll:dieInterface
}
