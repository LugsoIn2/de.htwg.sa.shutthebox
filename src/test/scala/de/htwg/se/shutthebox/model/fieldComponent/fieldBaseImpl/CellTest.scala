package de.htwg.se.shutthebox.model.fieldComponent.fieldBaseImpl

import org.scalatest._

class CellTest extends WordSpec with Matchers {
  val cell: Cell = Cell()

  "A Cell" when {
    "is set without any parameters" should {
      val cell = Cell()
      "have value 1 and isShut false" in {
        cell.value should be (1)
        cell.isShut should be (false)
      }
    }
    "is set with value 1 and isShut true" should {
      val cell = Cell(isShut = true)
      "have value 1 and isShut true" in {
        cell.value should be (1)
        cell.isShut should be (true)
      }
    }
  }

}
