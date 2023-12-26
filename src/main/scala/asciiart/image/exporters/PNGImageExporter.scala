package asciiart.image.exporters

import asciiart.image.models.image.RGBImage


case class PNGImageExporter(override val filePath: String) extends RGBImageExporter(filePath, "png") { }
