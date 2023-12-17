package asciiart.image.exporters

import asciiart.image.models.image.{AsciiImage, Image}

import scala.util.Success

/**
 * Trait for all image exporters
 * @tparam A must be subclass of Image. This is the image to be exported.
 */
trait ImageExporter[A <: Image] {

  /**
   * Exports an image
   *
   * @param image to be exported
   * @return the exported image if successful, error message otherwise
   */
  def exportImage(image: A): Either[String, Unit]
}
