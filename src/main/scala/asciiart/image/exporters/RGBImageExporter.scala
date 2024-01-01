package asciiart.image.exporters

import asciiart.image.models.image.RGBImage

import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO


//trait RGBImageExporter(override filePath: String, exportFormat: String) extends ImageExporter[RGBImage] {
//
//  override def exportImage(image: RGBImage): Either[String, Unit] = {
//    try {
//      val bufferedImage = new BufferedImage(image.width, image.height, BufferedImage.TYPE_INT_RGB)
//
//      for (y <- 0 until image.height; x <- 0 until image.width) {
//        val pixel = image.getPixel(y, x)
//        val color = new java.awt.Color(pixel.red, pixel.green, pixel.blue)
//        bufferedImage.setRGB(x, y, color.getRGB)
//      }
//
//      val outputFile = new File(filePath)
//      ImageIO.write(bufferedImage, exportFormat, outputFile)
//      Right(())
//    } catch {
//      case e: Exception => Left(e.getMessage)
//    }
//  }
//}
//


//class RGBImageExporter[A <: AsciiImage](val filePath: String, val exportFormat: String) extends ImageExporter[A] {

class RGBImageExporter(val filePath: String, val exportFormat: String) extends ImageExporter[RGBImage] {

  override def exportImage(image: RGBImage): Either[String, Unit] = {
    try {
      val bufferedImage = new BufferedImage(image.width, image.height, BufferedImage.TYPE_INT_RGB)

      for (y <- 0 until image.height; x <- 0 until image.width) {
        val pixel = image.getPixel(y, x)
        val color = new java.awt.Color(pixel.red, pixel.green, pixel.blue)
        bufferedImage.setRGB(x, y, color.getRGB)
      }

      val outputFile = new File(filePath)
      ImageIO.write(bufferedImage, exportFormat, outputFile)
      Right(())
    } catch {
      case e: Exception => Left(e.getMessage)
    }
  }

}
