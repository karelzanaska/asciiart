package asciiart.image.convertors.image


import asciiart.image.models.image.{AsciiImage, RGBImage}
import asciiart.image.models.pixel.{AsciiPixel, RGBPixel}
import asciiart.image.convertors.image.ImageConverter
import asciiart.image.models.grid.PixelGrid


case class PatternBasedAsciiImageConverter() extends ImageConverter[RGBImage, AsciiImage] {

  private val patterns = List(
    (0 to 25, ' '),
    (26 to 50, '.'),
    (51 to 75, ':'),
    (76 to 100, '-'),
    (101 to 125, '='),
    (126 to 150, '+'),
    (151 to 175, '*'),
    (176 to 200, '#'),
    (201 to 225, '%'),
    (226 to 255, '@')
  )

  private def matchPattern(value: Int): Char = {
    patterns.find { case (range, _) => range.contains(value) }.map(_._2).getOrElse(' ')
  }

  override def convert(image: RGBImage): Either[String, AsciiImage] = {
    try {
      val asciiGrid = PixelGrid[AsciiPixel](image.height, image.width)

      for (y <- 0 until image.height; x <- 0 until image.width) {
        val pixel = image.getPixel(y, x)
        val grayscale = (0.3 * pixel.red + 0.59 * pixel.green + 0.11 * pixel.blue).toInt
        asciiGrid.setPixel(y, x, AsciiPixel(matchPattern(grayscale)))
      }

      Right(AsciiImage(asciiGrid))
    }
    catch {
      case e: Exception => Left(e.getMessage)
    }
  }
}