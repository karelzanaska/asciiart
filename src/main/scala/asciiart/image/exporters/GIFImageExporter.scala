package asciiart.image.exporters


case class GIFImageExporter(override val filePath: String) extends RGBImageExporter(filePath, "gif") { }
