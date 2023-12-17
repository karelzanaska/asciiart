package asciiart.image.exporters

import asciiart.image.models.image.{AsciiImage, Image}

import java.io.{BufferedWriter, File, FileWriter}

case class TxtImageExporter(path: String) extends FileSystemImageExporter {

  override def exportImage(image: AsciiImage): Either[String, Unit] = {
    val file = new File(path)
    val bw = new BufferedWriter(new FileWriter(file))
    bw.write(image.toString)
    bw.close()
    Right()
  }

  override def validateFileExtension(path: String): Boolean = {
    path.split('.').last == "txt"
  }

}
