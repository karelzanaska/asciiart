package asciiart.image.importers

import asciiart.image.models.grid.PixelGrid
import asciiart.image.models.image
import asciiart.image.models.image.{AsciiImage, RGBImage}
import asciiart.image.models.pixel.{AsciiPixel, RGBPixel}

import scala.util.Random

case class RandomImageGeneratorImporter() extends ImageImporter[RGBImage] {

  override def importImage(): Either[String, RGBImage] = {
    val random = new Random()

    val pixelGrid: PixelGrid[RGBPixel] = ((height: Int, width: Int) => PixelGrid[RGBPixel](height, width))(random.nextInt(100), random.nextInt(100))

    val width = pixelGrid.width
    val height = pixelGrid.height

    for (x <- 0 until height)
      for (y <- 0 until width)
        pixelGrid.setPixel(x, y, RGBPixel(random.nextInt(255), random.nextInt(255), random.nextInt(255)))

    Right(image.RGBImage(pixelGrid))
  }

}
