package asciiart.ui

import asciiart.controllers.Controller
import asciiart.image.convertors.image.{GrayscaleToAsciiImageConvertor, ImageConvertor}
import asciiart.image.exporters.{FileSystemImageExporter, ImageExporter, StdoutImageExporter}
import asciiart.image.filters.ImageFilter
import asciiart.image.filters.invert.InvertImageFilter
import asciiart.image.importers.{FileSystemImageImporter, ImageImporter}
import asciiart.image.models.grid.PixelGrid
import asciiart.image.models.image.{AsciiImage, RGBImage}
import asciiart.image.models.pixel.{AsciiPixel, RGBPixel}
import org.mockito.ArgumentMatchers.anyString
import org.mockito.ArgumentMatchersSugar.any
import org.mockito.Mockito.doNothing
import org.mockito.MockitoSugar.{mock, times, verify, verifyZeroInteractions, when}
import org.scalatest.FunSuite


class ConsoleViewTest extends FunSuite {

  test("Run with valid input") {
    val rgbPixelGrid = new PixelGrid[RGBPixel](1, 1)
    rgbPixelGrid.setPixel(0, 0, RGBPixel(0, 0, 0))
    val rgbImage = RGBImage(rgbPixelGrid)
    val asciiPixelGrid = new PixelGrid[AsciiPixel](1, 1)
    asciiPixelGrid.setPixel(0, 0, AsciiPixel('a'))

    val mockController = mock[Controller[RGBImage, AsciiImage]]
    when(mockController.importImage(any[ImageImporter[RGBImage]])).thenReturn(Some(rgbImage))
    when(mockController.applyFilter(any[RGBImage], any[InvertImageFilter])).thenReturn(Some(rgbImage))
    when(mockController.applyConvertor(any[RGBImage], any[ImageConvertor[RGBImage, AsciiImage]])).thenReturn(Some(AsciiImage(asciiPixelGrid)))
    doNothing().when(mockController).exportImage(any[AsciiImage], any[ImageExporter[AsciiImage]])
    doNothing().when(mockController).showErrorMessage(anyString())
    doNothing().when(mockController).showHelp()

    val args = List("--image", "samples/cloud.jpg", "--output-console", "--output-file", "output.txt", "--invert")

    val consoleView = new ConsoleView(mockController, args)

    consoleView.run()

    verify(consoleView.controller, times(1)).importImage(any[FileSystemImageImporter])
    verify(consoleView.controller, times(1)).applyFilter(any[RGBImage], any[InvertImageFilter])
    verify(consoleView.controller, times(2)).exportImage(any[AsciiImage], any[ImageExporter[AsciiImage]])
  }

  test("Run with invalid input") {
    val rgbPixelGrid = new PixelGrid[RGBPixel](1, 1)
    rgbPixelGrid.setPixel(0, 0, RGBPixel(0, 0, 0))
    val rgbImage = RGBImage(rgbPixelGrid)
    val asciiPixelGrid = new PixelGrid[AsciiPixel](1, 1)
    asciiPixelGrid.setPixel(0, 0, AsciiPixel('a'))

    val mockController = mock[Controller[RGBImage, AsciiImage]]
    when(mockController.importImage(any[ImageImporter[RGBImage]])).thenReturn(Some(rgbImage))
    when(mockController.applyFilter(any[RGBImage], any[InvertImageFilter])).thenReturn(Some(rgbImage))
    when(mockController.applyConvertor(any[RGBImage], any[ImageConvertor[RGBImage, AsciiImage]])).thenReturn(Some(AsciiImage(asciiPixelGrid)))
    doNothing().when(mockController).exportImage(any[AsciiImage], any[ImageExporter[AsciiImage]])
    doNothing().when(mockController).showErrorMessage(anyString())
    doNothing().when(mockController).showHelp()

    val args = List("--image", "samples/cloud.gif", "--output-console", "--output-file", "output.txt", "--invert", "--table", "whatevertable")

    val consoleView = new ConsoleView(mockController, args)

    consoleView.run()

    verify(consoleView.controller, times(1)).showErrorMessage("Unsupported image format. Please use JPG or PNG file.")
  }
}
