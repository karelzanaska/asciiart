package asciiart.image.filters.invert

import asciiart.image.filters.ImageFilter
import asciiart.image.models.grid.PixelGrid
import asciiart.image.models.image
import asciiart.image.models.image.{AsciiImage, RGBImage}
import asciiart.image.models.pixel.RGBPixel

case class InvertImageFilter() extends ImageFilter[RGBImage] {
  /**
   * Applies the filter to the image
   *  @param image
   *  @return
   */
  override def apply(image: RGBImage): Either[String, RGBImage] = {
    val width = image.width
    val height = image.height
    val pixelGrid = new PixelGrid[RGBPixel](height, width)

    for (y <- 0 until height) {
      for (x <- 0 until width) {
        val pixel = image.getPixel(y, x)
        val newPixel = RGBPixel(pixel.red, pixel.green, pixel.blue)
        newPixel.setGrayScaleValue(255 - newPixel.grayScaleValue)
        pixelGrid.setPixel(y, x, newPixel)
      }
    }

    Right(RGBImage(pixelGrid))
  }
}
