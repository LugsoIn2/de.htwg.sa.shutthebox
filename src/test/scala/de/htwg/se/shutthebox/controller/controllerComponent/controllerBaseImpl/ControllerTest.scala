package de.htwg.se.shutthebox.controller.controllerComponent.controllerBaseImpl

//FIXME import de.htwg.se.shutthebox.model.fieldComponent.fieldAdvancedImpl.BigField
//FIXME import de.htwg.se.shutthebox.model.fieldComponent.fieldBaseImpl.{Die, Field}
//FIXME import de.htwg.se.shutthebox.model.fieldComponent.fieldInterface
import de.htwg.se.shutthebox.util.UndoManager
import de.htwg.se.shutthebox.model.playerComponent.playerImpl.Player
import org.scalatest._

import scala.runtime.BoxedUnit
import scala.util.{Failure, Success, Try}

class ControllerTest extends WordSpec with Matchers {
  "A Controller" when {
    "empty" should {
      //FIXME val matchfield = new Field()
      //FIXME val matchfield2 = new BigField()
      val undoManager = new UndoManager
      //FIXME val dice = Array(new Die, new Die)
      val controller = new Controller()




      "a value" in {
        controller.startGame(0, ai = false) shouldBe a [BoxedUnit]
        controller.createField(0) shouldBe a [BoxedUnit]
        controller.createField(1) shouldBe a [BoxedUnit]
        //FIXME controller.getField shouldBe a [fieldInterface]
        //controller.createDice() shouldBe a [BoxedUnit]
        controller.createPlayers(false) shouldBe a [BoxedUnit]
        controller.getPlayers shouldBe a [Array[_]]
        controller.getCurrentPlayer shouldBe a [Player]
        controller.setCurrentPlayer() shouldBe a [BoxedUnit]
        controller.getScore shouldBe a [Integer]
        controller.resetMatchfield() shouldBe a [BoxedUnit]
        controller.cmdShut(1) shouldBe a [BoxedUnit]
        controller.cmdShut(2) shouldBe a [BoxedUnit]
        controller.cmdShut(3) shouldBe a [BoxedUnit]
        controller.cmdShut(4) shouldBe a [BoxedUnit]
        controller.cmdShut(5) shouldBe a [BoxedUnit]
        controller.cmdShut(6) shouldBe a [BoxedUnit]
        controller.cmdShut(7) shouldBe a [BoxedUnit]
        controller.cmdShut(8) shouldBe a [BoxedUnit]
        controller.cmdShut(9) shouldBe a [BoxedUnit]
        controller.cmdShut(10) shouldBe a [BoxedUnit]
        controller.cmdShut(11) shouldBe a [BoxedUnit]
        controller.cmdShut(12) shouldBe a [BoxedUnit]
        controller.cmdUnShut() shouldBe a [BoxedUnit]
        controller.cmdRedoShut() shouldBe a [BoxedUnit]
        controller.redoShut() shouldBe a [BoxedUnit]
        controller.undoShut() shouldBe a [BoxedUnit]
        controller.doShut(1) match {
          case Success(value) => value shouldBe a [String]
          case Failure(exception) => exception.getMessage should startWith("")
        }
        controller.doShut(2) match {
          case Success(value) => value shouldBe a [String]
          case Failure(exception) => exception.getMessage should startWith("")
        }
        controller.doShut(3) match {
          case Success(value) => value shouldBe a [String]
          case Failure(exception) => exception.getMessage should startWith("")
        }
        controller.doShut(4) match {
          case Success(value) => value shouldBe a [String]
          case Failure(exception) => exception.getMessage should startWith("")
        }
        controller.doShut(5) match {
          case Success(value) => value shouldBe a [String]
          case Failure(exception) => exception.getMessage should startWith("")
        }
        controller.doShut(6) match {
          case Success(value) => value shouldBe a [String]
          case Failure(exception) => exception.getMessage should startWith("")
        }
        controller.doShut(7) match {
          case Success(value) => value shouldBe a [String]
          case Failure(exception) => exception.getMessage should startWith("")
        }
        controller.doShut(8) match {
          case Success(value) => value shouldBe a [String]
          case Failure(exception) => exception.getMessage should startWith("")
        }
        controller.doShut(9) match {
          case Success(value) => value shouldBe a [String]
          case Failure(exception) => exception.getMessage should startWith("")
        }
        controller.doShut(10) match {
          case Success(value) => value shouldBe a [String]
          case Failure(exception) => exception.getMessage should startWith("")
        }
        controller.doShut(11) match {
          case Success(value) => value shouldBe a [String]
          case Failure(exception) => exception.getMessage should startWith("")
        }
        controller.doShut(12) match {
          case Success(value) => value shouldBe a [String]
          case Failure(exception) => exception.getMessage should startWith("")
        }
        /*controller.doShut(1) shouldBe a [String]
        controller.doShut(2) shouldBe a [String]
        controller.doShut(3) shouldBe a [String]
        controller.doShut(4) shouldBe a [String]
        controller.doShut(5) shouldBe a [String]
        controller.doShut(6) shouldBe a [String]
        controller.doShut(7) shouldBe a [String]
        controller.doShut(8) shouldBe a [String]
        controller.doShut(9) shouldBe a [String]
        controller.doShut(10) shouldBe a [String]
        controller.doShut(11) shouldBe a [String]
        controller.doShut(12) shouldBe a [String]*/
        controller.shut(1) shouldBe a [BoxedUnit]
        controller.shut(2) shouldBe a [BoxedUnit]
        controller.shut(3) shouldBe a [BoxedUnit]
        controller.shut(4) shouldBe a [BoxedUnit]
        controller.shut(5) shouldBe a [BoxedUnit]
        controller.shut(6) shouldBe a [BoxedUnit]
        controller.shut(7) shouldBe a [BoxedUnit]
        controller.shut(8) shouldBe a [BoxedUnit]
        controller.shut(9) shouldBe a [BoxedUnit]
        controller.shut(10) shouldBe a [BoxedUnit]
        controller.shut(11) shouldBe a [BoxedUnit]
        controller.shut(12) shouldBe a [BoxedUnit]
        controller.calcValidShuts() shouldBe a [BoxedUnit]
        controller.add(5, 1) should be (6)
        controller.sub(5, 1) should be (4)
        controller.div(4, 2) should be (2)
        controller.mult(2,2) should be (4)
        controller.calcDice(controller.add) should be (2)
        //controller.calcSum shouldBe a [Integer]
        //controller.calcDiff shouldBe a [Integer]
        //controller.calcProd shouldBe a [Integer]
        //controller.calcDiv shouldBe a [Integer]
        //FIXME
        /*controller.rollDice match {
          case Success(value) => value shouldBe a [String]
          case Failure(exception) => exception.getMessage should startWith("")
        }*/
        //controller.rollDice shouldBe a [String]
        controller.printOutput shouldBe a [String]
        controller.fieldToString shouldBe a [String]
        controller.rollToString shouldBe a [String]
        controller.save shouldBe a [BoxedUnit]
        controller.load shouldBe a [BoxedUnit]
        controller.update shouldBe a [BoxedUnit]
      }



      "handle undo/redo of solving a grid correctly" in {
        controller.cmdShut(1)

      }



      //controller.add(observer)
      "notify its Observer after creation" in {
        controller.createField(0) shouldBe a [BoxedUnit]
        //        observer.updated should be(true)
        //FIXME controller.matchfield shouldBe a[Field]
        //FIXME matchfield.field shouldBe a[Array[_]]
      }
      "notify its Observer after dice creation" in {
        //controller.createDice() shouldBe a [BoxedUnit]
        //        observer.updated should be(true)
        controller.dice shouldBe a[Array[_]]
        //controller.dice(0).start should be(1)
        //controller.dice(0).end should be(6)
        //controller.dice(1).start should be(1)
        //controller.dice(1).end should be(6)
      }
      "notify its Observer after creating players" in {
        controller.createPlayers(false) shouldBe a [BoxedUnit]
        controller.players(0).name shouldBe a[String]
        controller.players(0).score shouldBe a[Integer]
        controller.players(1).name shouldBe a[String]
        controller.players(1).score shouldBe a[Integer]
        //        observer.updated should be(true)

      }


      //      "notify its Observer after setting current player" in {
      //        controller.setCurrentPlayer() shouldBe a[BoxedUnit]
      //        controller.setCurrentPlayer() shouldBe a[BoxedUnit]
      //        observer.updated should be(true)
      //      }
      //      "notify its Observer after matchfieldToString" in {
      //        controller.fieldToString shouldBe a[String]
      //        observer.updated should be(true)
      //      }
      //      "notify its Observer after dice roll" in {
      //        controller.rollDice() shouldBe a [BoxedUnit]
      //        observer.updated should be(true)
      //      }

      "notify its Observer after shut" in {
        controller.shut(1) shouldBe a [BoxedUnit]
        //        observer.updated should be(true)
      }
      "notify its Observer after rollToString" in {
        controller.rollToString shouldBe a[String]
        //        observer.updated should be(true)
      }


    }
  }
}
