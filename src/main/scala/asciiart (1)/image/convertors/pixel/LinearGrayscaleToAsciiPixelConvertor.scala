package asciiart.image.convertors.pixel

import asciiart.image.models.pixel.{AsciiPixel, RGBPixel}

class LinearGrayscaleToAsciiPixelConvertor(val conversionTable: String) extends PixelConvertor[RGBPixel, AsciiPixel] {
  require(conversionTable.nonEmpty, "Conversion table must not be empty")

  def convert(pixel: RGBPixel): Either[String, AsciiPixel] = {
    val index = ((pixel.grayScaleValue.toDouble / 255) * (conversionTable.length - 1)).toInt
    Right(AsciiPixel(conversionTable.charAt(index)))
  }

}
