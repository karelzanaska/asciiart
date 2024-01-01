package asciiart.image.importers

case class JPGImageImporter(override val path: String) extends FileSystemImageImporter(path, "jpg") { }
