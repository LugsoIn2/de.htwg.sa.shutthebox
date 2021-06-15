package de.htwg.se.shutthebox

import de.htwg.se.shutthebox.aview._
import de.htwg.se.shutthebox.aview.TUI
import scala.io.StdIn.readLine
import de.htwg.se.shutthebox.controller.controllerComponent.ControllerInterface
import de.htwg.se.shutthebox.controller.controllerComponent.controllerBaseImpl.Controller



object ShutTheBox {

  val controller = new Controller()


  val tui = new TUI(controller)

  def main(args: Array[String]): Unit = {


    val name = "ShutTheBox"
    var input = ""

    while 
      input != "q" 
    do 
      input = scala.io.StdIn.readLine()
      tui.processInputLine(input)

  }
}






