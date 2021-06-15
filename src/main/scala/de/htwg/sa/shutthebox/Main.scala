/*
package de.htwg.sa.shutthebox

import de.htwg.sa.shutthebox.model.Cell

@main def hello: Unit = 
  val cell = Cell(1,false)
  cell.toString





*/
package de.htwg.se.shutthebox

import scala.io.StdIn.readLine
import de.htwg.se.shutthebox.controller.Controller


object ShutTheBox {

  //val injector = Guice.createInjector(new ShutTheBoxModule)
  //val controller = injector.getInstance(classOf[ControllerInterface])
  //val tui = new TUI(controller)
  //val gui = new SwingGUI(controller)

  def main(args: Array[String]): Unit = {

    val name = "ShutTheBox"
    var input = ""
    val controller = Controller()
    /*
    do {
      input = readLine()
      tui.processInputLine(input)
    }while (input != "q")
    */
    while
      input != "q"
    do (input = readLine())
  }
}
