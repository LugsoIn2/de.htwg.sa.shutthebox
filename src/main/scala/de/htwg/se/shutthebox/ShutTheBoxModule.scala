package de.htwg.se.shutthebox

import com.google.inject.AbstractModule
import com.google.inject.name.Names
import de.htwg.se.shutthebox.controller.controllerComponent.ControllerInterface
import de.htwg.se.shutthebox.controller.controllerComponent._
import de.htwg.se.shutthebox.model.fieldComponent.fieldAdvancedImpl.BigField
import de.htwg.se.shutthebox.model.fieldComponent.fieldBaseImpl.Field
import de.htwg.se.shutthebox.model.fieldComponent.fieldInterface
import de.htwg.se.shutthebox.model.fileIoComponent.FileIOInterface
import de.htwg.se.shutthebox.model.fileIoComponent.fileIoXmlImpl.FileIO
import de.htwg.se.shutthebox.controller.controllerComponent.aiBaseImpl.AI
import de.htwg.se.shutthebox.model.playerComponent.playerImpl.Player
import de.htwg.se.shutthebox.model.playerComponent.playerInterface
import net.codingwell.scalaguice.ScalaModule
import de.htwg.se.shutthebox.model.fileIoComponent._


class ShutTheBoxModule extends AbstractModule with ScalaModule {

  override def configure() = {
    bind[ControllerInterface].to[controllerBaseImpl.Controller]
    bind[fieldInterface].annotatedWithName("normal").toInstance(new Field())
    bind[fieldInterface].annotatedWithName("big").toInstance(new BigField())
    bind[playerInterface].annotatedWithName("player1").toInstance(new Player("Player 1"))
    bind[playerInterface].annotatedWithName("player2").toInstance(new Player("Player 2"))

    bind[FileIOInterface].to[fileIoJsonImpl.FileIO]
  }
}
