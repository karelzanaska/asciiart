package asciiart.image.filters.flip

import asciiart.image.filters.ImageFilter
import asciiart.image.models
import asciiart.image.models.grid.PixelGrid
import asciiart.image.models.image.{AsciiImage, RGBImage}
import asciiart.image.models.pixel.RGBPixel

case class FlipImageFilter(flipValue: Char) extends ImageFilter[RGBImage] {

  require(flipValue == 'x' || flipValue == 'y', "Flip value must be either 'x' or 'y'")

  override def apply(image: RGBImage): Either[String, RGBImage] = {
    flipValue match {
      case 'x' => flipHorizontal(image)
      case 'y' => flipVertical(image)
      case _ => Left("Flip value must be one of 'x' or 'y'") // Should never happen, but just in case
    }
  }

  private def flipHorizontal(image: RGBImage): Either[String, RGBImage] = {
    val width = image.width
    val height = image.height
    val pixelGrid = new PixelGrid[RGBPixel](height, width)

    for (y <- 0 until height) {
      for (x <- 0 until width) {
        pixelGrid.setPixel(y, x, image.getPixel(height - y - 1, x))
      }
    }

    Right(models.image.RGBImage(pixelGrid))
  }

  private def flipVertical(image: RGBImage): Either[String, RGBImage] = {
    val width = image.width
    val height = image.height
    val pixelGrid = new PixelGrid[RGBPixel](height, width)

    for (y <- 0 until height) {
      for (x <- 0 until width) {
        pixelGrid.setPixel(y, x, image.getPixel(y, width - x - 1))
      }
    }

    Right(models.image.RGBImage(pixelGrid))
  }
}
