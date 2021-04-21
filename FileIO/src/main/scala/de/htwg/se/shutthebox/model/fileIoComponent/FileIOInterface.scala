package de.htwg.se.shutthebox.model.fileIoComponent

import play.api.libs.json.{JsObject, JsValue}

trait FileIOInterface {
  def load: JsValue
  //def save(field : Array[Boolean]) : Unit
  def save(field : JsValue) : Unit
}
