package de.htwg.se.shutthebox.model.fileIoComponent.fileIoJsonImpl

//FIXME import de.htwg.se.shutthebox.model.fieldComponent.fieldBaseImpl.Field
//import de.htwg.se.shutthebox.model.fieldComponent.fieldInterface
import org.scalatest.Matchers.be
import org.scalatest._
import play.api.libs.json.JsObject

class FileIOTest extends WordSpec with Matchers {

  "FileIO" when {
    val fileIO = new FileIO
    "should load fieldInterface" in {
      //FIXME fileIO.load shouldBe a [fieldInterface]
    }
    "should save fieldInterface" in {
      //FIXME fileIO.save(new Field()) should be ()
    }
    "should convert to a JsonObject" in {
      //FIXME fileIO.fieldToJson(new Field()) shouldBe a [JsObject]
    }

  }
}
