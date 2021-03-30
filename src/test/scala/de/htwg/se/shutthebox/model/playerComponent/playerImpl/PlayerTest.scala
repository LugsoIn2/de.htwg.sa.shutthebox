package de.htwg.se.shutthebox.model.playerComponent.playerImpl

import org.scalatest.FunSuite
import de.htwg.se.shutthebox.model.playerComponent.playerImpl.Player
import de.htwg.se.shutthebox.model.playerComponent.playerInterface
import org.scalatest._

class PlayerTest extends WordSpec with Matchers {

  /*
  "A Player" should {
    "a value" in {
      player.name shouldBe a[String]
      player.score shouldBe a [Int]
      player.updateScore(1) shouldBe a [Player]
    }
  }*/

  "A Player" when {
    "not set to any value" should {
      val player = Player("")
      "have empty name and score 0" in {
        player.name should be ("")
        player.score should be (0)
      }
      "if added a player name \"Player1\" and score 20 " in {
        val playerOne = Player("Player1", 20)
        playerOne.name should be ("Player1")
        playerOne.score should be (20)
      }
      "if updatePlayer score to 10" in {
        val playerScore = Player("Player1")
        val updatePlayer = playerScore.updateScore(10)
        updatePlayer.score should be (10)
      }
    }
  }
}
