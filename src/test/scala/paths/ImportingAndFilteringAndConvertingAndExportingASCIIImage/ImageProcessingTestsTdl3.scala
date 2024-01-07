package paths.ImportingAndFilteringAndConvertingAndExportingASCIIImage

import asciiart.controllers.ConsoleController
import asciiart.ui.ConsoleView
import org.scalatest.FunSuite

import java.nio.file.{Files, Paths}


class ImageProcessingTestsTdl3 extends FunSuite {

//  test("TDL=3; path: 4") {
//    val controller = new ConsoleController()
//    controller.showHelp()
//    assert(controller.getLastMessage().contains("Usage: run [options]"))
//  }
//
//  test("TDL=3; path: 1 - 2 - 5 - 11") {
//    val controller = new ConsoleController()
//    val args = List("--image", "/home/karel/FEL/ZKS/asciiart/samples/cloud2.png")
//    val consoleView = new ConsoleView(controller, args)
//    consoleView.run()
//
//    val expectedErrorMessage = "Unable to load image with provided path: '/home/karel/FEL/ZKS/asciiart/samples/cloud2.png'"
//    assert(controller.getLastErrorMessage.contains(expectedErrorMessage))
//  }
//
//  test("TDL=3; path: 1 - 2 - 6 - 12") {
//    val controller = new ConsoleController()
//    val args = List("--image", "/home/karel/FEL/ZKS/asciiart/samples/cloud2.jpg")
//    val consoleView = new ConsoleView(controller, args)
//    consoleView.run()
//
//    val expectedErrorMessage = "Unable to load image with provided path: '/home/karel/FEL/ZKS/asciiart/samples/cloud2.jpg'"
//    assert(controller.getLastErrorMessage.contains(expectedErrorMessage))
//  }
//
//  test("TDL=3; path: 1 - 2 - 7 - 13") {
//    val controller = new ConsoleController()
//    val args = List("--image", "/home/karel/FEL/ZKS/asciiart/samples/cloud2.png")
//    val consoleView = new ConsoleView(controller, args)
//    consoleView.run()
//
//    val expectedErrorMessage = "Unable to load image with provided path: '/home/karel/FEL/ZKS/asciiart/samples/cloud2.png'"
//    assert(controller.getLastErrorMessage.contains(expectedErrorMessage))
//  }
//
//  test("TDL=3; path: 1 - 2 - 8 - 14") {
//    val controller = new ConsoleController()
//    val args = List("--image", "/home/karel/FEL/ZKS/asciiart/samples/cloud2.gif")
//    val consoleView = new ConsoleView(controller, args)
//    consoleView.run()
//
//    val expectedErrorMessage = "Unable to load image with provided path: '/home/karel/FEL/ZKS/asciiart/samples/cloud2.gif'"
//    assert(controller.getLastErrorMessage.contains(expectedErrorMessage))
//  }
//
//  test("TDL=3; path: 1 - 3 - 9 - 15 - 17 - 25 - 29 - 17 - 25 - 31 - 38 - 40 - 41 - 44 - 48 - 49") {
//    val controller = new ConsoleController()
//    val args = List("--image-random", "--invert", "--rotate", "+90", "--scale", "4", "--flip", "x", "--table", "paulbourke", "--output-console")
//    val consoleView = new ConsoleView(controller, args)
//    consoleView.run()
//
//    // Since this path involves console output, we won't assert the last message.
//    // You can add additional checks here if needed.
//  }
//
//  test("TDL=3; path: 1 - 3 - 10 - 16 - 17 - 25 - 29 - 18 - 26 - 29 - 17 - 25 - 31 - 39 - 47 - 48 - 49") {
//    val controller = new ConsoleController()
//    val args = List("--image-random-gradient", "--invert", "--rotate", "+90", "--scale", "4", "--flip", "y", "--table", "nonlinear", "--output-file", "/home/karel/FEL/ZKS/asciiart/samples/output.txt")
//    val consoleView = new ConsoleView(controller, args)
//    consoleView.run()
//
//    val outputPath = Paths.get("/home/karel/FEL/ZKS/asciiart/samples/output.txt")
//    assert(Files.exists(outputPath))
//    Files.deleteIfExists(outputPath)
//  }
//
//  test("TDL=3; path: 1 - 2 - 5 - 21 - 17 - 25 - 29 - 20 - 28 - 29 - 17 - 25 - 31 - 38 - 40 - 42 - 45 - 48 - 49") {
//    val controller = new ConsoleController()
//    val args = List("--image", "/home/karel/FEL/ZKS/asciiart/samples/cloud.bmp", "--invert", "--rotate", "+90", "--scale", "4", "--flip", "x", "--table", "paulbourke", "--output-rgb-file", "/home/karel/FEL/ZKS/asciiart/samples/output-cloud.bmp")
//    val consoleView = new ConsoleView(controller, args)
//    consoleView.run()
//
//    val outputPath = Paths.get("/home/karel/FEL/ZKS/asciiart/samples/output-cloud.bmp")
//    assert(Files.exists(outputPath))
//    Files.deleteIfExists(outputPath)
//  }
//
//  test("TDL=3; path: 1 - 2 - 5 - 21 - 18 - 26 - 31 - 38 - 40 - 43 - 46 - 48 - 49") {
//    val controller = new ConsoleController()
//    val args = List("--image", "/home/karel/FEL/ZKS/asciiart/samples/cloud.bmp", "--invert", "--rotate", "-90", "--scale", "4", "--flip", "y", "--table", "patternbased", "--output-rgb-file", "/home/karel/FEL/ZKS/asciiart/samples/output-cloud.bmp")
//    val consoleView = new ConsoleView(controller, args)
//    consoleView.run()
//
//    val outputPath = Paths.get("/home/karel/FEL/ZKS/asciiart/samples/output-cloud.bmp")
//    assert(Files.exists(outputPath))
//    Files.deleteIfExists(outputPath)
//  }
//
//  test("TDL=3; path: 1 - 2 - 5 - 21 - 20 - 28 - 31 - 38 - 40 - 41 - 44 - 48 - 49") {
//    val controller = new ConsoleController()
//    val args = List("--image", "/home/karel/FEL/ZKS/asciiart/samples/cloud.bmp", "--invert", "--scale", "4", "--table", "nonlinear", "--output-rgb-file", "/home/karel/FEL/ZKS/asciiart/samples/output-cloud.bmp")
//    val consoleView = new ConsoleView(controller, args)
//    consoleView.run()
//
//    val outputPath = Paths.get("/home/karel/FEL/ZKS/asciiart/samples/output-cloud.bmp")
//    assert(Files.exists(outputPath))
//    Files.deleteIfExists(outputPath)
//  }
//
//  test("TDL=3; path: 1 - 2 - 5 - 21 - 30 - 27 - 29 - 17 - 25 - 29 - 30 - 27 - 31 - 38 - 40 - 41 - 44 - 48 - 49") {
//    val controller = new ConsoleController()
//    val args = List("--image", "/home/karel/FEL/ZKS/asciiart/samples/cloud.bmp", "--invert", "--scale", "4", "--table", "nonlinear", "--output-rgb-file", "/home/karel/FEL/ZKS/asciiart/samples/output-cloud.bmp")
//    val consoleView = new ConsoleView(controller, args)
//    consoleView.run()
//
//    val outputPath = Paths.get("/home/karel/FEL/ZKS/asciiart/samples/output-cloud.bmp")
//    assert(Files.exists(outputPath))
//    Files.deleteIfExists(outputPath)
//  }
//
//  test("TDL=3; path: 1 - 2 - 6 - 22 - 17 - 25 - 29 - 17 - 25 - 31 - 38 - 40 - 41 - 44 - 48 - 49") {
//    val controller = new ConsoleController()
//    val args = List("--image", "/home/karel/FEL/ZKS/asciiart/samples/cloud.jpg", "--rotate", "+180", "--table", "paulbourke", "--output-rgb-file", "/home/karel/FEL/ZKS/asciiart/samples/output-cloud.jpg")
//    val consoleView = new ConsoleView(controller, args)
//    consoleView.run()
//
//    val outputPath = Paths.get("/home/karel/FEL/ZKS/asciiart/samples/output-cloud.jpg")
//    assert(Files.exists(outputPath))
//    Files.deleteIfExists(outputPath)
//  }
//
//  test("TDL=3; path: 1 - 2 - 6 - 22 - 18 - 26 - 29 - 17 - 25 - 29 - 30 - 27 - 29 - 20 - 28 - 29 - 18 - 26 - 31 - 38 - 40 - 41 - 44 - 48 - 49") {
//    val controller = new ConsoleController()
//    val args = List("--image", "/home/karel/FEL/ZKS/asciiart/samples/cloud.jpg", "--rotate", "90", "--invert", "--scale", "4", "--flip", "x", "--table", "nonlinear", "--output-rgb-file", "/home/karel/FEL/ZKS/asciiart/samples/output-cloud.jpg")
//    val consoleView = new ConsoleView(controller, args)
//    consoleView.run()
//
//    val outputPath = Paths.get("/home/karel/FEL/ZKS/asciiart/samples/output-cloud.jpg")
//    assert(Files.exists(outputPath))
//    Files.deleteIfExists(outputPath)
//  }
//
//
//  test("TDL=3; path: 1 - 2 - 6 - 22 - 20 - 28 - 29 - 17 - 25 - 29 - 30 - 27 - 29 - 20 - 28 - 31 - 38 - 40 - 41 - 44 - 48 - 49") {
//    val controller = new ConsoleController()
//    val args = List("--image", "/home/karel/FEL/ZKS/asciiart/samples/cloud.jpg", "--rotate", "+90", "--invert", "--scale", "1", "--flip", "y", "--table", "nonlinear", "--output-rgb-file", "/home/karel/FEL/ZKS/asciiart/samples/output-cloud.jpg")
//    val consoleView = new ConsoleView(controller, args)
//    consoleView.run()
//
//    val outputPath = Paths.get("/home/karel/FEL/ZKS/asciiart/samples/output-cloud.jpg")
//    assert(Files.exists(outputPath))
//    Files.deleteIfExists(outputPath)
//  }
//
//  test("TDL=3; path: 1 - 2 - 6 - 22 - 30 - 27 - 29 - 17 - 25 - 29 - 30 - 27 - 31 - 38 - 40 - 41 - 44 - 48 - 49") {
//    val controller = new ConsoleController()
//    val args = List("--image", "/home/karel/FEL/ZKS/asciiart/samples/cloud.jpg", "--rotate", "+180", "--scale", "0.25", "--table", "paulbourke", "--output-rgb-file", "/home/karel/FEL/ZKS/asciiart/samples/output-cloud.jpg")
//    val consoleView = new ConsoleView(controller, args)
//    consoleView.run()
//
//    val outputPath = Paths.get("/home/karel/FEL/ZKS/asciiart/samples/output-cloud.jpg")
//    assert(Files.exists(outputPath))
//    Files.deleteIfExists(outputPath)
//  }
//
//  test("TDL=3; path: 1 - 2 - 7 - 23 - 17 - 25 - 29 - 17 - 25 - 31 - 38 - 40 - 41 - 44 - 48 - 49") {
//    val controller = new ConsoleController()
//    val args = List("--image", "/home/karel/FEL/ZKS/asciiart/samples/cloud.png", "--rotate", "-90", "--table", "paulbourke", "--output-rgb-file", "/home/karel/FEL/ZKS/asciiart/samples/output-cloud.png")
//    val consoleView = new ConsoleView(controller, args)
//    consoleView.run()
//
//    val outputPath = Paths.get("/home/karel/FEL/ZKS/asciiart/samples/output-cloud.png")
//    assert(Files.exists(outputPath))
//    Files.deleteIfExists(outputPath)
//  }
//
//  test("TDL=3; path: 1 - 2 - 7 - 23 - 18 - 26 - 29 - 17 - 25 - 29 - 30 - 27 - 29 - 20 - 28 - 29 - 18 - 26 - 31 - 38 - 40 - 41 - 44 - 48 - 49") {
//    val controller = new ConsoleController()
//    val args = List("--image", "/home/karel/FEL/ZKS/asciiart/samples/cloud.png", "--rotate", "-90", "--invert", "--scale", "4", "--flip", "x", "--table", "nonlinear", "--output-rgb-file", "/home/karel/FEL/ZKS/asciiart/samples/output-cloud.png")
//    val consoleView = new ConsoleView(controller, args)
//    consoleView.run()
//
//    val outputPath = Paths.get("/home/karel/FEL/ZKS/asciiart/samples/output-cloud.png")
//    assert(Files.exists(outputPath))
//    Files.deleteIfExists(outputPath)
//  }
//
//  test("TDL=3; path: 1 - 2 - 7 - 23 - 20 - 28 - 29 - 17 - 25 - 29 - 30 - 27 - 29 - 20 - 28 - 31 - 38 - 40 - 41 - 44 - 48 - 49") {
//    val controller = new ConsoleController()
//    val args = List("--image", "/home/karel/FEL/ZKS/asciiart/samples/cloud.png", "--rotate", "-90", "--scale", "1", "--flip", "y", "--table", "paulbourke", "--output-rgb-file", "/home/karel/FEL/ZKS/asciiart/samples/output-cloud.png")
//    val consoleView = new ConsoleView(controller, args)
//    consoleView.run()
//
//    val outputPath = Paths.get("/home/karel/FEL/ZKS/asciiart/samples/output-cloud.png")
//    assert(Files.exists(outputPath))
//    Files.deleteIfExists(outputPath)
//  }
//
//  test("TDL=3; path: 1 - 2 - 7 - 23 - 30 - 27 - 29 - 17 - 25 - 29 - 30 - 27 - 31 - 38 - 40 - 41 - 44 - 48 - 49") {
//    val controller = new ConsoleController()
//    val args = List("--image", "/home/karel/FEL/ZKS/asciiart/samples/cloud.png", "--rotate", "-180", "--scale", "0.25", "--table", "nonlinear", "--output-rgb-file", "/home/karel/FEL/ZKS/asciiart/samples/output-cloud.png")
//    val consoleView = new ConsoleView(controller, args)
//    consoleView.run()
//
//    val outputPath = Paths.get("/home/karel/FEL/ZKS/asciiart/samples/output-cloud.png")
//    assert(Files.exists(outputPath))
//    Files.deleteIfExists(outputPath)
//  }
//
//  test("TDL=3; path: 1 - 2 - 8 - 24 - 17 - 25 - 29 - 17 - 25 - 31 - 38 - 40 - 41 - 44 - 48 - 49") {
//    val controller = new ConsoleController()
//    val args = List("--image", "/home/karel/FEL/ZKS/asciiart/samples/cloud.gif", "--rotate", "90", "--table", "paulbourke", "--output-rgb-file", "/home/karel/FEL/ZKS/asciiart/samples/output-cloud.gif")
//    val consoleView = new ConsoleView(controller, args)
//    consoleView.run()
//
//    val outputPath = Paths.get("/home/karel/FEL/ZKS/asciiart/samples/output-cloud.gif")
//    assert(Files.exists(outputPath))
//    Files.deleteIfExists(outputPath)
//  }
//
//  test("TDL=3; path: 1 - 2 - 8 - 24 - 18 - 26 - 29 - 17 - 25 - 29 - 30 - 27 - 29 - 20 - 28 - 29 - 18 - 26 - 31 - 38 - 40 - 41 - 44 - 48 - 49") {
//    val controller = new ConsoleController()
//    val args = List("--image", "/home/karel/FEL/ZKS/asciiart/samples/cloud.gif", "--rotate", "180", "--invert", "--scale", "4", "--flip", "x", "--table", "nonlinear", "--output-rgb-file", "/home/karel/FEL/ZKS/asciiart/samples/output-cloud.gif")
//    val consoleView = new ConsoleView(controller, args)
//    consoleView.run()
//
//    val outputPath = Paths.get("/home/karel/FEL/ZKS/asciiart/samples/output-cloud.gif")
//    assert(Files.exists(outputPath))
//    Files.deleteIfExists(outputPath)
//  }
//
//  test("TDL=3; path: 1 - 2 - 8 - 24 - 20 - 28 - 31 - 38 - 40 - 41 - 44 - 48 - 49") {
//    val controller = new ConsoleController()
//    val args = List("--image", "/home/karel/FEL/ZKS/asciiart/samples/cloud.gif", "--rotate", "270", "--scale", "1", "--table", "paulbourke", "--output-rgb-file", "/home/karel/FEL/ZKS/asciiart/samples/output-cloud.gif")
//    val consoleView = new ConsoleView(controller, args)
//    consoleView.run()
//
//    val outputPath = Paths.get("/home/karel/FEL/ZKS/asciiart/samples/output-cloud.gif")
//    assert(Files.exists(outputPath))
//    Files.deleteIfExists(outputPath)
//  }
//
//  test("TDL=3; path: 1 - 2 - 8 - 24 - 30 - 27 - 29 - 17 - 25 - 29 - 30 - 27 - 31 - 38 - 40 - 41 - 44 - 48 - 49") {
//    val controller = new ConsoleController()
//    val args = List("--image", "/home/karel/FEL/ZKS/asciiart/samples/cloud.gif", "--rotate", "270", "--scale", "0.25", "--table", "paulbourke", "--output-rgb-file", "/home/karel/FEL/ZKS/asciiart/samples/output-cloud.gif")
//    val consoleView = new ConsoleView(controller, args)
//    consoleView.run()
//
//    val outputPath = Paths.get("/home/karel/FEL/ZKS/asciiart/samples/output-cloud.gif")
//    assert(Files.exists(outputPath))
//    Files.deleteIfExists(outputPath)
//  }
//
//  test("TDL=3; path: 1 - 3 - 9 - 36 - 38 - 40 - 41 - 44 - 48 - 49") {
//    val controller = new ConsoleController()
//    val args = List("--image-random", "--table", "paulbourke", "--output-console")
//    val consoleView = new ConsoleView(controller, args)
//    consoleView.run()
//
//    // Verify console output (specific verification logic depends on your implementation)
//  }
//
//  test("TDL=3; path: 1 - 3 - 9 - 36 - 39 - 47 - 48 - 49") {
//    val controller = new ConsoleController()
//    val args = List("--image-random", "--table", "paulbourke", "--output-file", "/home/karel/FEL/ZKS/asciiart/samples/output-random.txt")
//    val consoleView = new ConsoleView(controller, args)
//    consoleView.run()
//
//    val outputPath = Paths.get("/home/karel/FEL/ZKS/asciiart/samples/output-random.txt")
//    assert(Files.exists(outputPath))
//    Files.deleteIfExists(outputPath)
//  }
//
//  test("TDL=3; path: 1 - 3 - 10 - 37 - 38 - 40 - 41 - 44 - 48 - 49") {
//    val controller = new ConsoleController()
//    val args = List("--image-random-gradient", "--table", "nonlinear", "--output-console")
//    val consoleView = new ConsoleView(controller, args)
//    consoleView.run()
//
//    // Verify console output (specific verification logic depends on your implementation)
//  }
//
//  test("TDL=3; path: 1 - 3 - 10 - 37 - 39 - 47 - 48 - 49") {
//    val controller = new ConsoleController()
//    val args = List("--image-random-gradient", "--table", "nonlinear", "--output-file", "/home/karel/FEL/ZKS/asciiart/samples/output-gradient.txt")
//    val consoleView = new ConsoleView(controller, args)
//    consoleView.run()
//
//    val outputPath = Paths.get("/home/karel/FEL/ZKS/asciiart/samples/output-gradient.txt")
//    assert(Files.exists(outputPath))
//    Files.deleteIfExists(outputPath)
//  }
//
//  test("TDL=3; path: 1 - 2 - 5 - 32 - 38 - 40 - 41 - 44 - 48 - 49") {
//    val controller = new ConsoleController()
//    val args = List("--image", "/home/karel/FEL/ZKS/asciiart/samples/cloud.jpg", "--table", "paulbourke", "--output-console")
//    val consoleView = new ConsoleView(controller, args)
//    consoleView.run()
//
//    // Verify console output (specific verification logic depends on your implementation)
//  }
//
//  test("TDL=3; path: 1 - 2 - 5 - 32 - 39 - 47 - 48 - 49") {
//    val controller = new ConsoleController()
//    val args = List("--image", "/home/karel/FEL/ZKS/asciiart/samples/cloud.jpg", "--table", "paulbourke", "--output-file", "/home/karel/FEL/ZKS/asciiart/samples/output-cloud.txt")
//    val consoleView = new ConsoleView(controller, args)
//    consoleView.run()
//
//    val outputPath = Paths.get("/home/karel/FEL/ZKS/asciiart/samples/output-cloud.txt")
//    assert(Files.exists(outputPath))
//    Files.deleteIfExists(outputPath)
//  }
//
//  test("TDL=3; path: 1 - 2 - 6 - 33 - 38 - 40 - 41 - 44 - 48 - 49") {
//    val controller = new ConsoleController()
//    val args = List("--image", "/home/karel/FEL/ZKS/asciiart/samples/cloud.png", "--table", "nonlinear", "--output-console")
//    val consoleView = new ConsoleView(controller, args)
//    consoleView.run()
//
//    // Verify console output (specific verification logic depends on your implementation)
//  }
//
//  test("TDL=3; path: 1 - 2 - 6 - 33 - 39 - 47 - 48 - 49") {
//    val controller = new ConsoleController()
//    val args = List("--image", "/home/karel/FEL/ZKS/asciiart/samples/cloud.png", "--table", "nonlinear", "--output-file", "/home/karel/FEL/ZKS/asciiart/samples/output-cloud.png.txt")
//    val consoleView = new ConsoleView(controller, args)
//    consoleView.run()
//
//    val outputPath = Paths.get("/home/karel/FEL/ZKS/asciiart/samples/output-cloud.png.txt")
//    assert(Files.exists(outputPath))
//    Files.deleteIfExists(outputPath)
//  }
//
//  test("TDL=3; path: 1 - 2 - 7 - 34 - 38 - 40 - 41 - 44 - 48 - 49") {
//    val controller = new ConsoleController()
//    val args = List("--image", "/home/karel/FEL/ZKS/asciiart/samples/cloud.gif", "--table", "paulbourke", "--output-console")
//    val consoleView = new ConsoleView(controller, args)
//    consoleView.run()
//
//    // Verify console output (specific verification logic depends on your implementation)
//  }
//
//  test("TDL=3; path: 1 - 2 - 7 - 34 - 39 - 47 - 48 - 49") {
//    val controller = new ConsoleController()
//    val args = List("--image", "/home/karel/FEL/ZKS/asciiart/samples/cloud.gif", "--table", "paulbourke", "--output-file", "/home/karel/FEL/ZKS/asciiart/samples/output-cloud.gif.txt")
//    val consoleView = new ConsoleView(controller, args)
//    consoleView.run()
//
//    val outputPath = Paths.get("/home/karel/FEL/ZKS/asciiart/samples/output-cloud.gif.txt")
//    assert(Files.exists(outputPath))
//    Files.deleteIfExists(outputPath)
//  }
//
//  test("TDL=3; path: 1 - 2 - 8 - 35 - 38 - 40 - 41 - 44 - 48 - 49") {
//    val controller = new ConsoleController()
//    val args = List("--image", "/home/karel/FEL/ZKS/asciiart/samples/cloud.bmp", "--table", "nonlinear", "--output-console")
//    val consoleView = new ConsoleView(controller, args)
//    consoleView.run()
//
//    // Verify console output (specific verification logic depends on your implementation)
//  }
//
//  test("TDL=3; path: 1 - 2 - 8 - 35 - 39 - 47 - 48 - 49") {
//    val controller = new ConsoleController()
//    val args = List("--image", "/home/karel/FEL/ZKS/asciiart/samples/cloud.bmp", "--table", "nonlinear", "--output-file", "/home/karel/FEL/ZKS/asciiart/samples/output-cloud.bmp.txt")
//    val consoleView = new ConsoleView(controller, args)
//    consoleView.run()
//
//    val outputPath = Paths.get("/home/karel/FEL/ZKS/asciiart/samples/output-cloud.bmp.txt")
//    assert(Files.exists(outputPath))
//    Files.deleteIfExists(outputPath)
//  }
//
//
//
//
//  test("TDL=3; path: 1 - 2 - 5 - 21 - 19") {
//    val controller = new ConsoleController()
//    val args = List("--image", "/home/karel/FEL/ZKS/asciiart/samples/cloud.bmp", "--invert", "--output-rgb-file", "/home/karel/FEL/ZKS/asciiart/samples/output-cloud.bmp")
//    val consoleView = new ConsoleView(controller, args)
//    consoleView.run()
//
//    val outputPath = Paths.get("/home/karel/FEL/ZKS/asciiart/samples/output-cloud.bmp")
//    assert(Files.exists(outputPath))
//    Files.deleteIfExists(outputPath)
//  }
//
//  test("TDL=3; path: 1 - 2 - 6 - 22 - 19") {
//    val controller = new ConsoleController()
//    val args = List("--image", "/home/karel/FEL/ZKS/asciiart/samples/cloud.jpg", "--invert", "--output-rgb-file", "/home/karel/FEL/ZKS/asciiart/samples/output-cloud.jpg")
//    val consoleView = new ConsoleView(controller, args)
//    consoleView.run()
//
//    val outputPath = Paths.get("/home/karel/FEL/ZKS/asciiart/samples/output-cloud.jpg")
//    assert(Files.exists(outputPath))
//    Files.deleteIfExists(outputPath)
//  }
//
//  test("TDL=3; path: 1 - 2 - 7 - 23 - 19") {
//    val controller = new ConsoleController()
//    val args = List("--image", "/home/karel/FEL/ZKS/asciiart/samples/cloud.png", "--invert", "--output-rgb-file", "/home/karel/FEL/ZKS/asciiart/samples/output-cloud.png")
//    val consoleView = new ConsoleView(controller, args)
//    consoleView.run()
//
//    val outputPath = Paths.get("/home/karel/FEL/ZKS/asciiart/samples/output-cloud.png")
//    assert(Files.exists(outputPath))
//    Files.deleteIfExists(outputPath)
//  }
//
//  test("TDL=3; path: 1 - 2 - 8 - 24 - 19") {
//    val controller = new ConsoleController()
//    val args = List("--image", "/home/karel/FEL/ZKS/asciiart/samples/cloud.gif", "--invert", "--output-rgb-file", "/home/karel/FEL/ZKS/asciiart/samples/output-cloud.gif")
//    val consoleView = new ConsoleView(controller, args)
//    consoleView.run()
//
//    val outputPath = Paths.get("/home/karel/FEL/ZKS/asciiart/samples/output-cloud.gif")
//    assert(Files.exists(outputPath))
//    Files.deleteIfExists(outputPath)
//  }
//
//  test("TDL=3; path: 1 - 3 - 9 - 15 - 19") {
//    val controller = new ConsoleController()
//    val args = List("--image-random", "--invert", "--output-file", "/home/karel/FEL/ZKS/asciiart/samples/output-random.txt")
//    val consoleView = new ConsoleView(controller, args)
//    consoleView.run()
//
//    val outputPath = Paths.get("/home/karel/FEL/ZKS/asciiart/samples/output-random.txt")
//    assert(Files.exists(outputPath))
//    Files.deleteIfExists(outputPath)
//  }
//
//  test("TDL=3; path: 1 - 3 - 10 - 16 - 19") {
//    val controller = new ConsoleController()
//    val args = List("--image-random-gradient", "--invert", "--output-file", "/home/karel/FEL/ZKS/asciiart/samples/output-gradient.txt")
//    val consoleView = new ConsoleView(controller, args)
//    consoleView.run()
//
//    val outputPath = Paths.get("/home/karel/FEL/ZKS/asciiart/samples/output-gradient.txt")
//    assert(Files.exists(outputPath))
//    Files.deleteIfExists(outputPath)
//  }
//



  val baseSamplePath = "samples/"
  val baseOutputPath = "samples/artifacts/"


  test("TDL=3; path: 4") {
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

  test("TDL=3; path: 1 - 3 - 9 - 15 - 17 - 25 - 29 - 17 - 25 - 31 - 38 - 40 - 41 - 44 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image-random", "--flip", "x", "--output-file", baseOutputPath + "output-random-flip.txt")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get(baseOutputPath + "output-random-flip.txt")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

  test("TDL=3; path: 1 - 3 - 10 - 16 - 17 - 25 - 29 - 18 - 26 - 29 - 17 - 25 - 31 - 39 - 47 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image-random-gradient", "--invert", "--rotate", "90", "--output-file", baseOutputPath + "output-random-gradient-invert-rotate.txt")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get(baseOutputPath + "output-random-gradient-invert-rotate.txt")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

  test("TDL=3; path: 1 - 2 - 5 - 21 - 17 - 25 - 29 - 20 - 28 - 29 - 17 - 25 - 31 - 38 - 40 - 42 - 45 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image", baseSamplePath + "cloud.png", "--flip", "x", "--invert", "--scale", "4", "--rotate", "90", "--output-file", baseOutputPath + "output-cloud-flip-invert-scale-rotate.txt")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get(baseOutputPath + "output-cloud-flip-invert-scale-rotate.txt")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

  test("TDL=3; path: 1 - 2 - 5 - 21 - 18 - 26 - 31 - 38 - 40 - 43 - 46 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image", baseSamplePath + "cloud.png", "--flip", "x", "--scale", "4", "--output-file", baseOutputPath + "output-cloud-flip-scale.txt")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get(baseOutputPath + "output-cloud-flip-scale.txt")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

  test("TDL=3; path: 1 - 2 - 5 - 21 - 20 - 28 - 31 - 38 - 40 - 41 - 44 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image", baseSamplePath + "cloud.png", "--flip", "x", "--invert", "--output-file", baseOutputPath + "output-cloud-flip-invert.txt")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get(baseOutputPath + "output-cloud-flip-invert.txt")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

  test("TDL=3; path: 1 - 2 - 5 - 21 - 30 - 27 - 29 - 17 - 25 - 29 - 30 - 27 - 31 - 38 - 40 - 41 - 44 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image", baseSamplePath + "cloud.png", "--flip", "x", "--output-console")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()
  }

  test("TDL=3; path: 1 - 2 - 6 - 22 - 17 - 25 - 29 - 17 - 25 - 31 - 38 - 40 - 41 - 44 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image", baseSamplePath + "cloud.jpg", "--invert", "--flip", "x", "--output-file", baseOutputPath + "output-cloud-invert-flip.txt")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get(baseOutputPath + "output-cloud-invert-flip.txt")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

  test("TDL=3; path: 1 - 2 - 6 - 22 - 18 - 26 - 29 - 18 - 26 - 31 - 39 - 47 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image", baseSamplePath + "cloud.jpg", "--invert", "--rotate", "90", "--scale", "4", "--output-file", baseOutputPath + "output-cloud-invert-rotate-scale.txt")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get(baseOutputPath + "output-cloud-invert-rotate-scale.txt")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

  test("TDL=3; path: 1 - 2 - 6 - 22 - 20 - 28 - 29 - 18 - 26 - 29 - 20 - 28 - 31 - 39 - 47 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image", baseSamplePath + "cloud.jpg", "--invert", "--scale", "1", "--output-file", baseOutputPath + "output-cloud-invert-scale.txt")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get(baseOutputPath + "output-cloud-invert-scale.txt")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

  test("TDL=3; path: 1 - 2 - 6 - 22 - 30 - 27 - 29 - 18 - 26 - 29 - 30 - 27 - 31 - 39 - 47 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image", baseSamplePath + "cloud.jpg", "--invert", "--output-console")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()
  }

  test("TDL=3; path: 1 - 2 - 7 - 23 - 17 - 25 - 29 - 17 - 25 - 31 - 38 - 40 - 41 - 44 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image", baseSamplePath + "cloud.gif", "--rotate", "90", "--flip", "x", "--output-file", baseOutputPath + "output-cloud-rotate-flip.txt")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get(baseOutputPath + "output-cloud-rotate-flip.txt")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

  test("TDL=3; path: 1 - 2 - 7 - 23 - 18 - 26 - 29 - 17 - 25 - 29 - 17 - 25 - 31 - 38 - 40 - 41 - 44 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image", baseSamplePath + "cloud.gif", "--rotate", "90", "--scale", "1", "--output-file", baseOutputPath + "output-cloud-rotate-scale.txt")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get(baseOutputPath + "output-cloud-rotate-scale.txt")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

  test("TDL=3; path: 1 - 2 - 7 - 23 - 20 - 28 - 29 - 20 - 28 - 31 - 38 - 40 - 41 - 44 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image", baseSamplePath + "cloud.gif", "--rotate", "90", "--invert", "--output-file", baseOutputPath + "output-cloud-rotate-invert.txt")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get(baseOutputPath + "output-cloud-rotate-invert.txt")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

  test("TDL=3; path: 1 - 2 - 7 - 23 - 30 - 27 - 29 - 20 - 28 - 29 - 30 - 27 - 31 - 38 - 40 - 41 - 44 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image", baseSamplePath + "cloud.gif", "--rotate", "90", "--output-console")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()
  }

  test("TDL=3; path: 1 - 2 - 8 - 24 - 17 - 25 - 29 - 17 - 25 - 31 - 38 - 40 - 41 - 44 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image", baseSamplePath + "cloud.bmp", "--scale", "4", "--flip", "x", "--output-file", baseOutputPath + "output-cloud-scale-flip.txt")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get(baseOutputPath + "output-cloud-scale-flip.txt")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

  test("TDL=3; path: 1 - 2 - 8 - 24 - 18 - 26 - 29 - 17 - 25 - 29 - 17 - 25 - 31 - 38 - 40 - 41 - 44 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image", baseSamplePath + "cloud.bmp", "--scale", "0.25", "--invert", "--output-file", baseOutputPath + "output-cloud-scale-invert.txt")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get(baseOutputPath + "output-cloud-scale-invert.txt")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

  test("TDL=3; path: 1 - 2 - 8 - 24 - 20 - 28 - 29 - 17 - 25 - 29 - 17 - 25 - 31 - 38 - 40 - 41 - 44 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image", baseSamplePath + "cloud.bmp", "--scale", "1", "--output-console")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()
  }

  test("TDL=3; path: 1 - 2 - 8 - 24 - 30 - 27 - 29 - 30 - 27 - 31 - 38 - 40 - 41 - 44 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image", baseSamplePath + "cloud.bmp", "--scale", "4", "--output-console")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()
  }

  test("TDL=3; path: 1 - 3 - 9 - 15 - 18 - 26 - 29 - 17 - 25 - 29 - 17 - 25 - 31 - 38 - 40 - 41 - 44 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image-random", "--flip", "x", "--invert", "--output-file", baseOutputPath + "output-random-flip-invert.txt")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get(baseOutputPath + "output-random-flip-invert.txt")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

  test("TDL=3; path: 1 - 3 - 9 - 15 - 20 - 28 - 29 - 17 - 25 - 29 - 17 - 25 - 31 - 38 - 40 - 41 - 44 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image-random", "--flip", "x", "--output-console")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()
  }

  test("TDL=3; path: 1 - 3 - 9 - 15 - 30 - 27 - 29 - 17 - 25 - 29 - 17 - 25 - 31 - 38 - 40 - 41 - 44 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image-random", "--flip", "x", "--output-console")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()
  }

  test("TDL=3; path: 1 - 3 - 10 - 16 - 18 - 26 - 29 - 17 - 25 - 29 - 17 - 25 - 31 - 38 - 40 - 41 - 44 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image-random-gradient", "--invert", "--output-file", baseOutputPath + "output-random-gradient-invert.txt")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get(baseOutputPath + "output-random-gradient-invert.txt")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

  test("TDL=3; path: 1 - 3 - 10 - 16 - 20 - 28 - 29 - 17 - 25 - 29 - 17 - 25 - 31 - 38 - 40 - 41 - 44 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image-random-gradient", "--invert", "--output-console")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()
  }

  test("TDL=3; path: 1 - 3 - 10 - 16 - 30 - 27 - 29 - 17 - 25 - 29 - 17 - 25 - 31 - 38 - 40 - 41 - 44 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image-random-gradient", "--invert", "--output-console")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()
  }

  test("TDL=3; path: 1 - 2 - 5 - 32 - 38 - 40 - 41 - 44 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image", baseSamplePath + "cloud.png", "--output-console")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()
  }

  test("TDL=3; path: 1 - 2 - 5 - 32 - 39 - 47 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image", baseSamplePath + "cloud.png", "--output-file", baseOutputPath + "output-cloud.txt")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get(baseOutputPath + "output-cloud.txt")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

  test("TDL=3; path: 1 - 2 - 6 - 33 - 38 - 40 - 41 - 44 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image", baseSamplePath + "cloud.jpg", "--output-console")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()
  }

  test("TDL=3; path: 1 - 2 - 6 - 33 - 39 - 47 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image", baseSamplePath + "cloud.jpg", "--output-file", baseOutputPath + "output-cloud.jpg.txt")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get(baseOutputPath + "output-cloud.jpg.txt")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

  test("TDL=3; path: 1 - 2 - 7 - 34 - 38 - 40 - 41 - 44 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image", baseSamplePath + "cloud.gif", "--output-console")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()
  }

  test("TDL=3; path: 1 - 2 - 7 - 34 - 39 - 47 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image", baseSamplePath + "cloud.gif", "--output-file", baseOutputPath + "output-cloud.gif.txt")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get(baseOutputPath + "output-cloud.gif.txt")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

  test("TDL=3; path: 1 - 2 - 8 - 35 - 38 - 40 - 41 - 44 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image", baseSamplePath + "cloud.bmp", "--output-console")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()
  }

  test("TDL=3; path: 1 - 2 - 8 - 35 - 39 - 47 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image", baseSamplePath + "cloud.bmp", "--output-file", baseOutputPath + "output-cloud.bmp.txt")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get(baseOutputPath + "output-cloud.bmp.txt")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

  test("TDL=3; path: 1 - 3 - 9 - 36 - 38 - 40 - 41 - 44 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image-random", "--output-console")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()
  }

  test("TDL=3; path: 1 - 3 - 9 - 36 - 39 - 47 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image-random", "--output-file", baseOutputPath + "output-random.txt")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get(baseOutputPath + "output-random.txt")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

  test("TDL=3; path: 1 - 3 - 10 - 37 - 38 - 40 - 41 - 44 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image-random-gradient", "--output-console")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()
  }

  test("TDL=3; path: 1 - 3 - 10 - 37 - 39 - 47 - 48 - 49") {
    val controller = new ConsoleController()
    val args = List("--image-random-gradient", "--output-file", baseOutputPath + "output-random-gradient.txt")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get(baseOutputPath + "output-random-gradient.txt")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

  test("TDL=3; path: 1 - 2 - 5 - 32 - 39 - 47 - 48 - 50") {
    val controller = new ConsoleController()
    val args = List("--image", baseSamplePath + "cloud.png", "--output-rgb-file", baseOutputPath + "output-cloud-rgb.txt")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()

    val outputPath = Paths.get(baseOutputPath + "output-cloud-rgb.txt")
    assert(Files.exists(outputPath))
    Files.deleteIfExists(outputPath)
  }

  test("TDL=3; path: 1 - 2 - 5 - 32 - 38 - 40 - 41 - 44 - 48 - 50") {
    val controller = new ConsoleController()
    val args = List("--image", baseSamplePath + "cloud.png", "--output-rgb-file", baseOutputPath + "output-cloud-rgb-console.txt")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()
  }

  test("TDL=3; path: 1 - 2 - 5 - 32 - 38 - 40 - 42 - 45 - 48 - 50") {
    val controller = new ConsoleController()
    val args = List("--image", baseSamplePath + "cloud.png", "--output-rgb-file", baseOutputPath + "output-cloud-rgb-flip.txt")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()
  }

  test("TDL=3; path: 1 - 2 - 5 - 32 - 38 - 40 - 43 - 46 - 48 - 50") {
    val controller = new ConsoleController()
    val args = List("--image", baseSamplePath + "cloud.png", "--output-rgb-file", baseOutputPath + "output-cloud-rgb-scale.txt")
    val consoleView = new ConsoleView(controller, args)
    consoleView.run()
  }
}
