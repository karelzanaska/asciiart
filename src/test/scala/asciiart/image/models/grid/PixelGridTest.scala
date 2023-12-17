package asciiart.image.models.grid

import org.scalatest.FunSuite

class PixelGridTest extends FunSuite {

  test("setPixel and getPixel should work correctly") {
    val pixelGrid = PixelGrid[Int](10, 10)
    pixelGrid.setPixel(5, 5, 42)
    assert(pixelGrid.getPixel(5, 5) == 42)
  }

  test("setPixel should throw exception if indexes are out of range") {
    val pixelGrid = PixelGrid[Int](10, 10)
    intercept[IndexOutOfBoundsException] {
      pixelGrid.setPixel(-1, 5, 42)
    }
    intercept[IndexOutOfBoundsException] {
      pixelGrid.setPixel(5, -1, 42)
    }
    intercept[IndexOutOfBoundsException] {
      pixelGrid.setPixel(11, 5, 42)
    }
    intercept[IndexOutOfBoundsException] {
      pixelGrid.setPixel(5, 11, 42)
    }
  }

  test("getPixel should throw exception if indexes are out of range") {
    val pixelGrid = PixelGrid[Int](10, 10)
    intercept[IndexOutOfBoundsException] {
      pixelGrid.getPixel(-1, 5)
    }
    intercept[IndexOutOfBoundsException] {
      pixelGrid.getPixel(5, -1)
    }
    intercept[IndexOutOfBoundsException] {
      pixelGrid.getPixel(11, 5)
    }
    intercept[IndexOutOfBoundsException] {
      pixelGrid.getPixel(5, 11)
    }
  }
}
