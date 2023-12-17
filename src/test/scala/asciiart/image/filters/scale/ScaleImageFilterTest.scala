package asciiart.image.filters.scale

import asciiart.image.models.grid.PixelGrid
import asciiart.image.models.image.RGBImage
import asciiart.image.models.pixel.RGBPixel
import org.scalatest.FunSuite

class ScaleImageFilterTest extends FunSuite {

  test("ScaleFilter 0.25 should work correctly") {
    val pixelGrid = new PixelGrid[RGBPixel](2, 2)
    pixelGrid.setPixel(0, 0, RGBPixel(1, 2, 3))
    pixelGrid.setPixel(0, 1, RGBPixel(4, 5, 6))
    pixelGrid.setPixel(1, 0, RGBPixel(7, 8, 9))
    pixelGrid.setPixel(1, 1, RGBPixel(10, 11, 12))
    val image = RGBImage(pixelGrid)

    val result = ScaleImageFilter(0.25.toFloat).apply(image)

    assert(result.isRight)
    val newImage = result.right.get
    assert(newImage.width === 1)
    assert(newImage.height === 1)

    assert(newImage.getPixel(0, 0) === RGBPixel(1, 2, 3))
  }

  test("ScaleFilter 1 should work correctly") {
    val pixelGrid = new PixelGrid[RGBPixel](2, 2)
    pixelGrid.setPixel(0, 0, RGBPixel(1, 2, 3))
    pixelGrid.setPixel(0, 1, RGBPixel(4, 5, 6))
    pixelGrid.setPixel(1, 0, RGBPixel(7, 8, 9))
    pixelGrid.setPixel(1, 1, RGBPixel(10, 11, 12))
    val image = RGBImage(pixelGrid)

    val result = ScaleImageFilter(1.toFloat).apply(image)

    assert(result.isRight)
    val newImage = result.right.get

    assert(newImage === image)

  }

  test("ScaleFilter 4 should work correctly") {
    val pixelGrid = new PixelGrid[RGBPixel](2, 2)
    pixelGrid.setPixel(0, 0, RGBPixel(1, 2, 3))
    pixelGrid.setPixel(0, 1, RGBPixel(4, 5, 6))
    pixelGrid.setPixel(1, 0, RGBPixel(7, 8, 9))
    pixelGrid.setPixel(1, 1, RGBPixel(10, 11, 12))
    val image = RGBImage(pixelGrid)

    val result = ScaleImageFilter(4.toFloat).apply(image)

    assert(result.isRight)
    val newImage = result.right.get
    assert(newImage.width === 4)
    assert(newImage.height === 4)

    assert(newImage.getPixel(0, 0) === RGBPixel(1, 2, 3))
    assert(newImage.getPixel(0, 1) === RGBPixel(1, 2, 3))
    assert(newImage.getPixel(0, 2) === RGBPixel(4, 5, 6))
    assert(newImage.getPixel(0, 3) === RGBPixel(4, 5, 6))

    assert(newImage.getPixel(1, 0) === RGBPixel(1, 2, 3))
    assert(newImage.getPixel(1, 1) === RGBPixel(1, 2, 3))
    assert(newImage.getPixel(1, 2) === RGBPixel(4, 5, 6))
    assert(newImage.getPixel(1, 3) === RGBPixel(4, 5, 6))

    assert(newImage.getPixel(2, 0) === RGBPixel(7, 8, 9))
    assert(newImage.getPixel(2, 1) === RGBPixel(7, 8, 9))
    assert(newImage.getPixel(2, 2) === RGBPixel(10, 11, 12))
    assert(newImage.getPixel(2, 3) === RGBPixel(10, 11, 12))

    assert(newImage.getPixel(3, 0) === RGBPixel(7, 8, 9))
    assert(newImage.getPixel(3, 1) === RGBPixel(7, 8, 9))
    assert(newImage.getPixel(3, 2) === RGBPixel(10, 11, 12))
    assert(newImage.getPixel(3, 3) === RGBPixel(10, 11, 12))
  }

  test("ScaleFilter with invalid argument returns error") {
    val pixelGrid = new PixelGrid[RGBPixel](2, 2)
    pixelGrid.setPixel(0, 0, RGBPixel(1, 2, 3))
    pixelGrid.setPixel(0, 1, RGBPixel(4, 5, 6))
    pixelGrid.setPixel(1, 0, RGBPixel(7, 8, 9))
    pixelGrid.setPixel(1, 1, RGBPixel(10, 11, 12))
    val image = RGBImage(pixelGrid)

    val result = ScaleImageFilter(2.toFloat).apply(image)

    assert(result.isLeft)
    assert(result.left.get === "Scale must be one of 0.25, 1, 4")
  }

}
