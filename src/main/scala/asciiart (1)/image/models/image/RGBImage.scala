package asciiart.image.models.image

import asciiart.image.models.grid.PixelGrid
import asciiart.image.models.pixel.{Pixel, RGBPixel}

case class RGBImage(private val pixelGrid: PixelGrid[RGBPixel]) extends Image {

  val width: Int = pixelGrid.width
  val height: Int = pixelGrid.height

  override def getPixel(y: Int, x: Int): RGBPixel = {
    pixelGrid.getPixel(y, x)
  }

}
