package asciiart.image.exporters

import asciiart.image.models.image.AsciiImage


/**
 * Trait for all file system image exporters
 */
trait FileSystemImageExporter extends ImageExporter[AsciiImage] {

  val path: String

  /**
   * Validates the file extension
   * @param path to the file
   * @return true if the file extension is valid, false otherwise
   */
  def validateFileExtension(path: String): Boolean

}
