package de.htwg.se.shutthebox.model.fileIoComponent.fileIoXmlImpl

import com.google.inject.Guice
import com.google.inject.name.Names
import net.codingwell.scalaguice.InjectorExtensions._
import de.htwg.se.shutthebox.ShutTheBoxModule
import de.htwg.se.shutthebox.model.fieldComponent.fieldInterface
import de.htwg.se.shutthebox.model.fileIoComponent.FileIOInterface
import play.api.libs.json.{JsNumber, JsObject, JsValue, Json}

import scala.xml._
import scala.io.Source
import scala.xml.{NodeSeq, PrettyPrinter}


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
