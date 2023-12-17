package asciiart.image.filters.flip

import asciiart.image.models.grid.PixelGrid
import asciiart.image.models.image.RGBImage
import asciiart.image.models.pixel.RGBPixel
import org.scalatest.FunSuite

class FlipImageFilterTest extends FunSuite {

  test("FlipFilter should flip image vertically when flipValue is y") {
    val flipValue = 'y'
    val flipFilter = FlipImageFilter(flipValue)

    val pixelGrid = new PixelGrid[RGBPixel](3, 2)
    pixelGrid.setPixel(0, 0, RGBPixel(0, 0, 0))
    pixelGrid.setPixel(0, 1, RGBPixel(1, 1, 1))
    pixelGrid.setPixel(1, 0, RGBPixel(2, 2, 2))
    pixelGrid.setPixel(1, 1, RGBPixel(3, 3, 3))
    pixelGrid.setPixel(2, 0, RGBPixel(4, 4, 4))
    pixelGrid.setPixel(2, 1, RGBPixel(5, 5, 5))

    val image = RGBImage(pixelGrid)

    val result = flipFilter.apply(image)

    assert(result.isRight)

    val newImage = result.right.get

    assert(newImage.width == 2)
    assert(newImage.height == 3)

    assert(newImage.getPixel(0, 0) == RGBPixel(1, 1, 1))
    assert(newImage.getPixel(0, 1) == RGBPixel(0, 0, 0))
    assert(newImage.getPixel(1, 0) == RGBPixel(3, 3, 3))
    assert(newImage.getPixel(1, 1) == RGBPixel(2, 2, 2))
    assert(newImage.getPixel(2, 0) == RGBPixel(5, 5, 5))
    assert(newImage.getPixel(2, 1) == RGBPixel(4, 4, 4))

  }

  test("FlipFilter should flip image horizontally when flipValue is x") {
    val flipValue = 'x'
    val flipFilter = FlipImageFilter(flipValue)

    val pixelGrid = new PixelGrid[RGBPixel](3, 2)
    pixelGrid.setPixel(0, 0, RGBPixel(0, 0, 0))
    pixelGrid.setPixel(0, 1, RGBPixel(1, 1, 1))
    pixelGrid.setPixel(1, 0, RGBPixel(2, 2, 2))
    pixelGrid.setPixel(1, 1, RGBPixel(3, 3, 3))
    pixelGrid.setPixel(2, 0, RGBPixel(4, 4, 4))
    pixelGrid.setPixel(2, 1, RGBPixel(5, 5, 5))

    val image = RGBImage(pixelGrid)

    val result = flipFilter.apply(image)

    assert(result.isRight)

    val newImage = result.right.get

    assert(newImage.width == 2)
    assert(newImage.height == 3)

    assert(newImage.getPixel(0, 0) == RGBPixel(4, 4, 4))
    assert(newImage.getPixel(0, 1) == RGBPixel(5, 5, 5))
    assert(newImage.getPixel(1, 0) == RGBPixel(2, 2, 2))
    assert(newImage.getPixel(1, 1) == RGBPixel(3, 3, 3))
    assert(newImage.getPixel(2, 0) == RGBPixel(0, 0, 0))
    assert(newImage.getPixel(2, 1) == RGBPixel(1, 1, 1))
  }

}