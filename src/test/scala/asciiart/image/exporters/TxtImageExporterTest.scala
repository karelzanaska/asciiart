package asciiart.image.exporters

import asciiart.image.models.grid.PixelGrid
import asciiart.image.models.image.AsciiImage
import asciiart.image.models.pixel.AsciiPixel
import org.scalatest.FunSuite

import java.io.File

class TxtImageExporterTest extends FunSuite {

  test("validateFileExtension should return true when file is txt type") {
    val exporter = TxtImageExporter("test.txt")
    assert(exporter.validateFileExtension("test.txt"))
  }

  test("validateFileExtension should return false when file is not txt type") {
    val exporter = TxtImageExporter("test.txt")
    assert(!exporter.validateFileExtension("test.jpg"))
  }

  test("exportImage should correctly create txt file") {
    val pixelGrid = PixelGrid[AsciiPixel](2, 2)
    pixelGrid.setPixel(0, 0, AsciiPixel('a'))
    pixelGrid.setPixel(0, 1, AsciiPixel('b'))
    pixelGrid.setPixel(1, 0, AsciiPixel('c'))
    pixelGrid.setPixel(1, 1, AsciiPixel('d'))

    val image = AsciiImage(pixelGrid)

    val filePath = "src/test/resources/test.txt"
    val exporter = TxtImageExporter(filePath)

    exporter.exportImage(image)

    val file = new File(filePath)
    val lines = scala.io.Source.fromFile(file).getLines.toList
    assert(lines == List("ab", "cd"))

    file.delete()
  }
}
