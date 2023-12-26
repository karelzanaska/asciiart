package asciiart.controllers

import asciiart.image.convertors.image.ImageConverter
import asciiart.image.exporters.ImageExporter
import asciiart.image.filters.ImageFilter
import asciiart.image.importers.ImageImporter
import asciiart.image.models.image.{AsciiImage, Image, RGBImage}


/**
 * Trait for handling the application logic
 *
 * @tparam A must be subclass of Image. This is the input image.
 * @tparam B must be subclass of Image. This is the output image.
 */
trait Controller[A <: Image, B <: Image] {

  /**
   * Shows the help message
   */
  def showHelp(): Unit


  /**
   * Shows an error message
   *
   * @param message to be shown on stderr
   */
  def showErrorMessage(message: String): Unit


  /**
   * Imports an image
   *
   * @param imageImporter to use for importing the image
   * @return the imported image if successful, None otherwise
   */
  def importImage(imageImporter: ImageImporter[A]): Option[A]


  /**
   * Exports an image
   * @param image to be exported
   * @param imageExporter to use for exporting the image
   */
  def exportImage(image: B, imageExporter: ImageExporter[B]): Unit


  /**
   * Applies a filter to an image
   *
   * @param image to be filtered
   * @param imageFilter to use for filtering
   * @return Option containing the filtered image if successful, None otherwise
   */
  def applyFilter(image: A, filter: ImageFilter[A]): Option[A]


  /**
   * Applies a convertor to an image
   *
   * @param image to convert
   * @param convertor to use for conversion
   * @return Option containing the converted image if successful, None otherwise
   */
  def applyConvertor(image: A, imageConvertor: ImageConverter[A, B]): Option[B]

}
