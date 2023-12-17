package asciiart.image.convertors.pixel

import asciiart.image.models.pixel.{AsciiPixel, Pixel, RGBPixel}

/**
 * Trait for all pixel convertors
 * @tparam A must be subclass of Pixel. This is the input pixel.
 * @tparam B must be subclass of Pixel. This is the output pixel.
 */
trait PixelConvertor[A <: Pixel, B <: Pixel] {

    /**
    * Converts a pixel
    *
    * @param pixel to be converted
    * @return the converted pixel if successful, error message otherwise
    */
    def convert(pixel: A): Either[String, B]

}
