package asciiart.image.filters.scale

import asciiart.image.filters.ImageFilter
import asciiart.image.models
import asciiart.image.models.grid.PixelGrid
import asciiart.image.models.image.{AsciiImage, RGBImage}
import asciiart.image.models.pixel.RGBPixel

case class ScaleImageFilter(val scale: Float) extends ImageFilter[RGBImage] {
//  val scale = {}

  /**
   * Applies the filter to the image
   *
   *  @param image
   *  @return
   */
  override def apply(image: RGBImage): Either[String, RGBImage] = {
    scale match {
      case 0.25 => scale025(image)
      case 1 => scale1(image)
      case 4 => scale4(image)
      case _ => Left("Scale must be one of 0.25, 1, 4")
    }
  }

  private def scale025(image: RGBImage): Either[String, RGBImage] = {
    val width = image.width
    val height = image.height
    val pixelGrid = new PixelGrid[RGBPixel](height / 2, width / 2)

    for (y <- 0 until height / 2) {
        for (x <- 0 until width / 2) {
            pixelGrid.setPixel(y, x, image.getPixel(y * 2, x * 2))
        }
    }

    Right(models.image.RGBImage(pixelGrid))
  }

  private def scale1(image: RGBImage): Either[String, RGBImage] = {
    Right(image)
  }

  private def scale4(image: RGBImage): Either[String, RGBImage] = {
    val width = image.width
    val height = image.height
    val pixelGrid = new PixelGrid[RGBPixel](height * 2, width * 2)

    for (y <- 0 until height) {
      for (x <- 0 until width) {
        pixelGrid.setPixel(y * 2, x * 2, image.getPixel(y, x))
        pixelGrid.setPixel(y * 2, x * 2 + 1, image.getPixel(y, x))
        pixelGrid.setPixel(y * 2 + 1, x * 2, image.getPixel(y, x))
        pixelGrid.setPixel(y * 2 + 1, x * 2 + 1, image.getPixel(y, x))
      }
    }

    Right(models.image.RGBImage(pixelGrid))
  }

}
