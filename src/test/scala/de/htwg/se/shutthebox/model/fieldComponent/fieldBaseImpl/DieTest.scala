package de.htwg.se.shutthebox.model.fieldComponent.fieldBaseImpl

import de.htwg.se.shutthebox.model.fieldComponent.dieInterface
import org.scalatest._

class DieTest extends WordSpec with Matchers{
  val die: Die = Die()

  "A Die" when{
    "is created without parameter" should {
      "have start = 1, end = 6 and value = 1" in {
        die.start should be (1)
        die.end should be (6)

        die.roll.value should be >= 1
        die.roll.value should be <= 6

        die.value should be >= 1
        die.value should be <= 6
        die.toString shouldBe a [String]

      }
    }
    "is created with value 2" should {
      "have value 2" in {
        val die = Die(value = 2)
        die.value should be(2)

        die.value should be >= 1
        die.value should be <= 6
        die.toString shouldBe a [String]
      }
    }
    "is created with value 3" should {
      "have value 3" in {
        val die= Die(value = 3)
        die.value should be (3)

        die.value should be >= 1
        die.value should be <= 6
        die.toString shouldBe a [String]
      }
    }
    "is created with value 4" should {
      "have value 4" in {
        val die= Die(value = 4)
        die.value should be (4)

        die.value should be >= 1
        die.value should be <= 6
        die.toString shouldBe a [String]
      }
    }
    "is created with value 5" should {
      "have value 5" in {
        val die= Die(value = 5)
        die.value should be (5)

        die.value should be >= 1
        die.value should be <= 6
        die.toString shouldBe a [String]
      }
    }
    "is created with value 6" should {
      "have value 6" in {
        val die= Die(value = 6)
        die.value should be (6)

        die.value should be >= 1
        die.value should be <= 6
        die.toString shouldBe a [String]
      }
    }

  }


}
