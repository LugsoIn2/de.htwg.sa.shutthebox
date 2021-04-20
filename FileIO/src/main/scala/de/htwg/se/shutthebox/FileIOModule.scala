package de.htwg.se.shutthebox

import com.google.inject.AbstractModule
import de.htwg.se.shutthebox.model.fileIoComponent.{FileIOInterface, fileIoJsonImpl}
import net.codingwell.scalaguice.ScalaModule

class FileIOModule extends AbstractModule with ScalaModule {
  override def configure() = {
    bind[FileIOInterface].to[fileIoJsonImpl.FileIO]
}

}
