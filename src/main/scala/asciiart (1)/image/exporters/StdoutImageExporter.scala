package asciiart.image.exporters

import asciiart.image.models.image.{AsciiImage, Image}

/**
 * Exports an image to the standard output
 */
case class StdoutImageExporter() extends ImageExporter[AsciiImage] {

  override def exportImage(image: AsciiImage): Either[String, Unit] = {
    print(image.toString)
    Right(())
  }

}
