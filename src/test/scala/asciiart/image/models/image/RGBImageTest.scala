package asciiart.image.models.image

import asciiart.image.models.grid.PixelGrid
import asciiart.image.models.pixel.RGBPixel
import org.scalatest.FunSuite

class RGBImageTest extends FunSuite {

  test("RGBImage should have correct width and height") {
    val pixelGrid = PixelGrid[RGBPixel](2, 2)
    pixelGrid.setPixel(0, 0, RGBPixel(0, 0, 0))
    pixelGrid.setPixel(0, 1, RGBPixel(255, 255, 255))
    pixelGrid.setPixel(1, 0, RGBPixel(100, 100, 100))
    pixelGrid.setPixel(1, 1, RGBPixel(200, 200, 200))

    val image = RGBImage(pixelGrid)

    assert(image.width == 2)
    assert(image.height == 2)
  }

  test("RGBImage should return correct pixel") {
    val pixelGrid = PixelGrid[RGBPixel](2, 2)
    pixelGrid.setPixel(0, 0, RGBPixel(0, 0, 0))
    pixelGrid.setPixel(0, 1, RGBPixel(255, 255, 255))
    pixelGrid.setPixel(1, 0, RGBPixel(100, 100, 100))
    pixelGrid.setPixel(1, 1, RGBPixel(200, 200, 200))

    val image = RGBImage(pixelGrid)

    assert(image.getPixel(0, 0) == RGBPixel(0, 0, 0))
    assert(image.getPixel(0, 1) == RGBPixel(255, 255, 255))
    assert(image.getPixel(1, 0) == RGBPixel(100, 100, 100))
    assert(image.getPixel(1, 1) == RGBPixel(200, 200, 200))
  }

}
