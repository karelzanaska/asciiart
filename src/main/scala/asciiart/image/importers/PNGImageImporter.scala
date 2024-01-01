package asciiart.image.importers

case class PNGImageImporter(override val path: String) extends FileSystemImageImporter(path, "png") { }
