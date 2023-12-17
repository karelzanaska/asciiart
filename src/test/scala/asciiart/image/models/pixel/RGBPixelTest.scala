package asciiart.image.models.pixel

import org.scalatest.FunSuite

class RGBPixelTest extends FunSuite {

  test("RGBPixel should have correct RGB values") {
    val pixel = RGBPixel(255, 0, 0)
    assert(pixel.red === 255)
    assert(pixel.green === 0)
    assert(pixel.blue === 0)
  }

  test("RGBPixel should calculate correct grayscale value") {
    val pixel = RGBPixel(255, 255, 255)
    assert(pixel.grayScaleValue === 255)

    val pixel2 = RGBPixel(0, 0, 0)
    assert(pixel2.grayScaleValue === 0)
  }

  test("RGBPixel should throw exception for invalid red value") {
    intercept[IllegalArgumentException] {
      RGBPixel(-1, 0, 0)
    }
    intercept[IllegalArgumentException] {
      RGBPixel(256, 0, 0)
    }
  }

  test("RGBPixel should throw exception for invalid green value") {
    intercept[IllegalArgumentException] {
      RGBPixel(0, -1, 0)
    }
    intercept[IllegalArgumentException] {
      RGBPixel(0, 256, 0)
    }
  }

  test("RGBPixel should throw exception for invalid blue value") {
    intercept[IllegalArgumentException] {
      RGBPixel(0, 0, -1)
    }
    intercept[IllegalArgumentException] {
      RGBPixel(0, 0, 256)
    }
  }

  test("setGrayScaleValue should update grayscale value of RGBPixel") {
    val pixel = RGBPixel(255, 255, 255)
    pixel.setGrayScaleValue(100)
    assert(pixel.grayScaleValue === 100)
  }

  test("Grayscale value should in range 0-255") {
    val pixel = RGBPixel(100, 150, 200)
    assertThrows[IllegalArgumentException] {
      pixel.setGrayScaleValue(-1)
    }
    assertThrows[IllegalArgumentException] {
      pixel.setGrayScaleValue(256)
    }
  }

}
