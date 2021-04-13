package de.htwg.se.shutthebox.model.fieldComponent.fieldBaseImpl

import de.htwg.se.shutthebox.model.fieldComponent.dieInterface

//Dice to roll
case class Die(start:Int = 1, end:Int = 6, value:Int = 1) extends dieInterface {

  override def roll: dieInterface = {
    val newDie = this.copy(value = start + scala.util.Random.nextInt(end - start) + 1)
    newDie
  }

  override def toString : String = {
    value match {
      case 1 =>
        """
          |╔═════════╗
          |║         ║
          |║    O    ║
          |║         ║
          |╚═════════╝
          |""".stripMargin
      case 2 =>
        """
          |╔═════════╗
          |║ O       ║
          |║         ║
          |║       O ║
          |╚═════════╝
          |""".stripMargin
      case 3 =>
        """
          |╔═════════╗
          |║ O       ║
          |║    O    ║
          |║       O ║
          |╚═════════╝
          |""".stripMargin
      case 4 =>
        """
          |╔═════════╗
          |║ O     O ║
          |║         ║
          |║ O     O ║
          |╚═════════╝
          |""".stripMargin
      case 5 =>
        """
          |╔═════════╗
          |║ O     O ║
          |║    O    ║
          |║ O     O ║
          |╚═════════╝
          |""".stripMargin
      case 6 =>
        """
          |╔═════════╗
          |║ O     O ║
          |║ O     O ║
          |║ O     O ║
          |╚═════════╝
          |""".stripMargin
    }
  }
}
