package asciiart.image.filters

import asciiart.image.models.image.Image


/**
 * Trait for all image filters
 * @tparam A must be subclass of Image. This is the image to be filtered.
 */
trait ImageFilter[A <: Image] {

  /**
   * Filters an image
   *
   * @param image to be filtered
   * @return the filtered image if successful, error message otherwise
   */
  def apply(image: A): Either[String, A]

}
