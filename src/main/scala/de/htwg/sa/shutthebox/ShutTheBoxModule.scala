package de.htwg.se.shutthebox

import com.google.inject.{AbstractModule, Singleton}
import com.google.inject.name.Names
import de.htwg.se.shutthebox.controller.controllerComponent.ControllerInterface
import de.htwg.se.shutthebox.controller.controllerComponent.controllerBaseImpl.Controller
import de.htwg.se.shutthebox.model.fieldComponent.fieldAdvancedImpl.BigField
import de.htwg.se.shutthebox.model.fieldComponent.fieldBaseImpl.Field
import de.htwg.se.shutthebox.model.fieldComponent.fieldBaseImpl.Cell
import de.htwg.se.shutthebox.model.fieldComponent.fieldInterface
import de.htwg.se.shutthebox.controller.controllerComponent.aiBaseImpl.AI
import de.htwg.se.shutthebox.model.playerComponent.playerImpl.Player
import de.htwg.se.shutthebox.model.playerComponent.playerInterface

@Singleton
class ShutTheBoxModule extends AbstractModule {

  override def configure() = {
    bind(classOf[fieldInterface]).toInstance(Field(Array[Cell](Cell(),Cell(), Cell(),
                                                         Cell(), Cell(), Cell(), 
                                                        Cell(), Cell(), Cell())))
    bind(classOf[playerInterface]).toInstance(new Player("Player 1"))
  }
}
