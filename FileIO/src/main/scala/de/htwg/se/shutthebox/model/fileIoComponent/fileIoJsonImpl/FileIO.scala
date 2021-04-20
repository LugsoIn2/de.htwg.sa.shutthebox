package de.htwg.se.shutthebox.model.fileIoComponent.fileIoJsonImpl

import com.google.inject.Guice
import com.google.inject.name.Names
import net.codingwell.scalaguice.InjectorExtensions._
import de.htwg.se.shutthebox.ShutTheBoxModule
import de.htwg.se.shutthebox.model.fieldComponent.{cellInterface, fieldInterface}
import de.htwg.se.shutthebox.model.fileIoComponent.FileIOInterface

import scala.io.Source
import play.api.libs.json._


class FileIO extends FileIOInterface {

  override def load: JsValue = {
    val source: String = Source.fromFile("field.json").getLines.mkString
    val json: JsValue = Json.parse(source)
    json
  }

  override def save(field : JsValue): Unit = {
    import java.io._
    val pw = new PrintWriter(new File("field.json"))
    pw.write(Json.prettyPrint(field))
    pw.close
  }

}
