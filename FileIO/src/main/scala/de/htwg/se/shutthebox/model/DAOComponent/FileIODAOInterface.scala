package de.htwg.se.shutthebox.model.DAOComponent

import play.api.libs.json.JsValue

trait FileIODAOInterface {

  def create(field : JsValue): Unit
  def read(): String
  def update(): Unit
  def delete(): Unit

}
