package asciiart.image.convertors.pixel

import asciiart.image.models.pixel.{AsciiPixel, RGBPixel}
import org.scalatest.FunSuite

class NonLinearGrayscaleToAsciiPixelConvertorTest extends FunSuite {

  test("convert should correctly convert RGBPixel to AsciiPixel when grayscale value is less than 150") {
    val pixel = RGBPixel(100, 100, 100)
    val result = NonLinearGrayscaleToAsciiPixelConvertor().convert(pixel)
    assert(result === Right(AsciiPixel('z')))
  }

  test("convert should correctly convert RGBPixel to AsciiPixel when grayscale value is greater than or equal 150") {
    val pixel = RGBPixel(200, 200, 200)
    val result = NonLinearGrayscaleToAsciiPixelConvertor().convert(pixel)
    assert(result === Right(AsciiPixel('I')))
  }

}
