package asciiart.controllers

import asciiart.Main.controller
import asciiart.image.filters.ImageFilter
import asciiart.image.importers.ImageImporter
import asciiart.image.models.image.RGBImage
import org.mockito.ArgumentMatchersSugar.any
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.FunSuite

import java.io.ByteArrayOutputStream

class ConsoleControllerTest extends FunSuite {

  test("showHelp should print correct usage message") {
    val controller = new ConsoleController()
    val output = new ByteArrayOutputStream()
    Console.withOut(output) {
      controller.showHelp()
    }
    val outputString = output.toString("UTF-8")
//    val expectedOutput = "Usage: run [options]\n\nOptions:\n--image <image_path> Path to the image file to be processed. Supported image formats are JPG and PNG.\n--image-random Generate a random image.\n--output-file <output_path> Path to the output file. The output file must be a TXT file.\n--output-console Print ascii image to standard output.\n--rotate <degrees> Rotate the image by the specified angle. The angle must be a valid number divisible by 90.\n--scale <factor> Scale the image by the specified factor. Supported factors are 0.25, 1, 4.\n--flip <direction> Flip the image horizontally (x) or vertically (y).\n--table <table_type> Convert the image to ASCII art using the specified table. Supported table types are 'paulbourke' and 'nonlinear'. Default is 'paulbourke'.\n--custom-table <table_path> Convert the image to ASCII art using the specified custom table.\n\nExample:\nprogram --image test.jpg --rotate 90 --output-file test.txt\nprogram --image-random --scale 0.25 --flip y --table paulbourke\nprogram --custom-table 1{}[]?-_+~<>i!lI;:, --output-console test.txt"
    val expectedOutput = "Usage: run [options]\n\nOptions:\n--image <image_path> Path to the image file to be processed. Supported image formats are JPG and PNG.\n--image-random Generate a random image.\n--output-file <output_path> Path to the output file. The output file must be a TXT file.\n--output-console Print ascii image to standard output.\n--rotate <degrees> Rotate the image by the specified angle. The angle must be a valid number divisible by 90.\n--scale <factor> Scale the image by the specified factor. Supported factors are 0.25, 1, 4.\n--flip <direction> Flip the image horizontally (x) or vertically (y).\n--invert Invert the image.\n--table <table_type> Convert the image to ASCII art using the specified table. Supported table types are 'paulbourke' and 'nonlinear'. Default is 'paulbourke'.\n--custom-table <table_path> Convert the image to ASCII art using the specified custom table.\n\nExample:\nprogram --image test.jpg --rotate 90 --output-file test.txt\nprogram --image-random --scale 0.25 --flip y --table paulbourke\nprogram --custom-table 1{}[]?-_+~<>i!lI;:, --output-console test.txt"
    assert(outputString == expectedOutput)
  }

  test("showErrorMessage should print correct error message") {
    val controller = new ConsoleController()
    val output = new ByteArrayOutputStream()
    Console.withErr(output) {
      controller.showErrorMessage("An error occurred")
    }
    val outputString = output.toString("UTF-8")
    assert(outputString === "An error occurred\n")
  }

  test("importImage should return None when image is not valid") {
    val imageImporter = mock[ImageImporter[RGBImage]]
    when(imageImporter.importImage()).thenReturn(Left("Test error message"))
    val result = new ConsoleController().importImage(imageImporter)
    assert(result === None)
  }

  test("importImage should import RGBImage when image is valid") {
    val imageImporter = mock[ImageImporter[RGBImage]]
    when(imageImporter.importImage()).thenReturn(Right(mock[RGBImage]))
    val result = new ConsoleController().importImage(imageImporter)
    assert(result.isDefined)
  }

  test("applyFilter should return None is image is not valid") {
    val filter = mock[ImageFilter[RGBImage]]
    when(filter.apply(any[RGBImage])).thenReturn(Left("Test error message"))
    val result = new ConsoleController().applyFilter(mock[RGBImage], filter)
    assert(result === None)
  }

}
