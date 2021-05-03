package de.htwg.se.shutthebox.model.DAOComponent
//import slick.model.Table
import play.api.libs.json.JsValue

import scala.concurrent.{Await, Future}
import scala.concurrent.duration.Duration
import slick.jdbc.H2Profile.api._

import java.sql.Date
import scala.reflect.ClassTag
import slick.jdbc.PostgresProfile.api._

trait PlayerDAOInterface  {

  def create(): Unit
  def read(): Object
  def update(): Unit
  def delete(): Unit

}
