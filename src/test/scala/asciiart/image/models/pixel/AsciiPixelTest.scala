package asciiart.image.models.pixel

import org.scalatest.FunSuite

class AsciiPixelTest extends FunSuite {

  test("AsciiPixel should have correct value") {
    val pixel = AsciiPixel('a')
    assert(pixel.value == 'a')
  }

  test("AsciiPixel should convert to correct string") {
    val pixel = AsciiPixel('a')
    assert(pixel.toString == "a")
  }

}
