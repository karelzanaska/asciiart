package asciiart.image.convertors.image

import asciiart.image.models.image.{AsciiImage, Image, RGBImage}

/**
 * Trait for all image convertors
 * @tparam A class must be subclass of Image. This is the input image.
 * @tparam B class must be subclass of Image. This is the output image.
 */
trait ImageConverter[A <: Image, B <: Image] {

  /**
   * Converts an image
   *
   * @param image to be converted
   * @return the converted image if successful, error message otherwise
   */
  def convert(image: A): Either[String, B]

}
