package asciiart.image.convertors.image

import asciiart.image.convertors.pixel.PixelConvertor
import asciiart.image.models.grid.PixelGrid
import asciiart.image.models.image.{AsciiImage, RGBImage}
import asciiart.image.models.pixel.{AsciiPixel, RGBPixel}

case class GrayscaleToAsciiImageConverter(pixelConvertor: PixelConvertor[RGBPixel, AsciiPixel]) extends ImageConverter[RGBImage, AsciiImage] {

  /**
   * Converts an RGB image to ASCII
   *
   * @param image
   * @return the converted image if successful, error message otherwise
   */
  override def convert(image: RGBImage): Either[String, AsciiImage] = {
    val pixelGrid = new PixelGrid[AsciiPixel](image.height, image.width)
      for (x <- 0 until image.width) {
        for (y <- 0 until image.height) {
          val pixel = image.getPixel(y, x)
          val newPixel = pixelConvertor.convert(pixel)
          newPixel.fold(
            error => return Left(error),
            pixel => pixelGrid.setPixel(y, x, pixel)
          )
        }
      }

    Right(AsciiImage(pixelGrid))
  }

}
