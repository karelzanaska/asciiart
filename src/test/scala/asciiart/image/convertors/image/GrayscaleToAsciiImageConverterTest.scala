package asciiart.image.convertors.image

import asciiart.image.convertors.pixel.PixelConvertor
import asciiart.image.models.grid.PixelGrid
import asciiart.image.models.image.{AsciiImage, RGBImage}
import asciiart.image.models.pixel.{AsciiPixel, RGBPixel}
import org.scalatest.FunSuite

class GrayscaleToAsciiImageConverterTest extends FunSuite {

  test("convert should correctly convert RGBImage to AsciiImage when input is valid") {
    val pixelConvertor = new PixelConvertor[RGBPixel, AsciiPixel] {
      override def convert(pixel: RGBPixel): Either[String, AsciiPixel] = Right(AsciiPixel('a'))
    }
    val imageConvertor = GrayscaleToAsciiImageConverter(pixelConvertor)
    val rgbPixelGrid = PixelGrid[RGBPixel](1, 1)
    val image = RGBImage(rgbPixelGrid)

    val result = imageConvertor.convert(image)

    assert(result.isRight)
    result.right.foreach(asciiImage => assert(asciiImage.isInstanceOf[AsciiImage]))
  }

  test("convert should return error when input is not valid") {

    val pixelConvertor = new PixelConvertor[RGBPixel, AsciiPixel] {
      override def convert(pixel: RGBPixel): Either[String, AsciiPixel] = Left("Some error occurred")
    }
    val imageConvertor = GrayscaleToAsciiImageConverter(pixelConvertor)
    val rgbPixelGrid = PixelGrid[RGBPixel](1, 1)
    val image = RGBImage(rgbPixelGrid)

    val result = imageConvertor.convert(image)

    assert(result.isLeft)
    result.left.foreach(error => assert(error == "Some error occurred"))
  }

}
