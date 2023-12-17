package asciiart.image.models.grid

import asciiart.image.models.pixel.Pixel
import scala.reflect.ClassTag


case class PixelGrid[A:ClassTag](height: Int, width: Int) {
  private val pixels = Array.ofDim[A](height, width)

  def setPixel(y: Int, x: Int, pixel: A): Unit = {
    if (y < 0 || y >= height || x < 0 || x >= width) {
      throw new IndexOutOfBoundsException(s"PixelGrid: ($y, $x) is out of bounds")
    }
    pixels(y)(x) = pixel
  }

  def getPixel(y: Int, x: Int): A = {
    if (y < 0 || y >= height || x < 0 || x >= width) {
      throw new IndexOutOfBoundsException(s"PixelGrid: ($y, $x) is out of bounds")
    }
    pixels(y)(x)
  }
}
