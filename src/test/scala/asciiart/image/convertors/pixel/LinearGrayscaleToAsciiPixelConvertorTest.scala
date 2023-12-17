package asciiart.image.convertors.pixel

import asciiart.image.models.pixel.{AsciiPixel, RGBPixel}
import org.scalatest.FunSuite

class LinearGrayscaleToAsciiPixelConvertorTest extends FunSuite {

  test("convert should correctly convert RGBPixel to AsciiPixel") {
    val convertor = new LinearGrayscaleToAsciiPixelConvertor("@B%8WM#*oahkbdpwmqwzZO0QO")

    val pixel = RGBPixel(0, 0, 0)
    pixel.setGrayScaleValue(128)

    val expectedAsciiPixel = AsciiPixel('b')

    val result = convertor.convert(pixel)

    assert(result == Right(expectedAsciiPixel))
  }

  test("convert should throw exception when conversion table is empty") {
    assertThrows[IllegalArgumentException] {
      new LinearGrayscaleToAsciiPixelConvertor("")
    }
  }
}
