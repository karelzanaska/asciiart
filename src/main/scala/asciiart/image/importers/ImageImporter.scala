package asciiart.image.importers

import asciiart.image.models.image.{AsciiImage, Image, RGBImage}

/**
 * All image importers inherit this trait
 * @tparam A must be subclass of Image. This is the image to be imported.
 */
trait ImageImporter[A <: Image] {

  /**
   * Exports an image
   *
   * @param image to be imported
   * @return the imported image if successful, error message otherwise
   */
  def importImage(): Either[String, A]

}
