package asciiart.image.models.image

import asciiart.image.models.grid.PixelGrid
import asciiart.image.models.pixel.{AsciiPixel, Pixel}

case class AsciiImage(private val pixelGrid: PixelGrid[AsciiPixel]) extends Image {

  val width: Int = pixelGrid.width
  val height: Int = pixelGrid.height

  override def getPixel(y: Int, x: Int): AsciiPixel = {
    pixelGrid.getPixel(y, x)
  }

  override def toString(): String = {
    val sb: StringBuilder = new StringBuilder

    for (y <- 0 until height) {
      for (x <- 0 until width) {
        val asciiValue = getPixel(y, x).value
        sb.append(asciiValue)
      }
      sb.append("\n")
    }

    sb.toString()
  }
}
