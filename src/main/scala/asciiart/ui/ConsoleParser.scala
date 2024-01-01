package asciiart.ui

import asciiart.image.convertors.image.{GrayscaleToAsciiImageConverter, ImageConverter, PatternBasedAsciiImageConverter}
import asciiart.image.convertors.pixel.{LinearGrayscaleToAsciiPixelConvertor, NonLinearGrayscaleToAsciiPixelConvertor, PaulBourkeGrayscaleToAsciiPixelConvertor}
import asciiart.image.exporters.{BMPImageExporter, GIFImageExporter, ImageExporter, JPGImageExporter, PNGImageExporter, StdoutImageExporter, TxtImageExporter}
import asciiart.image.filters.ImageFilter
import asciiart.image.filters.flip.FlipImageFilter
import asciiart.image.filters.invert.InvertImageFilter
import asciiart.image.filters.rotate.RotateImageFilter
import asciiart.image.filters.scale.ScaleImageFilter
import asciiart.image.importers.{FileSystemImageImporter, ImageImporter, JPGImageImporter, RandomImageGeneratorImporter}
import asciiart.image.models.image.{AsciiImage, RGBImage}

import scala.Right
import scala.collection.mutable.ListBuffer

class ConsoleParser(private val args: List[String]) {

  private val parsedArgs: List[(String, Option[String])] = parseArguments(args)

  private def parseArguments(args: List[String]): List[(String, Option[String])] = {
    var parameter = ""
    val arguments = new ListBuffer[(String, Option[String])]()

    args.foreach(command => {
      if (command.startsWith("--")) {
        if (parameter.nonEmpty) {
          arguments += ((parameter, None))
          parameter = ""
        }
        parameter = command.substring(2)
      }
      else {
        if (parameter.nonEmpty) {
          arguments += ((parameter, Some(command)))
          parameter = ""
        }
      }
    })
    if (parameter.nonEmpty) {
      arguments += ((parameter, None))
    }
    arguments.toList
  }

  def isHelp(): Boolean = {
    parsedArgs.exists(arg => arg._1 == "help" || arg._1 == "h")
  }

  def getImageImporter(): Either[String, ImageImporter[RGBImage]] = {
    val imageCommand = parseImageCommand()
    imageCommand fold(
      error => Left(error),
      command =>
        command._1 match {
          case "image" =>
            command._2 match {
//              case Some(path) if path.endsWith(".jpg") => Right(FileSystemImageImporter(path))
//              case Some(path) if path.endsWith(".png") => Right(FileSystemImageImporter(path))
//              case Some(path) if path.endsWith(".gif") => Right(FileSystemImageImporter(path))
//              case Some(path) if path.endsWith(".bmp") => Right(FileSystemImageImporter(path))
              case Some(path) if path.endsWith(".jpg") => Right(JPGImageImporter(path))
              case Some(path) if path.endsWith(".png") => Right(JPGImageImporter(path))
              case Some(path) if path.endsWith(".gif") => Right(JPGImageImporter(path))
              case Some(path) if path.endsWith(".bmp") => Right(JPGImageImporter(path))
              case Some(_) => Left("Unsupported image format. Please use JPG or PNG or GIF or BMP file.")
              case None => Left("No image path specified.")
            }
          case "image-random" => Right(RandomImageGeneratorImporter())
          case "image-random-gradient" => Right(RandomImageGeneratorImporter())
          case _ => Left("Invalid image command.")
        }
    )
  }

  def getAsciiImageExporters(): Either[String, List[ImageExporter[AsciiImage]]] = {
//    val imageExporters = new ListBuffer[ImageExporter[AsciiImage]]()
    val imageExporters = new ListBuffer[ImageExporter[AsciiImage]]()

    val outputConsole = parsedArgs.find(_._1 == "output-console")
    if (outputConsole.isDefined) {
        imageExporters += StdoutImageExporter()
    }

    val outputFile = parsedArgs.find(_._1 == "output-file")
    if (outputFile.isDefined) {
      val path = outputFile.get._2.get
      if (path.endsWith(".txt")) {
        imageExporters += TxtImageExporter(path)
      }
      else {
        return Left("Unsupported output file format. Please use TXT file.")
      }
    }

    Right(imageExporters.toList)
  }

  def getRGBImageExporters(): Either[String, List[ImageExporter[RGBImage]]] = {
    val imageExporters = new ListBuffer[ImageExporter[RGBImage]]()

    parsedArgs.foreach(arg => {
      arg._1 match {
        case "output-rgb-file" =>
          val path = arg._2.get
          if (path.endsWith(".jpg")) {
            imageExporters += JPGImageExporter(path)
          }
          else if (path.endsWith(".png")) {
            imageExporters += PNGImageExporter(path)
          }
          else if (path.endsWith(".gif")) {
            imageExporters += GIFImageExporter(path)
          }
          else if (path.endsWith(".bmp")) {
            imageExporters += BMPImageExporter(path)
          }
          else {
            return Left("Unsupported output file format. Please use JPG or PNG or GIF or BMP file.")
          }
        case _ => Left("Invalid rgb image command.")
      }
    })

//    val outputFile = parsedArgs.find(_._1 == "output-rgb-file")
//    if (outputFile.isDefined) {
//      val path = outputFile.get._2.get
//      if (path.endsWith(".jpg")) {
//        imageExporters += JPGImageExporter(path)
//      }
//      else if (path.endsWith(".png")) {
//        imageExporters += PNGImageExporter(path)
//      }
//      else if (path.endsWith(".gif")) {
//        imageExporters += GIFImageExporter(path)
//      }
//      else if (path.endsWith(".bmp")) {
//        imageExporters += BMPImageExporter(path)
//      }
//      else {
//        return Left("Unsupported output file format. Please use JPG or PNG or GIF or BMP file.")
//      }
//    }

    Right(imageExporters.toList)
  }

  def getImageFilters(): Either[String, List[ImageFilter[RGBImage]]] = {
    val filters = new ListBuffer[ImageFilter[RGBImage]]()
    parsedArgs.foreach(arg => {
      arg._1 match {
        case "invert" => filters += InvertImageFilter()
        case "rotate" =>
          parseRotateFilter(arg._2.get).fold(
            error => return Left(error),
            degrees => {filters += RotateImageFilter(degrees)}
          )
        case "scale" =>
            parseScaleFilter(arg._2.get).fold(
                error => return Left(error),
                scale => {filters += ScaleImageFilter(scale)}
            )
        case "flip" =>
          parseFlipFilter(arg._2.get).fold(
            error => return Left(error),
            flip => {filters += FlipImageFilter(flip)}
          )
        case _ =>
      }
    })
    Right(filters.toList)
  }

  def getAsciiImageConvertor(): Either[String, ImageConverter[RGBImage, AsciiImage]] = {
    val tableConvertor = parsedArgs.find(_._1 == "table")
    if (tableConvertor.isDefined) {
      val convertor: Either[String, ImageConverter[RGBImage, AsciiImage]] = tableConvertor.get._2.get match {
        case "paulbourke" => Right(GrayscaleToAsciiImageConverter(new PaulBourkeGrayscaleToAsciiPixelConvertor))
        case "nonlinear" => Right(GrayscaleToAsciiImageConverter(new NonLinearGrayscaleToAsciiPixelConvertor))
        case "patternbased" => Right(PatternBasedAsciiImageConverter())
        case _ => Left("Invalid argument for table. Please use paulbourke or nonlinear.")
      }
      return convertor
    }

    val manuallySetConvertor = parsedArgs.find(_._1 == "custom-table")
    if (manuallySetConvertor.isDefined) {
      val convertor = manuallySetConvertor.get._2 match {
        case Some(value) =>
          val convertor = GrayscaleToAsciiImageConverter(new LinearGrayscaleToAsciiPixelConvertor(value))
          Right(convertor)
        case None => Left("Invalid argument for custom-table.")
      }
      return convertor
    }

    // no table specified, use default
    Right(GrayscaleToAsciiImageConverter(new PaulBourkeGrayscaleToAsciiPixelConvertor))
  }

  private def parseRotateFilter(degrees: String): Either[String, Int] = {
    try {
      if (degrees.startsWith("+")) Right(degrees.substring(1).toInt)
      else if (degrees.startsWith("-")) Right(-degrees.substring(1).toInt)
      else Right(degrees.toInt)
    } catch {
      case _: NumberFormatException => Left("Invalid argument for rotate.")
    }
  }

  private def parseScaleFilter(scale: String): Either[String, Float] = {
    try {
      Right(scale.toFloat)
    } catch {
      case _: NumberFormatException => Left("Invalid argument for scale.")
    }
  }

  private def parseFlipFilter(flip: String): Either[String, Char] = {
    if (flip == "x" || flip == "y") Right(flip.head)
    else Left("Invalid argument for flip.")
  }

  private def parseImageCommand(): Either[String, (String, Option[String])] = {
    val imageCommands: Seq[(String, Option[String])] = parsedArgs.filter(arg => arg._1 == "image" || arg._1 == "image-random" || arg._1 == "image-random-gradient")

    if (imageCommands.isEmpty) Left("No image command specified")
    else if (imageCommands.length > 1) Left("Multiple image commands specified. Please specify only one image command.")
    else Right(imageCommands.head)
  }

}
