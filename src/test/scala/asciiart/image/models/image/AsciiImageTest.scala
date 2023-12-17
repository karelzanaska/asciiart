package asciiart.image.models.image

import asciiart.image.models.grid.PixelGrid
import asciiart.image.models.pixel.AsciiPixel
import org.scalatest.FunSuite

class AsciiImageTest extends FunSuite {

  test("AsciiImage should have correct width and height") {
    val pixelGrid = PixelGrid[AsciiPixel](2, 2)
    pixelGrid.setPixel(0, 0, AsciiPixel('a'))
    pixelGrid.setPixel(0, 1, AsciiPixel('b'))
    pixelGrid.setPixel(1, 0, AsciiPixel('c'))
    pixelGrid.setPixel(1, 1, AsciiPixel('d'))

    val image = AsciiImage(pixelGrid)
    assert(image.width == 2)
    assert(image.height == 2)
  }

  test("AsciiImage should return correct pixel") {
    val pixelGrid = PixelGrid[AsciiPixel](2, 2)
    pixelGrid.setPixel(0, 0, AsciiPixel('a'))
    pixelGrid.setPixel(0, 1, AsciiPixel('b'))
    pixelGrid.setPixel(1, 0, AsciiPixel('c'))
    pixelGrid.setPixel(1, 1, AsciiPixel('d'))

    val image = AsciiImage(pixelGrid)

    assert(image.getPixel(0, 0) == AsciiPixel('a'))
    assert(image.getPixel(0, 1) == AsciiPixel('b'))
    assert(image.getPixel(1, 0) == AsciiPixel('c'))
    assert(image.getPixel(1, 1) == AsciiPixel('d'))
  }

  test("AsciiImage should return correct string") {
    val pixelGrid = PixelGrid[AsciiPixel](2, 2)
    pixelGrid.setPixel(0, 0, AsciiPixel('a'))
    pixelGrid.setPixel(0, 1, AsciiPixel('b'))
    pixelGrid.setPixel(1, 0, AsciiPixel('c'))
    pixelGrid.setPixel(1, 1, AsciiPixel('d'))

    val image = AsciiImage(pixelGrid)
    val string = image.toString

    assert(string == "ab\ncd\n")
  }

}
