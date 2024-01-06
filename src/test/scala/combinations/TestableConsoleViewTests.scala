package combinations

import org.scalatest._

import scala.io.Source
import asciiart.ui.TestableConsoleView
import asciiart.controllers.{ConsoleController, Controller}
import asciiart.image.convertors.image.ImageConverter
import asciiart.image.exporters.ImageExporter
import asciiart.image.filters.ImageFilter
import asciiart.image.importers.ImageImporter
import asciiart.image.models.image.{AsciiImage, RGBImage}

import scala.Console.in
import scala.reflect.runtime.currentMirror
import scala.reflect.runtime.universe.{Type, runtimeMirror, typeOf}
//case class TestableConsoleViewTests()

import scala.io.Source
import play.api.libs.json._


class ASCIIArtConverterTests extends FlatSpec with Matchers {

//  val configJson: JsValue = Json.parse(Source.fromFile("/home/karel/FEL/ZKS/asciiart/src/test/scala/combinations/testConfig.json").mkString)


  def parseCSV(filePath: String): List[(String, String, String, String)] = {
    val source = Source.fromFile(filePath)
    val lines = source.getLines().filterNot(_.startsWith("#"))
    val configs = lines.map { line =>
      val parts = line.split(",").map(_.trim)
      (parts(0), parts(1), parts(2), parts(3))
    }.toList
    source.close()
    configs
  }


//  val testConfigs = parseCSV("/home/karel/FEL/ZKS/AsciiArt-output.csv")
  val testConfigs2Way = parseCSV("/home/karel/FEL/ZKS/AsciiArt-output-2-way.csv")
  val testConfigs3Way = parseCSV("/home/karel/FEL/ZKS/AsciiArt-output-3-way.csv")


  testConfigs2Way.foreach { case (importerName, filterName, exporterName, rgbExporterName) =>
    s"ASCII Art 2-way conversion with $importerName, $filterName, $exporterName, $rgbExporterName" should "work correctly" in {
      val controller = new ConsoleController()

      val importerConfig = TestConfig.importers.getOrElse(importerName, StringValue(""))
      val importer = createComponent(importerName, importerConfig).asInstanceOf[ImageImporter[RGBImage]]

      val converterConfig = TestConfig.converters.getOrElse("asciiart.image.convertors.image.PatternBasedAsciiImageConverter", "")
      val converter = createComponent("asciiart.image.convertors.image.PatternBasedAsciiImageConverter", converterConfig).asInstanceOf[ImageConverter[RGBImage, AsciiImage]]

      val filterConfig = TestConfig.filters.getOrElse(filterName, Map.empty)
      val filter = createComponent(filterName, filterConfig).asInstanceOf[ImageFilter[RGBImage]]

      val exporterConfig = TestConfig.exporters.getOrElse(exporterName, StringValue(""))
      val exporter = createComponent(exporterName, exporterConfig).asInstanceOf[ImageExporter[AsciiImage]]

      val rgbExporterConfig = TestConfig.rgbExporters.getOrElse(rgbExporterName, "")
      val rgbExporter = createComponent(rgbExporterName, rgbExporterConfig).asInstanceOf[ImageExporter[RGBImage]]

      // Instantiate TestableConsoleView with the components
      val view = new TestableConsoleView(
        controller,
        Some(importer),
        Some(converter),
        List(rgbExporter),
        List(exporter),
        List(filter)
      )

      val result = view.executeAndCaptureOutput()

      result should not be None
    }
  }


  testConfigs3Way.foreach { case (importerName, filterName, exporterName, rgbExporterName) =>
    s"ASCII Art 3-way conversion with $importerName, $filterName, $exporterName, $rgbExporterName" should "work correctly" in {
      val controller = new ConsoleController()

      val importerConfig = TestConfig.importers.getOrElse(importerName, StringValue(""))
      val importer = createComponent(importerName, importerConfig).asInstanceOf[ImageImporter[RGBImage]]

      val converterConfig = TestConfig.converters.getOrElse("asciiart.image.convertors.image.PatternBasedAsciiImageConverter", "")
      val converter = createComponent("asciiart.image.convertors.image.PatternBasedAsciiImageConverter", converterConfig).asInstanceOf[ImageConverter[RGBImage, AsciiImage]]

      val filterConfig = TestConfig.filters.getOrElse(filterName, Map.empty)
      val filter = createComponent(filterName, filterConfig).asInstanceOf[ImageFilter[RGBImage]]

      val exporterConfig = TestConfig.exporters.getOrElse(exporterName, StringValue(""))
      val exporter = createComponent(exporterName, exporterConfig).asInstanceOf[ImageExporter[AsciiImage]]

      val rgbExporterConfig = TestConfig.rgbExporters.getOrElse(rgbExporterName, "")
      val rgbExporter = createComponent(rgbExporterName, rgbExporterConfig).asInstanceOf[ImageExporter[RGBImage]]

      // Instantiate TestableConsoleView with the components
      val view = new TestableConsoleView(
        controller,
        Some(importer),
        Some(converter),
        List(rgbExporter),
        List(exporter),
        List(filter)
      )

      // Execute the ASCII art conversion process and capture the result
      val result = view.executeAndCaptureOutput()

      // Assertions about the result
      // Replace this with appropriate assertions based on your application's expected behavior
      result should not be None
      // Additional assertions can be added here
    }
  }


  def createComponent(className: String, config: Any): Any = {
    try {
      val mirror = scala.reflect.runtime.currentMirror
      val classSymbol = mirror.staticClass(className)
      val classMirror = mirror.reflectClass(classSymbol)
      val ctorSymbol = classSymbol.primaryConstructor.asMethod
      val ctorMirror = classMirror.reflectConstructor(ctorSymbol)

      config match {
        case configMap: Map[String, ConfigValue] =>
          val args = ctorSymbol.paramLists.flatten.map { param =>
            val paramName = param.name.toString
            val paramConfigValue = configMap.getOrElse(paramName, getDefaultParamValue(param.typeSignature))

            paramConfigValue match {
              case StringValue(value) => value
              case CharValue(value) => value
              case IntValue(value) => value
              case FloatValue(value) => value
              case NullValue() => null
              // Handle other types as needed
              case _ => getDefaultParamValue(param.typeSignature)
            }
          }
          println(s"Creating instance of $className with args: ${args.mkString(", ")}")
          ctorMirror(args: _*)

        case StringValue(value) => ctorMirror(value)
        case CharValue(value) => ctorMirror(value)
        case IntValue(value) => ctorMirror(value)
        case FloatValue(value) => ctorMirror(value)
        case NullValue() => ctorMirror()

        case _ =>
          println(s"Creating instance of $className with single arg: $config")
          ctorMirror(config)
      }

    } catch {
      case e: Exception =>
        println(s"Error creating instance of class $className with config $config: ${e.getMessage}")
        throw e
    }
  }


  def getDefaultParamValue(tpe: Type): Any = tpe match {
    case t if t =:= typeOf[String] => ""
    case t if t =:= typeOf[Int] => 0
    case t if t =:= typeOf[Double] => 0.0
    case t if t =:= typeOf[Boolean] => false
    case _ => null
  }
}
