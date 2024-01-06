package paths.ImportingAndFilteringAndConvertingAndExportingASCIIImage

import asciiart.controllers.ConsoleController
import asciiart.ui.ConsoleView
import org.scalatest.FunSuite

import java.nio.file.{Files, Paths}


class ImageProcessingTestsTdl2 extends FunSuite {

  test("TDL=2; path: 4") {
    val controller = new ConsoleController()
    controller.showHelp()
    assert(controller.getLastMessage().contains("Usage: run [options]"))
  }

  test("TDL=2; path: 1 - 2 - 5 - 11") {
    val controller = new ConsoleController()
    val args = List("--image", "/home/karel/FEL/ZKS/asciiart/samples/cloud2.png")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val expectedErrorMessage = "Unable to load image with provided path: '/home/karel/FEL/ZKS/asciiart/samples/cloud2.png'"
    assert(controller.getLastErrorMessage.contains(expectedErrorMessage))
  }

  test("TDL=2; path: 1 - 2 - 6 - 12") {
    val controller = new ConsoleController()
    val args = List("--image", "/home/karel/FEL/ZKS/asciiart/samples/cloud2.jpg")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val expectedErrorMessage = "Unable to load image with provided path: '/home/karel/FEL/ZKS/asciiart/samples/cloud2.jpg'"
    assert(controller.getLastErrorMessage.contains(expectedErrorMessage))
  }

  test("TDL=2; path: 1 - 2 - 7 - 13") {
    val controller = new ConsoleController()
    val args = List("--image", "/home/karel/FEL/ZKS/asciiart/samples/cloud2.gif")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val expectedErrorMessage = "Unable to load image with provided path: '/home/karel/FEL/ZKS/asciiart/samples/cloud2.gif'"
    assert(controller.getLastErrorMessage.contains(expectedErrorMessage))
  }

  test("TDL=2; path: 1 - 2 - 8 - 14") {
    val controller = new ConsoleController()
    val args = List("--image", "/home/karel/FEL/ZKS/asciiart/samples/cloud2.bmp")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val expectedErrorMessage = "Unable to load image with provided path: '/home/karel/FEL/ZKS/asciiart/samples/cloud2.bmp'"
    assert(controller.getLastErrorMessage.contains(expectedErrorMessage))
  }

  test("TDL=2; path: 1 - 3 - 9 - 15 - 17 - 25 - 29 - 17 - 25 - 31 - 38 - 40 - 41 - 44 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image-random", "--flip", "x", "--output-console")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    // Assuming the expected behavior is to successfully process and output the image
//    assert(controller.getLastMessage().contains("Image processed and output to console"))
  }

  test("TDL=2; path: 1 - 2 - 5 - 21 - 17 - 25 - 29 - 18 - 26 - 29 - 20 - 28 - 29 - 30 - 27 - 29 - 17 - 25 - 31 - 39 - 47 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image", "/home/karel/FEL/ZKS/asciiart/samples/cloud.png", "--invert", "--rotate", "90", "--scale", "1.0", "--output-rgb-file", "/home/karel/FEL/ZKS/asciiart/samples/artifacts/output-cloud.png")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    // Verify the output file is created and then delete it
    val outputPath = Paths.get("/home/karel/FEL/ZKS/asciiart/samples/artifacts/output-cloud.png")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

  test("TDL=2; path: 1 - 2 - 5 - 21 - 18 - 26 - 31 - 38 - 40 - 42 - 45 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image", "/home/karel/FEL/ZKS/asciiart/samples/cloud.png", "--invert", "--output-file", "/home/karel/FEL/ZKS/asciiart/samples/artifacts/output-cloud.txt")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    // Verify the output file is created and then delete it
    val outputPath = Paths.get("/home/karel/FEL/ZKS/asciiart/samples/artifacts/output-cloud.txt")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }


  test("TDL=2; path: 1 - 2 - 5 - 21 - 20 - 28 - 31 - 38 - 40 - 43 - 46 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image", "/home/karel/FEL/ZKS/asciiart/samples/cloud.png", "--flip", "x", "--rotate", "90", "--output-console")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    // No specific assertion for console output
  }

  test("TDL=2; path: 1 - 2 - 5 - 21 - 30 - 27 - 31 - 38 - 40 - 41 - 44 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image", "/home/karel/FEL/ZKS/asciiart/samples/cloud.png", "--flip", "x", "--scale", "1.0", "--output-console")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    // No specific assertion for console output
  }

  test("TDL=2; path: 1 - 2 - 6 - 22 - 17 - 25 - 29 - 17 - 25 - 31 - 38 - 40 - 41 - 44 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image", "/home/karel/FEL/ZKS/asciiart/samples/cloud.jpg", "--invert", "--output-console", "--output-console")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    // No specific assertion for console output
  }

  test("TDL=2; path: 1 - 2 - 6 - 22 - 18 - 26 - 29 - 17 - 25 - 29 - 30 - 27 - 29 - 20 - 28 - 29 - 18 - 26 - 31 - 38 - 40 - 41 - 44 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image", "/home/karel/FEL/ZKS/asciiart/samples/cloud.jpg", "--invert", "--flip", "x", "--output-console", "--output-console")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    // No specific assertion for console output
  }

  test("TDL=2; path: 1 - 2 - 6 - 22 - 20 - 28 - 29 - 17 - 25 - 29 - 30 - 27 - 29 - 20 - 28 - 31 - 38 - 40 - 41 - 44 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image", "/home/karel/FEL/ZKS/asciiart/samples/cloud.jpg", "--invert", "--flip", "y", "--output-console", "--output-console")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    // No specific assertion for console output
  }

  test("TDL=2; path: 1 - 2 - 6 - 22 - 30 - 27 - 29 - 17 - 25 - 29 - 30 - 27 - 31 - 38 - 40 - 41 - 44 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image", "/home/karel/FEL/ZKS/asciiart/samples/cloud.jpg", "--invert", "--scale", "1.0", "--output-console", "--output-console")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    // No specific assertion for console output
  }

  test("TDL=2; path: 1 - 2 - 7 - 23 - 17 - 25 - 29 - 17 - 25 - 31 - 38 - 40 - 41 - 44 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image", "/home/karel/FEL/ZKS/asciiart/samples/cloud.gif", "--invert", "--output-console", "--output-console")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    // No specific assertion for console output
  }

  test("TDL=2; path: 1 - 2 - 7 - 23 - 18 - 26 - 29 - 17 - 25 - 29 - 30 - 27 - 29 - 20 - 28 - 29 - 18 - 26 - 31 - 38 - 40 - 41 - 44 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image", "/home/karel/FEL/ZKS/asciiart/samples/cloud.gif", "--invert", "--flip", "x", "--output-console", "--output-console")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    // No specific assertion for console output
  }

  test("TDL=2; path: 1 - 2 - 7 - 23 - 20 - 28 - 29 - 17 - 25 - 29 - 30 - 27 - 29 - 20 - 28 - 31 - 38 - 40 - 41 - 44 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image", "/home/karel/FEL/ZKS/asciiart/samples/cloud.gif", "--invert", "--flip", "y", "--output-console", "--output-console")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    // No specific assertion for console output
  }

  test("TDL=2; path: 1 - 2 - 7 - 23 - 30 - 27 - 29 - 17 - 25 - 29 - 30 - 27 - 31 - 38 - 40 - 41 - 44 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image", "/home/karel/FEL/ZKS/asciiart/samples/cloud.gif", "--invert", "--scale", "1.0", "--output-console", "--output-console")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    // No specific assertion for console output
  }

  test("TDL=2; path: 1 - 2 - 8 - 24 - 17 - 25 - 29 - 17 - 25 - 31 - 38 - 40 - 41 - 44 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image", "/home/karel/FEL/ZKS/asciiart/samples/cloud.bmp", "--invert", "--output-console", "--output-console")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    // No specific assertion for console output
  }

  test("TDL=2; path: 1 - 2 - 8 - 24 - 18 - 26 - 29 - 17 - 25 - 29 - 30 - 27 - 29 - 20 - 28 - 29 - 18 - 26 - 31 - 38 - 40 - 41 - 44 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image", "/home/karel/FEL/ZKS/asciiart/samples/cloud.bmp", "--invert", "--flip", "x", "--output-console", "--output-console")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    // No specific assertion for console output
  }

  test("TDL=2; path: 1 - 2 - 8 - 24 - 20 - 28 - 29 - 17 - 25 - 29 - 30 - 27 - 29 - 20 - 28 - 31 - 38 - 40 - 41 - 44 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image", "/home/karel/FEL/ZKS/asciiart/samples/cloud.bmp", "--invert", "--rotate", "90", "--output-console", "--output-console")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    // No specific assertion for console output
  }

  test("TDL=2; path: 1 - 2 - 8 - 24 - 30 - 27 - 29 - 17 - 25 - 29 - 30 - 27 - 31 - 38 - 40 - 41 - 44 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image", "/home/karel/FEL/ZKS/asciiart/samples/cloud.bmp", "--invert", "--scale", "1.0", "--output-console", "--output-console")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    // No specific assertion for console output
  }

  test("TDL=2; path: 1 - 3 - 9 - 15 - 18 - 26 - 29 - 17 - 25 - 29 - 30 - 27 - 29 - 20 - 28 - 29 - 18 - 26 - 31 - 38 - 40 - 41 - 44 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image-random", "--flip", "x", "--output-console", "--output-console")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    // No specific assertion for console output
  }

  test("TDL=2; path: 1 - 3 - 9 - 15 - 20 - 28 - 29 - 17 - 25 - 29 - 30 - 27 - 29 - 20 - 28 - 31 - 38 - 40 - 41 - 44 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image-random", "--rotate", "90", "--output-console", "--output-console")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    // No specific assertion for console output
  }

  test("TDL=2; path: 1 - 3 - 9 - 15 - 30 - 27 - 29 - 17 - 25 - 29 - 30 - 27 - 31 - 38 - 40 - 41 - 44 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image-random", "--scale", "1.0", "--output-console", "--output-console")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    // No specific assertion for console output
  }

  test("TDL=2; path: 1 - 3 - 10 - 16 - 17 - 25 - 29 - 17 - 25 - 31 - 38 - 40 - 41 - 44 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image-random-gradient", "--invert", "--output-console", "--output-console")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    // No specific assertion for console output
  }

  test("TDL=2; path: 1 - 3 - 10 - 16 - 18 - 26 - 29 - 17 - 25 - 29 - 30 - 27 - 29 - 20 - 28 - 29 - 18 - 26 - 31 - 38 - 40 - 41 - 44 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image-random-gradient", "--flip", "x", "--output-console", "--output-console")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    // No specific assertion for console output
  }

  test("TDL=2; path: 1 - 3 - 10 - 16 - 20 - 28 - 29 - 17 - 25 - 29 - 30 - 27 - 29 - 20 - 28 - 31 - 38 - 40 - 41 - 44 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image-random-gradient", "--rotate", "90", "--output-console", "--output-console")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    // No specific assertion for console output
  }

  test("TDL=2; path: 1 - 3 - 10 - 16 - 30 - 27 - 29 - 17 - 25 - 29 - 30 - 27 - 31 - 38 - 40 - 41 - 44 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image-random-gradient", "--scale", "1.0", "--output-console", "--output-console")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    // No specific assertion for console output
  }

  test("TDL=2; path: 1 - 2 - 5 - 32 - 38 - 40 - 41 - 44 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image", "/home/karel/FEL/ZKS/asciiart/samples/cloud.png", "--output-console")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    // No specific assertion for console output
  }

  test("TDL=2; path: 1 - 2 - 5 - 32 - 39 - 47 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image", "/home/karel/FEL/ZKS/asciiart/samples/cloud.png", "--invert", "--output-console")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    // No specific assertion for console output
  }

  test("TDL=2; path: 1 - 2 - 6 - 33 - 38 - 40 - 41 - 44 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image", "/home/karel/FEL/ZKS/asciiart/samples/cloud.jpg", "--output-console")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    // No specific assertion for console output
  }

  test("TDL=2; path: 1 - 2 - 6 - 33 - 39 - 47 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image", "/home/karel/FEL/ZKS/asciiart/samples/cloud.jpg", "--invert", "--output-console")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    // No specific assertion for console output
  }

  test("TDL=2; path: 1 - 2 - 7 - 34 - 38 - 40 - 41 - 44 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image", "/home/karel/FEL/ZKS/asciiart/samples/cloud.gif", "--output-console")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    // No specific assertion for console output
  }

  test("TDL=2; path: 1 - 2 - 7 - 34 - 39 - 47 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image", "/home/karel/FEL/ZKS/asciiart/samples/cloud.gif", "--invert", "--output-console")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    // No specific assertion for console output
  }

  test("TDL=2; path: 1 - 2 - 8 - 35 - 38 - 40 - 41 - 44 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image", "/home/karel/FEL/ZKS/asciiart/samples/cloud.bmp", "--output-console")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    // No specific assertion for console output
  }

  test("TDL=2; path: 1 - 2 - 8 - 35 - 39 - 47 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image", "/home/karel/FEL/ZKS/asciiart/samples/cloud.bmp", "--invert", "--output-console")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    // No specific assertion for console output
  }

  test("TDL=2; path: 1 - 3 - 9 - 36 - 38 - 40 - 41 - 44 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image-random", "--output-console")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    // No specific assertion for console output
  }

  test("TDL=2; path: 1 - 3 - 9 - 36 - 39 - 47 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image-random", "--invert", "--output-console")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    // No specific assertion for console output
  }

  test("TDL=2; path: 1 - 3 - 10 - 37 - 38 - 40 - 41 - 44 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image-random-gradient", "--output-console")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    // No specific assertion for console output
  }

  test("TDL=2; path: 1 - 3 - 10 - 37 - 39 - 47 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image-random-gradient", "--invert", "--output-console")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    // No specific assertion for console output
  }

  test("TDL=2; path: 1 - 2 - 5 - 32 - 39 - 47 - 48 - 50") {
    val controller = new ConsoleController()
    val args = List("--image", "/home/karel/FEL/ZKS/asciiart/samples/cloud.png", "--invert", "--output-file", "/home/karel/FEL/ZKS/asciiart/samples/output-cloud.txt")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get("/home/karel/FEL/ZKS/asciiart/samples/output-cloud.txt")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

}
