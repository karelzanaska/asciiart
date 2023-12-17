package asciiart.image.exporters

import asciiart.image.models.grid.PixelGrid
import asciiart.image.models.image.AsciiImage
import asciiart.image.models.pixel.AsciiPixel
import org.scalatest.FunSuite

class StdoutImageExporterTest extends FunSuite {

  test("exportImage should correctly export image to stdout") {
    val pixelGrid = PixelGrid[AsciiPixel](2, 2)
    pixelGrid.setPixel(0, 0, AsciiPixel('a'))
    pixelGrid.setPixel(0, 1, AsciiPixel('b'))
    pixelGrid.setPixel(1, 0, AsciiPixel('c'))
    pixelGrid.setPixel(1, 1, AsciiPixel('d'))

    val image = AsciiImage(pixelGrid)

    val exporter = StdoutImageExporter()

    val capturedOutput = new java.io.ByteArrayOutputStream
    Console.withOut(capturedOutput) {
      val result = exporter.exportImage(image)
      assert(result.isRight)
    }

    assert(capturedOutput.toString == "ab\ncd\n")
  }

}
