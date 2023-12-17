package asciiart.image.filters.invert

import asciiart.image.models.grid.PixelGrid
import asciiart.image.models.image.RGBImage
import asciiart.image.models.pixel.RGBPixel
import org.scalatest.FunSuite

class InvertImageFilterTest extends FunSuite {
  test("InvertFilter with image with all white pixels should produce image with all black pixels") {
    val pixelGrid = new PixelGrid[RGBPixel](2, 2)
    pixelGrid.setPixel(0, 0, RGBPixel(255, 255, 255))
    pixelGrid.setPixel(0, 1, RGBPixel(255, 255, 255))
    pixelGrid.setPixel(1, 0, RGBPixel(255, 255, 255))
    pixelGrid.setPixel(1, 1, RGBPixel(255, 255, 255))
    val image = RGBImage(pixelGrid)

    val result = InvertImageFilter().apply(image)

    assert(result.isRight)

    val newImage = result.right.get
    assert(newImage.width == 2)
    assert(newImage.height == 2)

    for (y <- 0 until newImage.height) {
      for (x <- 0 until newImage.width) {
        assert(newImage.getPixel(y, x).grayScaleValue == 0)
      }
    }
  }

  test("InvertFilter with image with all black pixels should produce image with all white pixels") {
    val pixelGrid = new PixelGrid[RGBPixel](2, 2)
    pixelGrid.setPixel(0, 0, RGBPixel(0, 0, 0))
    pixelGrid.setPixel(0, 1, RGBPixel(0, 0, 0))
    pixelGrid.setPixel(1, 0, RGBPixel(0, 0, 0))
    pixelGrid.setPixel(1, 1, RGBPixel(0, 0, 0))
    val image = RGBImage(pixelGrid)

    val result = InvertImageFilter().apply(image)

    assert(result.isRight)

    val newImage = result.right.get
    assert(newImage.width == 2)
    assert(newImage.height == 2)

    for (y <- 0 until newImage.height) {
      for (x <- 0 until newImage.width) {
        assert(newImage.getPixel(y, x).grayScaleValue == 255)
      }
    }
  }

  test("InvertFilter with image with white and black pixels should produce image with opposite white and black pixels") {
    val pixelGrid = new PixelGrid[RGBPixel](2, 2)
    pixelGrid.setPixel(0, 0, RGBPixel(0, 0, 0))
    pixelGrid.setPixel(0, 1, RGBPixel(255, 255, 255))
    pixelGrid.setPixel(1, 0, RGBPixel(100, 100, 100))
    pixelGrid.setPixel(1, 1, RGBPixel(200, 200, 200))
    val image = RGBImage(pixelGrid)

    val result = InvertImageFilter().apply(image)

    assert(result.isRight)

    val newImage = result.right.get
    assert(newImage.width == 2)
    assert(newImage.height == 2)

    for (y <- 0 until newImage.height) {
      for (x <- 0 until newImage.width) {
          assert(newImage.getPixel(y, x).grayScaleValue == 255 - image.getPixel(y, x).grayScaleValue)
      }
    }
  }
}