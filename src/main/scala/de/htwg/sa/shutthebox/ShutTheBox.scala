package de.htwg.se.shutthebox

import de.htwg.se.shutthebox.aview._
import de.htwg.se.shutthebox.aview.TUI
import scala.io.StdIn.readLine
import de.htwg.se.shutthebox.controller.controllerComponent.ControllerInterface
import de.htwg.se.shutthebox.controller.controllerComponent.controllerBaseImpl.Controller

@main def shutthebox =
  val controller = new Controller()


  val tui = new TUI(controller)
  println("Welcome to ShutTheBox")
  val name = "ShutTheBox"
    var input = ""

    while 
      input != "q" 
    do 
      input = scala.io.StdIn.readLine()
      tui.processInputLine(input)





