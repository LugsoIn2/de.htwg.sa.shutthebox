package de.htwg.se.shutthebox.model.fileIoComponent.fileioDBImpl

import com.google.inject.{Guice, Injector}
import de.htwg.se.shutthebox.FileIOModule
import de.htwg.se.shutthebox.model.DAOComponent.FileIODAOInterface
import de.htwg.se.shutthebox.model.fileIoComponent.FileIOInterface
import play.api.libs.json.JsValue

class FileIO extends FileIOInterface{

  val injector: Injector = Guice.createInjector(new FileIOModule)
  val dataBase: FileIODAOInterface = injector.getInstance(classOf[FileIODAOInterface])

  override def load: JsValue = ???

  override def save(field: JsValue): Unit = {
    dataBase.create(field)

  }

}
