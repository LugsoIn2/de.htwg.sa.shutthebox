package de.htwg.se.shutthebox

import com.google.inject.AbstractModule
import de.htwg.se.shutthebox.model.fieldComponent.fieldAdvancedImpl.BigField
import de.htwg.se.shutthebox.model.fieldComponent.fieldBaseImpl.Field
import de.htwg.se.shutthebox.model.fieldComponent.fieldInterface
import net.codingwell.scalaguice.ScalaModule

class FieldModule extends AbstractModule with ScalaModule {
  override def configure() = {
    bind[fieldInterface].annotatedWithName("normal").toInstance(new Field())
    bind[fieldInterface].annotatedWithName("big").toInstance(new BigField())
  }
}
