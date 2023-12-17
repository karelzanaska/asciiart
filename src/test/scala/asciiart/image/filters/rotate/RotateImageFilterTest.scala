package asciiart.image.filters.rotate

import asciiart.image.models.grid.PixelGrid
import asciiart.image.models.image.RGBImage
import asciiart.image.models.pixel.RGBPixel
import org.scalatest.FunSuite

class RotateImageFilterTest extends FunSuite {

  test("RotateImageFilter should return error when degrees is not multiple of 90") {
    val pixelGrid = new PixelGrid[RGBPixel](2, 2)
    pixelGrid.setPixel(0, 0, RGBPixel(1, 2, 3))
    pixelGrid.setPixel(0, 1, RGBPixel(4, 5, 6))
    pixelGrid.setPixel(1, 0, RGBPixel(7, 8, 9))
    pixelGrid.setPixel(1, 1, RGBPixel(10, 11, 12))
    val image = RGBImage(pixelGrid)

    val result = RotateImageFilter(45).apply(image)

    assert(result.isLeft)
  }

  test("RotateImageFilter should return original image when degrees is 0") {
    val pixelGrid = new PixelGrid[RGBPixel](2, 2)
    pixelGrid.setPixel(0, 0, RGBPixel(1, 2, 3))
    pixelGrid.setPixel(0, 1, RGBPixel(4, 5, 6))
    pixelGrid.setPixel(1, 0, RGBPixel(7, 8, 9))
    pixelGrid.setPixel(1, 1, RGBPixel(10, 11, 12))
    val image = RGBImage(pixelGrid)

    val result = RotateImageFilter(0).apply(image)

    assert(result.isRight)

    val newImage = result.right.get
    assert(newImage === image)
  }

  test("RotateImageFilter should return image rotated by 90 degrees when degrees is 90") {
    val pixelGrid = new PixelGrid[RGBPixel](3, 2)
    pixelGrid.setPixel(0, 0, RGBPixel(1, 2, 3))
    pixelGrid.setPixel(0, 1, RGBPixel(4, 5, 6))
    pixelGrid.setPixel(1, 0, RGBPixel(7, 8, 9))
    pixelGrid.setPixel(1, 1, RGBPixel(10, 11, 12))
    pixelGrid.setPixel(2, 0, RGBPixel(13, 14, 15))
    pixelGrid.setPixel(2, 1, RGBPixel(16, 17, 18))
    val image = RGBImage(pixelGrid)

    val rotatedPixelGrid = new PixelGrid[RGBPixel](2, 3)
    rotatedPixelGrid.setPixel(0, 0, RGBPixel(4, 5, 6))
    rotatedPixelGrid.setPixel(0, 1, RGBPixel(10, 11, 12))
    rotatedPixelGrid.setPixel(0, 2, RGBPixel(16, 17, 18))
    rotatedPixelGrid.setPixel(1, 0, RGBPixel(1, 2, 3))
    rotatedPixelGrid.setPixel(1, 1, RGBPixel(7, 8, 9))
    rotatedPixelGrid.setPixel(1, 2, RGBPixel(13, 14, 15))
    val rotatedImage = RGBImage(rotatedPixelGrid)

    val result = RotateImageFilter(90).apply(image)
    assert(result.isRight)
    val newImage = result.right.get
    assert(newImage === rotatedImage)

    val result2 = RotateImageFilter(450).apply(image)
    assert(result2.isRight)
    val newImage2 = result2.right.get
    assert(newImage2 === rotatedImage)

    val result3 = RotateImageFilter(-270).apply(image)
    assert(result3.isRight)
    val newImage3 = result3.right.get
    assert(newImage3 === rotatedImage)

    val result4 = RotateImageFilter(+90).apply(image)
    assert(result4.isRight)
    val newImage4 = result4.right.get
    assert(newImage4 === rotatedImage)
  }

  test("RotateImageFilter should return image rotated by 180 degrees when degrees is 180") {
    val pixelGrid = new PixelGrid[RGBPixel](3, 2)
    pixelGrid.setPixel(0, 0, RGBPixel(1, 2, 3))
    pixelGrid.setPixel(0, 1, RGBPixel(4, 5, 6))
    pixelGrid.setPixel(1, 0, RGBPixel(7, 8, 9))
    pixelGrid.setPixel(1, 1, RGBPixel(10, 11, 12))
    pixelGrid.setPixel(2, 0, RGBPixel(13, 14, 15))
    pixelGrid.setPixel(2, 1, RGBPixel(16, 17, 18))
    val image = RGBImage(pixelGrid)

    val rotatedPixelGrid = new PixelGrid[RGBPixel](3, 2)
    rotatedPixelGrid.setPixel(0, 0, RGBPixel(16, 17, 18))
    rotatedPixelGrid.setPixel(0, 1, RGBPixel(13, 14, 15))
    rotatedPixelGrid.setPixel(1, 0, RGBPixel(10, 11, 12))
    rotatedPixelGrid.setPixel(1, 1, RGBPixel(7, 8, 9))
    rotatedPixelGrid.setPixel(2, 0, RGBPixel(4, 5, 6))
    rotatedPixelGrid.setPixel(2, 1, RGBPixel(1, 2, 3))
    val rotatedImage = RGBImage(rotatedPixelGrid)

    val result = RotateImageFilter(180).apply(image)
    assert(result.isRight)
    val newImage = result.right.get
    assert(newImage === rotatedImage)

    val result2 = RotateImageFilter(+180).apply(image)
    assert(result2.isRight)
    val newImage2 = result2.right.get
    assert(newImage2 === rotatedImage)

    val result3 = RotateImageFilter(-180).apply(image)
    assert(result3.isRight)
    val newImage3 = result3.right.get
    assert(newImage3 === rotatedImage)
  }

  test("RotateImageFilter should return Right with an image rotated by 270 degrees when degrees is 270") {

    val pixelGrid = new PixelGrid[RGBPixel](3, 2)
    pixelGrid.setPixel(0, 0, RGBPixel(1, 2, 3))
    pixelGrid.setPixel(0, 1, RGBPixel(4, 5, 6))
    pixelGrid.setPixel(1, 0, RGBPixel(7, 8, 9))
    pixelGrid.setPixel(1, 1, RGBPixel(10, 11, 12))
    pixelGrid.setPixel(2, 0, RGBPixel(13, 14, 15))
    pixelGrid.setPixel(2, 1, RGBPixel(16, 17, 18))
    val image = RGBImage(pixelGrid)

    val rotatedPixelGrid = new PixelGrid[RGBPixel](2, 3)
    rotatedPixelGrid.setPixel(0, 0, RGBPixel(13, 14, 15))
    rotatedPixelGrid.setPixel(0, 1, RGBPixel(7, 8, 9))
    rotatedPixelGrid.setPixel(0, 2, RGBPixel(1, 2, 3))
    rotatedPixelGrid.setPixel(1, 0, RGBPixel(16, 17, 18))
    rotatedPixelGrid.setPixel(1, 1, RGBPixel(10, 11, 12))
    rotatedPixelGrid.setPixel(1, 2, RGBPixel(4, 5, 6))
    val rotatedImage = RGBImage(rotatedPixelGrid)

    val result = RotateImageFilter(270).apply(image)
    assert(result.isRight)
    val newImage = result.right.get
    assert(newImage === rotatedImage)

    val result2 = RotateImageFilter(-90).apply(image)
    assert(result2.isRight)
    val newImage2 = result2.right.get
    assert(newImage2 === rotatedImage)

    val result3 = RotateImageFilter(630).apply(image)
    assert(result3.isRight)
    val newImage3 = result3.right.get
    assert(newImage3 === rotatedImage)

    val result4 = RotateImageFilter(+270).apply(image)
    assert(result4.isRight)
    val newImage4 = result4.right.get
    assert(newImage4 === rotatedImage)
  }

}
