package de.htwg.se.shutthebox.aview
import de.htwg.se.shutthebox.aview._
import de.htwg.se.shutthebox.controller._
import de.htwg.se.shutthebox.controller.controllerComponent.controllerBaseImpl.Controller
import de.htwg.se.shutthebox.model._
//FIXME import de.htwg.se.shutthebox.model.fieldComponent.fieldBaseImpl.{Die, Field}
import de.htwg.se.shutthebox.model.playerComponent.playerImpl.Player
import org.scalatest._

import scala.runtime.BoxedUnit


class TUITest extends WordSpec with Matchers {
  //FIXME val matchfield = new Field()
  //FIXME val dice:Array[Die] = Array.ofDim[Die](2)
  val players:Array[Player] = Array.ofDim[Player](2)
  val controller = new Controller()
  controller.createField(0)
  controller.createPlayers(true)
  val tui = new TUI(controller)

  "A TUI" should {
    "a value" in {
      tui shouldBe a [TUI]
      tui.printHeader() shouldBe a [String]
      //tui.nextPlayer() shouldBe a [BoxedUnit]
      tui.printStartGame() shouldBe a [String]
      tui.printScoreBoard() shouldBe a [String]
      tui.printRules() shouldBe a [String]
      tui.processInputLine("input") shouldBe a [String]
    }
  }
}


