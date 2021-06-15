package de.htwg.se.shutthebox
import de.htwg.se.shutthebox.aview._


//import com.google.inject.Guice
import de.htwg.se.shutthebox.aview.TUI
import scala.io.StdIn.readLine
//import de.htwg.se.shutthebox.aview.gui.SwingGUI
import de.htwg.se.shutthebox.controller.controllerComponent.ControllerInterface
import de.htwg.se.shutthebox.controller.controllerComponent.controllerBaseImpl.Controller



object ShutTheBox {

  //val injector = Guice.createInjector(new ShutTheBoxModule)
  //val controller = injector.getInstance(classOf[ControllerInterface])
  val controller = new Controller()
  //controller.matchfield = injector

  //controller.players = inject

  val tui = new TUI(controller)
  //val gui = new SwingGUI(controller)

  def main(args: Array[String]): Unit = {


    val name = "ShutTheBox"
    var input = ""
    /*
    do {
      input = readLine()
      tui.processInputLine(input)
    }while (input != "q")
    
    while (input != "q")
    do (
      input = scala.io.StdIn.readLine()
      tui.processInputLine(input)
    )*/
    while 
      input != "q" 
    do 
      input = scala.io.StdIn.readLine()
      tui.processInputLine(input)

  }
}






