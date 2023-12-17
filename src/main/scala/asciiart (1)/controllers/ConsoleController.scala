package asciiart.controllers

import asciiart.image.convertors.image.ImageConvertor
import asciiart.image.exporters.ImageExporter
import asciiart.image.filters.ImageFilter
import asciiart.image.importers.ImageImporter
import asciiart.image.models.image.{AsciiImage, Image, RGBImage}

import scala.Console.err

class ConsoleController() extends Controller[RGBImage, AsciiImage] {

  override def showHelp(): Unit = {
    val output = "Usage: run [options]\n\nOptions:\n--image <image_path> Path to the image file to be processed. Supported image formats are JPG and PNG.\n--image-random Generate a random image.\n--output-file <output_path> Path to the output file. The output file must be a TXT file.\n--output-console Print ascii image to standard output.\n--rotate <degrees> Rotate the image by the specified angle. The angle must be a valid number divisible by 90.\n--scale <factor> Scale the image by the specified factor. Supported factors are 0.25, 1, 4.\n--flip <direction> Flip the image horizontally (x) or vertically (y).\n--invert Invert the image.\n--table <table_type> Convert the image to ASCII art using the specified table. Supported table types are 'paulbourke' and 'nonlinear'. Default is 'paulbourke'.\n--custom-table <table_path> Convert the image to ASCII art using the specified custom table.\n\nExample:\nprogram --image test.jpg --rotate 90 --output-file test.txt\nprogram --image-random --scale 0.25 --flip y --table paulbourke\nprogram --custom-table 1{}[]?-_+~<>i!lI;:, --output-console test.txt"

    print(output)
  }

  override def showErrorMessage(message: String): Unit = {
    err.println(message)
  }

  override def importImage(imageImporter: ImageImporter[RGBImage]): Option[RGBImage] = {
    imageImporter.importImage() match {
      case Left(message) =>
        showErrorMessage(message)
        None
      case Right(image) => Some(image)
    }
  }

  override def applyFilter(image: RGBImage, filter: ImageFilter[RGBImage]): Option[RGBImage] = {
    filter.apply(image) match {
      case Left(message) =>
        showErrorMessage(message)
        None
      case Right(image) => Some(image)
    }
  }

  override def exportImage(image: AsciiImage, imageExporter: ImageExporter[AsciiImage]): Unit = {
    imageExporter.exportImage(image) match {
      case Left(message) => showErrorMessage(message)
      case Right(_) =>
    }
  }

  override def applyConvertor(image: RGBImage, imageConvertor: ImageConvertor[RGBImage, AsciiImage]): Option[AsciiImage] = {
    imageConvertor.convert(image).fold(
        message => {
            showErrorMessage(message)
            return None
        },
        image => return Some(image)
    )
  }

}
