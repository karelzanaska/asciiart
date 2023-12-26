package asciiart.image.importers

import asciiart.image.models.grid.PixelGrid
import asciiart.image.models.image.{AsciiImage, RGBImage}
import asciiart.image.models.pixel.RGBPixel

import java.awt.Color
import java.awt.image.BufferedImage
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
//      val finalImage = RGBImage(pixelGrid)
//      exportImageTmp(finalImage)
//      return Right(RGBImage(pixelGrid))
//      return Right(finalImage)
      return Right(RGBImage(pixelGrid))
    } catch {
      case e: Exception => return Left("Unable to load image with provided path: '" + path + "'")
    }
    Left("Unable to load image with provided path: '" + path + "'")
  }

//  def exportImageDebugging(image: RGBImage): Either[String, Unit] = {
//    try {
//      val bufferedImage = new BufferedImage(image.width, image.height, BufferedImage.TYPE_INT_RGB)
//
//      for (x <- 0 until image.height; y <- 0 until image.width) {
//        val pixel = image.pixelGrid.getPixel(x, y)
//        val color = new java.awt.Color(pixel.red, pixel.green, pixel.blue)
//        bufferedImage.setRGB(y, x, color.getRGB)
//      }
//
//      val outputFile = new File(filePath)
//      ImageIO.write(bufferedImage, "png", outputFile)
//      Right(())
//    } catch {
//      case e: Exception => Left(e.getMessage)
//    }
//  }
//
//  def exportImageTmp(image: RGBImage): Either[String, Unit] = {
//    try {
//      val bufferedImage = new BufferedImage(image.width, image.height, BufferedImage.TYPE_INT_RGB)
//
//      for (y <- 0 until image.height; x <- 0 until image.width) {
//        val pixel = image.getPixel(y, x)
//        val color = new java.awt.Color(pixel.red, pixel.green, pixel.blue)
//        bufferedImage.setRGB(x, y, color.getRGB)
//      }
//
//      val filePath = "tmp.png"
//
//      val outputFile = new File(filePath)
//      ImageIO.write(bufferedImage, "png", outputFile)
//      Right(())
//    } catch {
//      case e: Exception => Left(e.getMessage)
//    }
//  }

}
