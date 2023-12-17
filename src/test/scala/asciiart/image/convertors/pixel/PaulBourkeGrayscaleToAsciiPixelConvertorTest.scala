package asciiart.image.convertors.pixel

import asciiart.image.models.pixel.RGBPixel
import org.scalatest.FunSuite

class PaulBourkeGrayscaleToAsciiPixelConvertorTest extends FunSuite {

  test("convert should correctly convert RGBPixel to AsciiPixel") {
    val pixel = RGBPixel(255, 255, 255)
    val result = PaulBourkeGrayscaleToAsciiPixelConvertor().convert(pixel)

    assert(result.isRight)
    val asciiPixel = result.right.get

    assert(asciiPixel.toString === " ")
  }
}
