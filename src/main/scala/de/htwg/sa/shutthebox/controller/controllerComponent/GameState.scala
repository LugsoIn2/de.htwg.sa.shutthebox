package de.htwg.se.shutthebox.controller.controllerComponent

/*
object GameState extends Enumeration {
  type GameState = Value
  val MENU, INGAME, ROLLDICE, SHUT, UNDOSTATE = Value

  val map = Map[GameState, String](
    MENU -> "",
    INGAME -> "ingame",
    //STARTGAME -> "ingame",
    ROLLDICE -> "Player can roll",
    SHUT -> "Player can shut",
    UNDOSTATE -> "Undo")

    def message(gameState: GameState) = {
      map(gameState)
    }
}
*/

enum GameState(msg: String):
  def message = msg
  
  case MENU extends GameState("")
  case INGAME extends GameState("Ingame")  
  case ROLLDICE extends GameState("Player can roll")
  case SHUT extends GameState("Player can shut")
  case UNDOSTATE extends GameState("Undo")
end GameState