package asciiart.image.exporters


case class BMPImageExporter(override val filePath: String) extends RGBImageExporter(filePath, "bmp") { }
