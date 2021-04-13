package de.htwg.se.shutthebox.model.fieldComponent.fieldAdvancedImpl

import de.htwg.se.shutthebox.model.fieldComponent.fieldBaseImpl.Cell
import org.scalatest.{Matchers, WordSpec}

class BigFieldTest extends WordSpec with Matchers{

  val field = new BigField()

  "A BigField" when {
    "is set with array with two cells as parameter" should {
      val field = BigField(Array[Cell](Cell(), Cell()))
      "have array size two" in {
        field.field.length should be (2)
      }
    }

    "is set without parameter" should {
      val field = new BigField()
      "have a array size nine" in {
        field.field.length should be (12)
      }
      "have array field.field" in {
        field.field shouldBe a [Array[Cell]]
      }
      "have a cell in field.shut" in {
        field.shut(1, field) shouldBe a [Cell]
      }
      "have a string in field.toString" in {
        field.toString shouldBe a [String]
      }
    }
  }

}
