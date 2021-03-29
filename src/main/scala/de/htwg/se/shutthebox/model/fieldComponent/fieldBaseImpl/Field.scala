package de.htwg.se.shutthebox.model.fieldComponent.fieldBaseImpl

import de.htwg.se.shutthebox.model.fieldComponent.{cellInterface, fieldInterface}

// Field, which implements 9 cells in List
case class Field(field:Array[Cell]) extends fieldInterface {
  /*
  override val field:Array[Cell] = Array.ofDim[Cell](9)
  for (i <- 1 to 9) {
    field(i - 1) = Cell(i)
    //field(i - 1).value = i
  }*/

  def this() = {
    this(Array.ofDim[Cell](9))
    for (i <- 1 to 9) {
      field(i - 1) = Cell(i)
    }
  }

  override def shut(number:Integer, field:fieldInterface) : cellInterface = {
    if (!field.field(number-1).isShut) {
      //field.field(number-1).isShut = true
      field.field(number - 1) = field.field(number - 1).copy(isShut = true)
    }
    field.field(number-1)
  }

  override def toString : String = {
    var output = ""
    output += "\n|=============================================|\n "
    for (i <- 0 to 8) {
      if (!field(i).isShut) {
       output += i + 1 + "    "
      } else {
        output += "     "
      }
    }
    output += "\n|---------------------------------------------|\n "
    for (i <- 0 to 8) {
      if (field(i).isShut) {
        output += i + 1 + "    "
      } else {
        output += "     "
      }
    }
    output += "\n|=============================================|\n"

    output
  }
}
