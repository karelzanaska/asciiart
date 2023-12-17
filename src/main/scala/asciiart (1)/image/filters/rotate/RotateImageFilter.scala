package asciiart.image.filters.rotate

import asciiart.image.filters.ImageFilter
import asciiart.image.models
import asciiart.image.models.grid.PixelGrid
import asciiart.image.models.image.{AsciiImage, RGBImage}
import asciiart.image.models.pixel.RGBPixel

import scala.math.floorMod

case class RotateImageFilter(private val _degrees: Int) extends ImageFilter[RGBImage] {

  val degrees: Int = {
    val d = floorMod(_degrees, 360)
    if (d < 0) d + 360 else d
  }

  override def apply(image: RGBImage): Either[String, RGBImage] = {
    if (floorMod(degrees, 90) != 0) {
      Left("Degrees must be a multiple of 90")
    }
    else {
      val rotatedImage: Either[String, RGBImage] = degrees match {
        case 0 => Right(image)
        case 90 => rotate90(image)
        case 180 => rotate180(image)
        case 270 => rotate270(image)
        case _ => Left("Invalid degrees")
      }

      rotatedImage
    }
  }

  private def rotate90(image: RGBImage): Either[String, RGBImage] = {
    // swap width and height
    val width = image.height
    val height = image.width
    val pixelGrid = new PixelGrid[RGBPixel](height, width)

    for (y <- 0 until height) {
      for (x <- 0 until width) {
        pixelGrid.setPixel(y, x, image.getPixel(width - x - 1, y))
      }
    }

    Right(models.image.RGBImage(pixelGrid))
  }

  private def rotate180(image: RGBImage): Either[String, RGBImage] = {
    val width = image.width
    val height = image.height
    val pixelGrid = new PixelGrid[RGBPixel](height, width)

    for (y <- 0 until height) {
      for (x <- 0 until width) {
        pixelGrid.setPixel(y, x, image.getPixel(height - y - 1, width - x - 1))
      }
    }

    Right(models.image.RGBImage(pixelGrid))
  }

  private def rotate270(image: RGBImage): Either[String, RGBImage] = {
    // swap width and height
    val width = image.height
    val height = image.width
    val pixelGrid = new PixelGrid[RGBPixel](height, width)

    for (y <- 0 until height) {
      for (x <- 0 until width) {
        pixelGrid.setPixel(y, x, image.getPixel(y, height - y - 1))
      }
    }

    Right(models.image.RGBImage(pixelGrid))
  }

}
