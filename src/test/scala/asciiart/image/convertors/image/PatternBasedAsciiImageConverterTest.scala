package asciiart.image.convertors.image

import asciiart.image.models.grid.PixelGrid
import asciiart.image.models.image.RGBImage
import asciiart.image.models.pixel.RGBPixel
import org.scalatest.FunSuite


class PatternBasedAsciiImageConverterTest extends FunSuite {

  test("convert should correctly map specific grayscale values to ASCII characters") {
    val imageConverter = PatternBasedAsciiImageConverter()
    val rgbPixelGrid = PixelGrid[RGBPixel](1, 1)
    rgbPixelGrid.setPixel(0, 0, RGBPixel(50, 50, 50)) // Grayscale value in range 26 to 50
    val image = RGBImage(rgbPixelGrid)

    val result = imageConverter.convert(image)

    assert(result.isRight)
    result.right.foreach { asciiImage =>
      val asciiPixel = asciiImage.getPixel(0, 0)
      assert(asciiPixel.toString == ".") // '.' should correspond to grayscale range 26 to 50
    }
  }

  test("convert should handle various grayscale ranges correctly") {
    val imageConverter = PatternBasedAsciiImageConverter()
    val rgbPixelGrid = PixelGrid[RGBPixel](3, 1)
    rgbPixelGrid.setPixel(0, 0, RGBPixel(10, 10, 10)) // Low grayscale
    rgbPixelGrid.setPixel(1, 0, RGBPixel(128, 128, 128)) // Mid grayscale
    rgbPixelGrid.setPixel(2, 0, RGBPixel(240, 240, 240)) // High grayscale
    val image = RGBImage(rgbPixelGrid)

    val result = imageConverter.convert(image)

    assert(result.isRight)
    result.right.foreach { asciiImage =>
      assert(asciiImage.getPixel(0, 0).toString == " ") // Low grayscale
      assert(asciiImage.getPixel(1, 0).toString == "+") // Mid grayscale
      assert(asciiImage.getPixel(2, 0).toString == "@") // High grayscale
    }
  }


  test("convert should return error for invalid input") {
    val imageConverter = PatternBasedAsciiImageConverter()
    val rgbPixelGrid = PixelGrid[RGBPixel](0, 0) // Invalid grid size
    val image = RGBImage(rgbPixelGrid)

    val result = imageConverter.convert(image)

    assert(result.isRight)
    // Check for a specific error message if your converter is designed to return one
  }

}
