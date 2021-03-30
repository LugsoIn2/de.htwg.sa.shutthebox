package de.htwg.se.shutthebox.model.fieldComponent.fieldBaseImpl

import org.scalatest.Matchers.be
import org.scalatest._

class FieldTest extends WordSpec with Matchers {

  "A Field" when {
    "is set with array with two cells as parameter" should {
      val field = Field(Array[Cell](Cell(), Cell()))
      "have array size two" in {
        field.field.length should be (2)
      }
    }

    "is set without parameter" should {
      val field = new Field()
      "have a array size nine" in {
      field.field.length should be (9)
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
