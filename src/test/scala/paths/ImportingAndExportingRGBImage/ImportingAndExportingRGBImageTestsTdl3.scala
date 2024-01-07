package paths.ImportingAndExportingRGBImage

import asciiart.controllers.ConsoleController
import asciiart.ui.ConsoleView
import org.scalatest.FunSuite

import java.nio.file.{Files, Paths}



class ImportingAndExportingRGBImageTestsTdl3 extends FunSuite {
  // TDL=3
  val baseSamplePath = "samples/"
  val baseOutputPath = "samples/artifacts/"


  test("TDL=2; path: 4") {
    val controller = new ConsoleController()
    controller.showHelp()
    assert(controller.getLastMessage().contains("Usage: run [options]"))
  }

  test("TDL=3; path: 1 - 2 - 5 - 11") {
    val controller = new ConsoleController()
    val args = List("--image", baseSamplePath + "cloud2.png")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()
    val expectedErrorMessage = "Unable to load image with provided path: 'samples/cloud2.png'"
    assert(controller.getLastErrorMessage.contains(expectedErrorMessage))
  }

  test("TDL=3; path: 1 - 2 - 6 - 12") {
    val controller = new ConsoleController()
    val args = List("--image", baseSamplePath + "cloud2.jpg")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val expectedErrorMessage = "Unable to load image with provided path: 'samples/cloud2.jpg'"
    assert(controller.getLastErrorMessage.contains(expectedErrorMessage))
  }

  test("TDL=3; path: 1 - 2 - 7 - 13") {
    val controller = new ConsoleController()
    val args = List("--image", baseSamplePath + "cloud2.gif")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val expectedErrorMessage = "Unable to load image with provided path: 'samples/cloud2.gif'"
    assert(controller.getLastErrorMessage.contains(expectedErrorMessage))
  }

  test("TDL=3; path: 1 - 2 - 8 - 14") {
    val controller = new ConsoleController()
    val args = List("--image", baseSamplePath + "cloud2.bmp")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val expectedErrorMessage = "Unable to load image with provided path: 'samples/cloud2.bmp'"
    assert(controller.getLastErrorMessage.contains(expectedErrorMessage))
  }

  test("TDL=3; path: 1 - 3 - 9 - 15 - 17") {
    val controller = new ConsoleController()
    val args = List("--image-random", "--output-rgb-file", baseOutputPath + "output-random-rgb.bmp")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get(baseOutputPath + "output-random-rgb.bmp")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

  test("TDL=3; path: 1 - 3 - 10 - 16 - 17") {
    val controller = new ConsoleController()
    val args = List("--image-random-gradient", "--output-rgb-file", baseOutputPath + "output-random-gradient-rgb.bmp")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get(baseOutputPath + "output-random-gradient-rgb.bmp")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

  test("TDL=3; path: 1 - 2 - 5 - 21 - 17") {
    val controller = new ConsoleController()
    val args = List("--image", baseSamplePath + "cloud.png", "--output-rgb-file", baseOutputPath + "output-cloud-rgb.bmp")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get(baseOutputPath + "output-cloud-rgb.bmp")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

  test("TDL=3; path: 1 - 2 - 6 - 22 - 17") {
    val controller = new ConsoleController()
    val args = List("--image", baseSamplePath + "cloud.jpg", "--output-rgb-file", baseOutputPath + "output-cloud-rgb.jpg")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get(baseOutputPath + "output-cloud-rgb.jpg")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

  test("TDL=3; path: 1 - 2 - 7 - 23 - 17") {
    val controller = new ConsoleController()
    val args = List("--image", baseSamplePath + "cloud.gif", "--output-rgb-file", baseOutputPath + "output-cloud-rgb.gif")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get(baseOutputPath + "output-cloud-rgb.gif")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

  test("TDL=3; path: 1 - 2 - 8 - 24 - 17") {
    val controller = new ConsoleController()
    val args = List("--image", baseSamplePath + "cloud.bmp", "--output-rgb-file", baseOutputPath + "output-cloud-rgb.bmp")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get(baseOutputPath + "output-cloud-rgb.bmp")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

  test("TDL=3; path: 1 - 2 - 5 - 21 - 18") {
    val controller = new ConsoleController()
    val args = List("--image", baseSamplePath + "cloud.png", "--output-rgb-file", baseOutputPath + "output-cloud-rgb-2.bmp")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get(baseOutputPath + "output-cloud-rgb-2.bmp")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

  test("TDL=3; path: 1 - 2 - 6 - 22 - 18") {
    val controller = new ConsoleController()
    val args = List("--image", baseSamplePath + "cloud.jpg", "--output-rgb-file", baseOutputPath + "output-cloud-rgb-2.jpg")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get(baseOutputPath + "output-cloud-rgb-2.jpg")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

  test("TDL=3; path: 1 - 2 - 7 - 23 - 18") {
    val controller = new ConsoleController()
    val args = List("--image", baseSamplePath + "cloud.gif", "--output-rgb-file", baseOutputPath + "output-cloud-rgb-2.gif")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get(baseOutputPath + "output-cloud-rgb-2.gif")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

  test("TDL=3; path: 1 - 2 - 8 - 24 - 18") {
    val controller = new ConsoleController()
    val args = List("--image", baseSamplePath + "cloud.bmp", "--output-rgb-file", baseOutputPath + "output-cloud-rgb-2.bmp")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get(baseOutputPath + "output-cloud-rgb-2.bmp")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

  test("TDL=3; path: 1 - 3 - 9 - 15 - 18") {
    val controller = new ConsoleController()
    val args = List("--image-random", "--output-rgb-file", baseOutputPath + "output-random-rgb-2.bmp")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get(baseOutputPath + "output-random-rgb-2.bmp")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

  test("TDL=3; path: 1 - 3 - 10 - 16 - 18") {
    val controller = new ConsoleController()
    val args = List("--image-random-gradient", "--output-rgb-file", baseOutputPath + "output-random-gradient-rgb-2.bmp")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get(baseOutputPath + "output-random-gradient-rgb-2.bmp")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

  test("TDL=3; path: 1 - 2 - 5 - 21 - 19") {
    val controller = new ConsoleController()
    val args = List("--image", baseSamplePath + "cloud.png", "--output-rgb-file", baseOutputPath + "output-cloud-rgb-3.png")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get(baseOutputPath + "output-cloud-rgb-3.png")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

  test("TDL=3; path: 1 - 2 - 6 - 22 - 19") {
    val controller = new ConsoleController()
    val args = List("--image", baseSamplePath + "cloud.jpg", "--output-rgb-file", baseOutputPath + "output-cloud-rgb-3.jpg")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get(baseOutputPath + "output-cloud-rgb-3.jpg")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

  test("TDL=3; path: 1 - 2 - 7 - 23 - 19") {
    val controller = new ConsoleController()
    val args = List("--image", baseSamplePath + "cloud.gif", "--output-rgb-file", baseOutputPath + "output-cloud-rgb-3.gif")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get(baseOutputPath + "output-cloud-rgb-3.gif")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

  test("TDL=3; path: 1 - 2 - 8 - 24 - 19") {
    val controller = new ConsoleController()
    val args = List("--image", baseSamplePath + "cloud.bmp", "--output-rgb-file", baseOutputPath + "output-cloud-rgb-3.bmp")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get(baseOutputPath + "output-cloud-rgb-3.bmp")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

  test("TDL=3; path: 1 - 3 - 9 - 15 - 19") {
    val controller = new ConsoleController()
    val args = List("--image-random", "--output-rgb-file", baseOutputPath + "output-random-rgb-3.bmp")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get(baseOutputPath + "output-random-rgb-3.bmp")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

  test("TDL=3; path: 1 - 3 - 10 - 16 - 19") {
    val controller = new ConsoleController()
    val args = List("--image-random-gradient", "--output-rgb-file", baseOutputPath + "output-random-gradient-rgb-3.bmp")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get(baseOutputPath + "output-random-gradient-rgb-3.bmp")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

  test("TDL=3; path: 1 - 2 - 5 - 21 - 20") {
    val controller = new ConsoleController()
    val args = List("--image", baseSamplePath + "cloud.png", "--output-rgb-file", baseOutputPath + "output-cloud-rgb-4.png")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get(baseOutputPath + "output-cloud-rgb-4.png")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

  test("TDL=3; path: 1 - 2 - 6 - 22 - 20") {
    val controller = new ConsoleController()
    val args = List("--image", baseSamplePath + "cloud.jpg", "--output-rgb-file", baseOutputPath + "output-cloud-rgb-4.jpg")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get(baseOutputPath + "output-cloud-rgb-4.jpg")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

  test("TDL=3; path: 1 - 2 - 7 - 23 - 20") {
    val controller = new ConsoleController()
    val args = List("--image", baseSamplePath + "cloud.gif", "--output-rgb-file", baseOutputPath + "output-cloud-rgb-4.gif")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get(baseOutputPath + "output-cloud-rgb-4.gif")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

  test("TDL=3; path: 1 - 2 - 8 - 24 - 20") {
    val controller = new ConsoleController()
    val args = List("--image", baseSamplePath + "cloud.bmp", "--output-rgb-file", baseOutputPath + "output-cloud-rgb-4.bmp")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get(baseOutputPath + "output-cloud-rgb-4.bmp")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

  test("TDL=3; path: 1 - 3 - 9 - 15 - 20") {
    val controller = new ConsoleController()
    val args = List("--image-random", "--output-rgb-file", baseOutputPath + "output-random-rgb-4.bmp")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get(baseOutputPath + "output-random-rgb-4.bmp")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

  test("TDL=3; path: 1 - 3 - 10 - 16 - 20") {
    val controller = new ConsoleController()
    val args = List("--image-random-gradient", "--output-rgb-file", baseOutputPath + "output-random-gradient-rgb-4.bmp")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get(baseOutputPath + "output-random-gradient-rgb-4.bmp")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }
}
