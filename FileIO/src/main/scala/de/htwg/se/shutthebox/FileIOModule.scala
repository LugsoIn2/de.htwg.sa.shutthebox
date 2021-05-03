package de.htwg.se.shutthebox

import com.google.inject.AbstractModule
import de.htwg.se.shutthebox.model.DAOComponent.DAObaseImpl.FileIODAO
import de.htwg.se.shutthebox.model.DAOComponent.FileIODAOInterface
import de.htwg.se.shutthebox.model.fileIoComponent.{FileIOInterface, fileIoJsonImpl, fileioDBImpl}
import net.codingwell.scalaguice.ScalaModule

class FileIOModule extends AbstractModule with ScalaModule {
  override def configure() = {
    bind[FileIOInterface].to[fileioDBImpl.FileIO]
    bind[FileIODAOInterface].toInstance(FileIODAO())
}

}
