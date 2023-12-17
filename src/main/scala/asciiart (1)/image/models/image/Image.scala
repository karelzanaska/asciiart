package asciiart.image.models.image

import asciiart.image.models.pixel.Pixel

/**
 * Trait representing an image
 */
trait Image {
  def width: Int

  def height: Int

  def getPixel(row: Int, column: Int): Pixel
}
