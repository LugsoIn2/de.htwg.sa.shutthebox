package de.htwg.se.shutthebox.model.fieldComponent.fieldBaseImpl

import de.htwg.se.shutthebox.model.fieldComponent.cellInterface

case class Cell(value: Int =  1, isShut: Boolean = false) extends cellInterface :
    override def toString : String = this.value + " " + isShut


