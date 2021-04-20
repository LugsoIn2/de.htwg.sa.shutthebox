package de.htwg.se.shutthebox.model.fileIoComponent

import de.htwg.se.shutthebox.model.fieldComponent.fieldInterface
import play.api.libs.json.{JsObject, JsValue}

trait FileIOInterface {
  def load: Unit
  //def save(field : Array[Boolean]) : Unit
  def save(field : JsValue) : Unit
}
