package de.htwg.se.shutthebox.model.fieldComponent.fieldBaseImpl

import org.scalatest._

class FieldTest extends WordSpec with Matchers {

  val field = new Field()
  /*
  "A Field" should {
    "a value" in {
      field shouldBe a [Field]
      field.field shouldBe a [Array[_]]
      field.shut(1, field) shouldBe a [Cell]
      field.toString shouldBe a [String]
    }
  }*/

  "A Field" when {
    "is set an Array as parameter" should {
      val field = Field(Array[Cell](Cell(), Cell()))
      "have a array size nine" in {
      field.field.length should be (2)
      }
      /*
      "should be from type Field" in {
        field should be [Field]
      }
      "field.field should be from type Array" in {
        field.field should be [Array]
      }
      "field.shut(1. field) should be from type Cell" in {
        field.shut(1, field) should be [Cell]
      }
      "field.toString should be from type String" in {
        field.toString should be [String]
      }*/
    }
  }

}
