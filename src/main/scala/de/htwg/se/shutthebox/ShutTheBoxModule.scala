package de.htwg.se.shutthebox

import com.google.inject.AbstractModule
import com.google.inject.name.Names
import de.htwg.se.shutthebox.controller.controllerComponent.ControllerInterface
import de.htwg.se.shutthebox.controller.controllerComponent._
//import de.htwg.se.shutthebox.controller.controllerComponent.aiBaseImpl.AI
import de.htwg.se.shutthebox.model.playerComponent.playerImpl.Player
import de.htwg.se.shutthebox.model.playerComponent.playerInterface
import net.codingwell.scalaguice.ScalaModule


class ShutTheBoxModule extends AbstractModule with ScalaModule {

  override def configure() = {
    bind[ControllerInterface].to[controllerBaseImpl.Controller]
    bind[playerInterface].annotatedWithName("player1").toInstance(new Player("Player 1"))
    bind[playerInterface].annotatedWithName("player2").toInstance(new Player("Player 2"))
  }
}
