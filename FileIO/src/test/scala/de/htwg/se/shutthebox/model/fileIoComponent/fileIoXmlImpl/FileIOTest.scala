package de.htwg.se.shutthebox.model.fileIoComponent.fileIoXmlImpl

//FIXME import de.htwg.se.shutthebox.model.fieldComponent.fieldBaseImpl.Field
import org.scalatest.{Matchers, WordSpec}
import play.api.libs.json.JsObject

class FileIOTest extends WordSpec with Matchers {
  "FileIO" when {
    val fileIO = new FileIO
    "should save fieldInterface" in {
      //FIXME fileIO.save(new Field()) should be ()
    }
    "should convert to a JsonObject" in {
      //FIXME fileIO.fieldToXml(new Field()) shouldBe a [JsObject]
    }

  }
}
