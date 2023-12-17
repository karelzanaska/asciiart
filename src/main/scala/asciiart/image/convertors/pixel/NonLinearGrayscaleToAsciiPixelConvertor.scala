package asciiart.image.convertors.pixel

import asciiart.image.models.pixel.{AsciiPixel, RGBPixel}

case class NonLinearGrayscaleToAsciiPixelConvertor() extends PixelConvertor[RGBPixel, AsciiPixel] {

  val conversionTable= "zcvunxrjft/\\|()1{}[]?-_+~<>i!lI;:,\"^`'. "

  def convert(pixel: RGBPixel): Either[String, AsciiPixel] = {
    val grayScaleValue = pixel.grayScaleValue
    if (grayScaleValue < 150) {
        Right(AsciiPixel(conversionTable.charAt(0)))
    }
    else {
      val index = ((grayScaleValue.toDouble / 255) * (conversionTable.length - 1)).toInt
      Right(AsciiPixel(conversionTable.charAt(index)))
    }
  }

}
