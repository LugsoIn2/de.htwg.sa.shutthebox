package de.htwg.se.shutthebox.model

import java.io.ByteArrayInputStream

import de.htwg.se.shutthebox.model.playerComponent.playerImpl.Player
import org.scalatest._

class PlayerTest extends WordSpec with Matchers {

  val player = new Player("Player1", 0)

  "A Player" should {
    "a value" in {
      player.name shouldBe a[String]
      player.score shouldBe a [Int]
      player.updateScore(1) shouldBe a [Player]
    }
  }
}
