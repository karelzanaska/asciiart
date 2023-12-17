package asciiart

import asciiart.controllers.ConsoleController
import asciiart.image.models.image.{AsciiImage, RGBImage}
import asciiart.ui.ConsoleView


object Main extends App {

  val controller = new ConsoleController()
  private val view = new ConsoleView(controller, args.toList)
  view.run()

}
