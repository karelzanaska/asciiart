package asciiart.image.exporters

import asciiart.image.models.image.RGBImage

import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO


case class JPGImageExporter(override val filePath: String) extends RGBImageExporter(filePath, "jpg") { }
