package asciiart.image.importers

case class GIFImageImporter(override val path: String) extends FileSystemImageImporter(path, "gif") { }
