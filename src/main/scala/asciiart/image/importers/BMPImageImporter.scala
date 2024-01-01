package asciiart.image.importers

case class BMPImageImporter(override val path: String) extends FileSystemImageImporter(path, "bmp") { }
