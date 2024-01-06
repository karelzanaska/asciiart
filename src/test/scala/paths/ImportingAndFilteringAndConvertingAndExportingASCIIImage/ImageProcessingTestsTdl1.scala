package paths.ImportingAndFilteringAndConvertingAndExportingASCIIImage

import asciiart.controllers.ConsoleController
import asciiart.image.convertors.image.GrayscaleToAsciiImageConverter
import asciiart.image.convertors.pixel.LinearGrayscaleToAsciiPixelConvertor
import asciiart.image.exporters.StdoutImageExporter
import asciiart.image.filters.flip.FlipImageFilter
import asciiart.image.importers.PNGImageImporter
import asciiart.ui.ConsoleView
import combinations.{StringValue, TestConfig}
import org.scalatest.FunSuite

import java.nio.file.{Files, Paths}



class ImageProcessingTestsTdl1 extends FunSuite {

  test("TDL=1; path: 4") {
    val controller = new ConsoleController()
    controller.showHelp()
    assert(controller.getLastMessage().contains("Usage: run [options]"))
  }

  test("TDL=1; path: 1 - 2 - 5 - 11") {
    val controller = new ConsoleController()
    val args = List("--image", "/path/to/nonexistent.png")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val expectedErrorMessage = "Unable to load image with provided path: '/path/to/nonexistent.png'"
    assert(controller.getLastErrorMessage.contains(expectedErrorMessage))
  }

  test("TDL=1; path: 1 - 2 - 6 - 12") {
    val controller = new ConsoleController()
    val args = List("--image", "/path/to/nonexistent.jpg")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val expectedErrorMessage = "Unable to load image with provided path: '/path/to/nonexistent.jpg'"
    assert(controller.getLastErrorMessage.contains(expectedErrorMessage))
  }

  test("TDL=1; path: 1 - 2 - 7 - 13") {
    val controller = new ConsoleController()
    val args = List("--image", "/path/to/nonexistent.gif")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val expectedErrorMessage = "Unable to load image with provided path: '/path/to/nonexistent.gif'"
    assert(controller.getLastErrorMessage.contains(expectedErrorMessage))
  }

  test("TDL=1; path: 1 - 2 - 8 - 14") {
    val controller = new ConsoleController()
    val args = List("--image", "/path/to/nonexistent.bmp")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val expectedErrorMessage = "Unable to load image with provided path: '/path/to/nonexistent.bmp'"
    assert(controller.getLastErrorMessage.contains(expectedErrorMessage))
  }

  test("TDL=1; path: 1 - 2 - 5 - 21 - 17 - 25 - 29 - 18 - 26 - 31 - 38 - 40 - 41 - 44 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image", "/home/karel/FEL/ZKS/asciiart/samples/cloud.png", "--flip", "x", "--output-rgb-file", "/home/karel/FEL/ZKS/asciiart/samples/output-cloud.jpg")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get("/home/karel/FEL/ZKS/asciiart/samples/output-cloud.jpg")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

  test("TDL=1; path: 1 - 2 - 6 - 22 - 20 - 28 - 29 - 30 - 27 - 31 - 39 - 47 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image", "/home/karel/FEL/ZKS/asciiart/samples/cloud.jpg", "--invert", "--output-rgb-file", "/home/karel/FEL/ZKS/asciiart/samples/output-cloud.gif")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get("/home/karel/FEL/ZKS/asciiart/samples/output-cloud.gif")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

  test("TDL=1; path: 1 - 2 - 7 - 23 - 17 - 25 - 29 - 30 - 27 - 31 - 38 - 40 - 42 - 45 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image", "/home/karel/FEL/ZKS/asciiart/samples/cloud.gif", "--rotate", "90", "--output-rgb-file", "/home/karel/FEL/ZKS/asciiart/samples/output-cloud.png")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get("/home/karel/FEL/ZKS/asciiart/samples/output-cloud.png")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

  test("TDL=1; path: 1 - 2 - 8 - 24 - 17 - 25 - 29 - 30 - 27 - 31 - 38 - 40 - 43 - 46 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image", "/home/karel/FEL/ZKS/asciiart/samples/cloud.bmp", "--scale", "4", "--output-rgb-file", "/home/karel/FEL/ZKS/asciiart/samples/output-cloud.bmp")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get("/home/karel/FEL/ZKS/asciiart/samples/output-cloud.bmp")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

  test("TDL=1; path: 1 - 3 - 9 - 15 - 17 - 25 - 29 - 30 - 27 - 31 - 38 - 40 - 41 - 44 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image-random", "--flip", "x", "--output-rgb-file", "/home/karel/FEL/ZKS/asciiart/samples/output-random.jpg")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get("/home/karel/FEL/ZKS/asciiart/samples/output-random.jpg")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

  test("TDL=1; path: 1 - 3 - 10 - 16 - 17 - 25 - 29 - 30 - 27 - 31 - 38 - 40 - 41 - 44 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image-random-gradient", "--invert", "--output-rgb-file", "/home/karel/FEL/ZKS/asciiart/samples/output-random-gradient.gif")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get("/home/karel/FEL/ZKS/asciiart/samples/output-random-gradient.gif")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

  test("TDL=1; path: 1 - 2 - 5 - 32 - 38 - 40 - 41 - 44 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image", "/home/karel/FEL/ZKS/asciiart/samples/cloud.png", "--output-console")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()
  }

  test("TDL=1; path: 1 - 2 - 6 - 33 - 38 - 40 - 41 - 44 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image", "/home/karel/FEL/ZKS/asciiart/samples/cloud.jpg", "--output-console")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()
  }

  test("TDL=1; path: 1 - 2 - 7 - 34 - 38 - 40 - 41 - 44 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image", "/home/karel/FEL/ZKS/asciiart/samples/cloud.gif", "--output-console")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()
  }

  test("TDL=1; path: 1 - 2 - 8 - 35 - 38 - 40 - 41 - 44 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image", "/home/karel/FEL/ZKS/asciiart/samples/cloud.bmp", "--output-console")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

//    assert(controller.getLastMessage().contains("ASCII Art Output"))
  }

  test("TDL=1; path: 1 - 3 - 9 - 36 - 38 - 40 - 41 - 44 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image-random", "--output-console")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

  }

  test("TDL=1; path: 1 - 3 - 10 - 37 - 38 - 40 - 41 - 44 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image-random-gradient", "--output-console")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

  }

  test("TDL=1; path: 1 - 2 - 5 - 32 - 39 - 47 - 48 - 50") {
    val controller = new ConsoleController()
    val args = List("--image", "/home/karel/FEL/ZKS/asciiart/samples/cloud.png", "--output-file", "/home/karel/FEL/ZKS/asciiart/samples/output-cloud.txt")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get("/home/karel/FEL/ZKS/asciiart/samples/output-cloud.txt")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }
}
