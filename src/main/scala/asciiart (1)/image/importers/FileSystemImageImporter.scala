package asciiart.image.importers

import asciiart.image.models.grid.PixelGrid
import asciiart.image.models.image.{AsciiImage, RGBImage}
import asciiart.image.models.pixel.RGBPixel

import java.awt.Color
import java.io.File
import javax.imageio.ImageIO


case class FileSystemImageImporter(val path: String) extends ImageImporter[RGBImage] {
  /**
   * Imports an image from a file
   *  @return
   */
  override def importImage: Either[String, RGBImage] = {
    try {
      val image = ImageIO.read(new File(path))
      if (image == null) {
        return Left("Unable to load image with provided path: '" + path + "'")
      }

      val width = image.getWidth
      val height = image.getHeight
      val pixelGrid = ((height: Int, width: Int) => PixelGrid[RGBPixel](height, width))(height, width)
      for (x <- 0 until width) {
        for (y <- 0 until height) {
          val rgba = image.getRGB(x, y)
          val color: Color = new Color(rgba, true)
          pixelGrid.setPixel(y, x, RGBPixel(color.getRed, color.getGreen, color.getBlue))
        }
      }
      return Right(RGBImage(pixelGrid))
    } catch {
      case e: Exception => return Left("Unable to load image with provided path: '" + path + "'")
    }
    Left("Unable to load image with provided path: '" + path + "'")
  }

}
