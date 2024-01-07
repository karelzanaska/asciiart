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
  val baseSamplePath = "samples/"
  val baseOutputPath = baseSamplePath + "artifacts/"


  test("TDL=1; path: 4") {
    val controller = new ConsoleController()
    controller.showHelp()
    assert(controller.getLastMessage().contains("Usage: run [options]"))
  }

  test("TDL=1; path: 1 - 2 - 5 - 11") {
    val controller = new ConsoleController()
    val args = List("--image", baseSamplePath + "cloud2.png")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val expectedErrorMessage = "Unable to load image with provided path: '" + baseSamplePath + "cloud2.png'"
    assert(controller.getLastErrorMessage.contains(expectedErrorMessage))
  }

  test("TDL=1; path: 1 - 2 - 6 - 12") {
    val controller = new ConsoleController()
    val args = List("--image", baseSamplePath + "cloud2.jpg")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val expectedErrorMessage = "Unable to load image with provided path: '" + baseSamplePath + "cloud2.jpg'"
    assert(controller.getLastErrorMessage.contains(expectedErrorMessage))
  }

  test("TDL=1; path: 1 - 2 - 7 - 13") {
    val controller = new ConsoleController()
    val args = List("--image", baseSamplePath + "cloud2.gif")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val expectedErrorMessage = "Unable to load image with provided path: '" + baseSamplePath + "cloud2.gif'"
    assert(controller.getLastErrorMessage.contains(expectedErrorMessage))
  }

  test("TDL=1; path: 1 - 2 - 8 - 14") {
    val controller = new ConsoleController()
    val args = List("--image", baseSamplePath + "cloud2.bmp")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val expectedErrorMessage = "Unable to load image with provided path: '" + baseSamplePath + "cloud2.bmp'"
    assert(controller.getLastErrorMessage.contains(expectedErrorMessage))
  }

  test("TDL=1; path: 1 - 2 - 5 - 21 - 17 - 25 - 29 - 18 - 26 - 31 - 38 - 40 - 41 - 44 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image", baseSamplePath + "cloud.png", "--flip", "x", "--output-file", baseOutputPath + "output-cloud.txt")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get(baseOutputPath + "output-cloud.txt")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

  test("TDL=1; path: 1 - 2 - 6 - 22 - 20 - 28 - 29 - 30 - 27 - 31 - 39 - 47 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image", baseSamplePath + "cloud.jpg", "--invert", "--output-file", baseOutputPath + "output-cloud.txt")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get(baseOutputPath + "output-cloud.txt")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

  test("TDL=1; path: 1 - 2 - 7 - 23 - 17 - 25 - 29 - 30 - 27 - 31 - 38 - 40 - 42 - 45 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image", baseSamplePath + "cloud.gif", "--rotate", "90", "--output-file", baseOutputPath + "output-cloud.txt")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get(baseOutputPath + "output-cloud.txt")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

  test("TDL=1; path: 1 - 2 - 8 - 24 - 17 - 25 - 29 - 30 - 27 - 31 - 38 - 40 - 43 - 46 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image", baseSamplePath + "cloud.bmp", "--scale", "4", "--output-file", baseOutputPath + "output-cloud.txt")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get(baseOutputPath + "output-cloud.txt")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

  test("TDL=1; path: 1 - 3 - 9 - 15 - 17 - 25 - 29 - 30 - 27 - 31 - 38 - 40 - 41 - 44 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image-random", "--flip", "x", "--output-file", baseOutputPath + "output-random.txt")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get(baseOutputPath + "output-random.txt")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

  test("TDL=1; path: 1 - 3 - 10 - 16 - 17 - 25 - 29 - 30 - 27 - 31 - 38 - 40 - 41 - 44 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image-random-gradient", "--invert", "--output-file", baseOutputPath + "output-random-gradient.txt")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get(baseOutputPath + "output-random-gradient.txt")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

  test("TDL=1; path: 1 - 2 - 5 - 32 - 38 - 40 - 41 - 44 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image", baseSamplePath + "cloud.png", "--output-console")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()
    // Assertions can be added here based on the expected console output
  }

  test("TDL=1; path: 1 - 2 - 6 - 33 - 38 - 40 - 41 - 44 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image", baseSamplePath + "cloud.jpg", "--output-console")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()
    // Assertions can be added here based on the expected console output
  }

  test("TDL=1; path: 1 - 2 - 7 - 34 - 38 - 40 - 41 - 44 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image", baseSamplePath + "cloud.gif", "--output-console")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()
    // Assertions can be added here based on the expected console output
  }

  test("TDL=1; path: 1 - 2 - 8 - 35 - 38 - 40 - 41 - 44 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image", baseSamplePath + "cloud.bmp", "--output-console")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()
    // Assertions can be added here based on the expected console output
  }

  test("TDL=1; path: 1 - 3 - 9 - 36 - 38 - 40 - 41 - 44 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image-random", "--output-console")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()
    // Assertions can be added here based on the expected console output
  }

  test("TDL=1; path: 1 - 3 - 10 - 37 - 38 - 40 - 41 - 44 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image-random-gradient", "--output-console")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()
    // Assertions can be added here based on the expected console output
  }

  test("TDL=1; path: 1 - 2 - 5 - 32 - 39 - 47 - 48 - 50") {
    val controller = new ConsoleController()
    val args = List("--image", baseSamplePath + "cloud.png", "--output-file", baseOutputPath + "output-cloud.txt")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get(baseOutputPath + "output-cloud.txt")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }


}
