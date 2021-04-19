package de.htwg.se.shutthebox.model.fieldComponent

import de.htwg.se.shutthebox.model.fieldComponent.fieldBaseImpl.Cell
import play.api.libs.json.JsValue

trait fieldInterface {
  def field : Array[Cell]
  def shut(number:Integer, field:fieldInterface) : cellInterface
  def toString : String
}

