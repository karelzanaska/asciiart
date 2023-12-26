package asciiart.image.importers

import asciiart.image.models.image.RGBImage
import asciiart.image.models.grid.PixelGrid
import asciiart.image.models.image
import asciiart.image.models.image.{AsciiImage, RGBImage}
import asciiart.image.models.pixel.{AsciiPixel, RGBPixel}

import scala.util.Random

case class GradientRandomImageGeneratorImporter() extends ImageImporter[RGBImage] {

  override def importImage(): Either[String, RGBImage] = {
    val random = new Random()

    // Randomly choose the gradient direction
    val isVertical = random.nextBoolean()

    // Define the start and end colors for the gradient
    val startColor = RGBPixel(random.nextInt(255), random.nextInt(255), random.nextInt(255))
    val endColor = RGBPixel(random.nextInt(255), random.nextInt(255), random.nextInt(255))

    val width = random.nextInt(50) + 50 // Width between 50 and 100
    val height = random.nextInt(50) + 50 // Height between 50 and 100

    val pixelGrid: PixelGrid[RGBPixel] = PixelGrid[RGBPixel](height, width)

    for (x <- 0 until height; y <- 0 until width) {
      val ratio = if (isVertical) x.toDouble / height else y.toDouble / width
      val red = (startColor.red * (1 - ratio) + endColor.red * ratio).toInt
      val green = (startColor.green * (1 - ratio) + endColor.green * ratio).toInt
      val blue = (startColor.blue * (1 - ratio) + endColor.blue * ratio).toInt

      pixelGrid.setPixel(x, y, RGBPixel(red, green, blue))
    }

    Right(RGBImage(pixelGrid))
  }
}
