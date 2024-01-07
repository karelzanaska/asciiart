package paths.ImportingAndExportingRGBImage

import asciiart.controllers.ConsoleController
import asciiart.ui.ConsoleView
import org.scalatest.FunSuite

import java.nio.file.{Files, Paths}
//case class TestableConsoleViewTests()


class ImportingAndExportingRGBImageTestsTdl2 extends FunSuite {
  // TDL=2
  val baseSamplePath = "samples/"
  val baseOutputPath = "samples/artifacts/"


  test("TDL=2; path: 4") {
    val controller = new ConsoleController()
    controller.showHelp()
    assert(controller.getLastMessage().contains("Usage: run [options]"))
  }

  test("TDL=2; path: 1 - 2 - 5 - 11") {
    val controller = new ConsoleController()
    val args = List("--image", baseSamplePath + "cloud2.png")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val expectedErrorMessage = "Unable to load image with provided path: 'samples/cloud2.png'"
    assert(controller.getLastErrorMessage.contains(expectedErrorMessage))
  }

  test("TDL=2; path: 1 - 2 - 6 - 12") {
    val controller = new ConsoleController()
    val args = List("--image", baseSamplePath + "cloud2.jpg")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val expectedErrorMessage = "Unable to load image with provided path: 'samples/cloud2.jpg'"
    assert(controller.getLastErrorMessage.contains(expectedErrorMessage))
  }

  test("TDL=2; path: 1 - 2 - 7 - 13") {
    val controller = new ConsoleController()
    val args = List("--image", baseSamplePath + "cloud2.gif")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val expectedErrorMessage = "Unable to load image with provided path: 'samples/cloud2.gif'"
    assert(controller.getLastErrorMessage.contains(expectedErrorMessage))
  }

  test("TDL=2; path: 1 - 2 - 8 - 14") {
    val controller = new ConsoleController()
    val args = List("--image", baseSamplePath + "cloud2.bmp")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val expectedErrorMessage = "Unable to load image with provided path: 'samples/cloud2.bmp'"
    assert(controller.getLastErrorMessage.contains(expectedErrorMessage))
  }

  test("TDL=2; path: 1 - 3 - 9 - 15 - 17") {
    val controller = new ConsoleController()
    val args = List("--image-random", "--output-rgb-file", baseOutputPath + "random_rgb.bmp")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get(baseOutputPath + "random_rgb.bmp")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

  test("TDL=2; path: 1 - 2 - 5 - 21 - 17") {
    val controller = new ConsoleController()
    val args = List("--image", baseSamplePath + "cloud.png", "--output-rgb-file", baseOutputPath + "cloud_rgb.bmp")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get(baseOutputPath + "cloud_rgb.bmp")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

  test("TDL=2; path: 1 - 2 - 6 - 22 - 17") {
    val controller = new ConsoleController()
    val args = List("--image", baseSamplePath + "cloud.jpg", "--output-rgb-file", baseOutputPath + "cloud_rgb.jpg")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get(baseOutputPath + "cloud_rgb.jpg")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

  test("TDL=2; path: 1 - 2 - 7 - 23 - 17") {
    val controller = new ConsoleController()
    val args = List("--image", baseSamplePath + "cloud.gif", "--output-rgb-file", baseOutputPath + "cloud_rgb.gif")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get(baseOutputPath + "cloud_rgb.gif")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

  test("TDL=2; path: 1 - 2 - 8 - 24 - 17") {
    val controller = new ConsoleController()
    val args = List("--image", baseSamplePath + "cloud.bmp", "--output-rgb-file", baseOutputPath + "cloud_rgb.bmp")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get(baseOutputPath + "cloud_rgb.bmp")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

  test("TDL=2; path: 1 - 3 - 10 - 16 - 17") {
    val controller = new ConsoleController()
    val args = List("--image-random-gradient", "--output-rgb-file", baseOutputPath + "random_gradient_rgb.bmp")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get(baseOutputPath + "random_gradient_rgb.bmp")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

  test("TDL=2; path: 1 - 2 - 5 - 21 - 18") {
    val controller = new ConsoleController()
    val args = List("--image", baseSamplePath + "cloud.png", "--output-rgb-file", baseOutputPath + "cloud_png_rgb.bmp")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get(baseOutputPath + "cloud_png_rgb.bmp")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

  test("TDL=2; path: 1 - 2 - 6 - 22 - 18") {
    val controller = new ConsoleController()
    val args = List("--image", baseSamplePath + "cloud.jpg", "--output-rgb-file", baseOutputPath + "cloud_jpg_rgb.bmp")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get(baseOutputPath + "cloud_jpg_rgb.bmp")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

  test("TDL=2; path: 1 - 2 - 7 - 23 - 18") {
    val controller = new ConsoleController()
    val args = List("--image", baseSamplePath + "cloud.gif", "--output-rgb-file", baseOutputPath + "cloud_gif_rgb.bmp")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get(baseOutputPath + "cloud_gif_rgb.bmp")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

  test("TDL=2; path: 1 - 2 - 8 - 24 - 18") {
    val controller = new ConsoleController()
    val args = List("--image", baseSamplePath + "cloud.bmp", "--output-rgb-file", baseOutputPath + "cloud_bmp_rgb.bmp")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get(baseOutputPath + "cloud_bmp_rgb.bmp")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

  test("TDL=2; path: 1 - 3 - 9 - 15 - 18") {
    val controller = new ConsoleController()
    val args = List("--image-random", "--output-rgb-file", baseOutputPath + "random_rgb.bmp")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get(baseOutputPath + "random_rgb.bmp")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

  test("TDL=2; path: 1 - 3 - 10 - 16 - 18") {
    val controller = new ConsoleController()
    val args = List("--image-random-gradient", "--output-rgb-file", baseOutputPath + "random_gradient_rgb_2.bmp")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get(baseOutputPath + "random_gradient_rgb_2.bmp")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

  test("TDL=2; path: 1 - 2 - 5 - 21 - 19") {
    val controller = new ConsoleController()
    val args = List("--image", baseSamplePath + "cloud.png", "--output-rgb-file", baseOutputPath + "cloud_png_rgb_2.bmp")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get(baseOutputPath + "cloud_png_rgb_2.bmp")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

  test("TDL=2; path: 1 - 2 - 6 - 22 - 19") {
    val controller = new ConsoleController()
    val args = List("--image", baseSamplePath + "cloud.jpg", "--output-rgb-file", baseOutputPath + "cloud_jpg_rgb_2.bmp")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get(baseOutputPath + "cloud_jpg_rgb_2.bmp")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

  test("TDL=2; path: 1 - 2 - 7 - 23 - 19") {
    val controller = new ConsoleController()
    val args = List("--image", baseSamplePath + "cloud.gif", "--output-rgb-file", baseOutputPath + "cloud_gif_rgb_2.bmp")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get(baseOutputPath + "cloud_gif_rgb_2.bmp")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

  test("TDL=2; path: 1 - 2 - 8 - 24 - 19") {
    val controller = new ConsoleController()
    val args = List("--image", baseSamplePath + "cloud.bmp", "--output-rgb-file", baseOutputPath + "cloud_bmp_rgb_2.bmp")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get(baseOutputPath + "cloud_bmp_rgb_2.bmp")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

  test("TDL=2; path: 1 - 3 - 9 - 15 - 19") {
    val controller = new ConsoleController()
    val args = List("--image-random", "--output-rgb-file", baseOutputPath + "random_rgb_3.bmp")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get(baseOutputPath + "random_rgb_3.bmp")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

  test("TDL=2; path: 1 - 3 - 10 - 16 - 19") {
    val controller = new ConsoleController()
    val args = List("--image-random-gradient", "--output-rgb-file", baseOutputPath + "random_gradient_rgb_3.bmp")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get(baseOutputPath + "random_gradient_rgb_3.bmp")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

  test("TDL=2; path: 1 - 2 - 5 - 21 - 20") {
    val controller = new ConsoleController()
    val args = List("--image", baseSamplePath + "cloud.png", "--output-rgb-file", baseOutputPath + "cloud_png_rgb_3.bmp")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get(baseOutputPath + "cloud_png_rgb_3.bmp")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

  test("TDL=2; path: 1 - 2 - 6 - 22 - 20") {
    val controller = new ConsoleController()
    val args = List("--image", baseSamplePath + "cloud.jpg", "--output-rgb-file", baseOutputPath + "cloud_jpg_rgb_3.bmp")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get(baseOutputPath + "cloud_jpg_rgb_3.bmp")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

  test("TDL=2; path: 1 - 2 - 7 - 23 - 20") {
    val controller = new ConsoleController()
    val args = List("--image", baseSamplePath + "cloud.gif", "--output-rgb-file", baseOutputPath + "cloud_gif_rgb_3.bmp")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get(baseOutputPath + "cloud_gif_rgb_3.bmp")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

  test("TDL=2; path: 1 - 2 - 8 - 24 - 20") {
    val controller = new ConsoleController()
    val args = List("--image", baseSamplePath + "cloud.bmp", "--output-rgb-file", baseOutputPath + "cloud_bmp_rgb_3.bmp")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get(baseOutputPath + "cloud_bmp_rgb_3.bmp")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

  test("TDL=2; path: 1 - 3 - 9 - 15 - 20") {
    val controller = new ConsoleController()
    val args = List("--image-random", "--output-rgb-file", baseOutputPath + "random_rgb_4.bmp")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get(baseOutputPath + "random_rgb_4.bmp")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

  test("TDL=2; path: 1 - 3 - 10 - 16 - 20") {
    val controller = new ConsoleController()
    val args = List("--image-random-gradient", "--output-rgb-file", baseOutputPath + "random_gradient_rgb_4.bmp")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get(baseOutputPath + "random_gradient_rgb_4.bmp")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }
}
