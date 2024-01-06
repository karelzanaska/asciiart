package asciiart.ui

import asciiart.controllers.Controller
import asciiart.image.convertors.image.ImageConverter
import asciiart.image.exporters.{ImageExporter, RGBImageExporter}
import asciiart.image.filters.ImageFilter
import asciiart.image.importers.ImageImporter
import asciiart.image.models.image.{AsciiImage, RGBImage}


class TestableConsoleView(
                           val controller: Controller[RGBImage, AsciiImage],
                           val imageImporter: Option[ImageImporter[RGBImage]],
                           val asciiImageConverter: Option[ImageConverter[RGBImage, AsciiImage]],
                           val imageRGBExporters: List[ImageExporter[RGBImage]],
                           val imageAsciiExporters: List[ImageExporter[AsciiImage]],
                           val imageFilters: List[ImageFilter[RGBImage]]
                         ) {
  // Method to execute the conversion process and capture the output
  def executeAndCaptureOutput(): Option[AsciiImage] = {
    imageImporter.flatMap { importer =>
      val rgbImageOption = controller.importImage(importer)

      // Apply filters only if rgbImage is present
      val filteredImageOption = rgbImageOption.flatMap { rgbImage =>
        imageFilters.foldLeft(Option(rgbImage)) { (accOption, filter) =>
          accOption.flatMap(acc => controller.applyFilter(acc, filter))
        }
      }

      // Apply converter only if filteredImage is present
      val asciiImageOption = filteredImageOption.flatMap { filteredImage =>
        asciiImageConverter.flatMap(converter => controller.applyConvertor(filteredImage, converter))
      }


      filteredImageOption.foreach { filteredImage =>
        imageRGBExporters.foreach(exporter => {
          if (exporter.isInstanceOf[RGBImageExporter]) {
            exporter.exportImage(filteredImage)
          }
        })
      }
      asciiImageOption.foreach { asciiImage =>
        imageAsciiExporters.foreach(exporter => {
          if (exporter.isInstanceOf[ImageExporter[AsciiImage]]) {
            controller.exportImage(asciiImage, exporter)
          }
        })
      }

      asciiImageOption
    }
  }
}
