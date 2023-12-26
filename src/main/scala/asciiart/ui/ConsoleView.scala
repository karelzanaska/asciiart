package asciiart.ui

import asciiart.controllers.Controller
import asciiart.image.convertors.image.ImageConverter
import asciiart.image.exporters.ImageExporter
import asciiart.image.filters.ImageFilter
import asciiart.image.importers.ImageImporter
import asciiart.image.models.image.{AsciiImage, RGBImage}


class ConsoleView(val controller: Controller[RGBImage, AsciiImage], args: List[String]) {

  private def validateEither[T](either: Either[String, T]): Option[T] = {
    either match {
      case Left(value) =>
        controller.showErrorMessage(value)
        None
      case Right(value) => Some(value)
    }
  }

  def run(): Unit = {
    val consoleParser: ConsoleParser = new ConsoleParser(args)

    // if the user wants to see the help message, show it and exit
    if (consoleParser.isHelp()) {
      controller.showHelp()
      return
    }

    val imageImporter: Option[ImageImporter[RGBImage]] = validateEither(consoleParser.getImageImporter())
    val asciiImageConvertor: Option[ImageConverter[RGBImage, AsciiImage]] = validateEither(consoleParser.getAsciiImageConvertor())
    val imageRGBExporters: Option[List[ImageExporter[RGBImage]]] = validateEither(consoleParser.getRGBImageExporters())
    val imageAsciiExporters: Option[List[ImageExporter[AsciiImage]]] = validateEither(consoleParser.getAsciiImageExporters())
    val imageFilters: Option[List[ImageFilter[RGBImage]]] = validateEither(consoleParser.getImageFilters())

    (imageImporter, asciiImageConvertor, imageAsciiExporters) match {
      case (Some(image), Some(convertor), Some(exporters)) =>
        val imageImporter = controller.importImage(image)

        val rgbImage = imageImporter

        val filteredImage = imageFilters.getOrElse(Nil).foldLeft(rgbImage)((acc, filter) => controller.applyFilter(acc.getOrElse(return ), filter)).getOrElse(return )

        val asciiImage = controller.applyConvertor(filteredImage, convertor)
        imageRGBExporters.getOrElse(Nil).foreach(exporter => {
          exporter.exportImage(filteredImage)
        })
        val exportedAsciiImage = asciiImage.getOrElse(return)

        exporters.foreach(exporter => {
          controller.exportImage(exportedAsciiImage, exporter)
        })
      case _ =>
    }
  }

}
