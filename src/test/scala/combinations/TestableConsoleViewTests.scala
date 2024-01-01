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


//class ASCIIArtConverterTests extends FlatSpec with Matchers {
//
//  // Function to parse the CSV file and return a list of test configurations
//  def parseCSV(filePath: String): List[(String, String, String, String)] = {
//    val source = Source.fromFile(filePath)
//    val lines = source.getLines().drop(4) // Skipping header lines
//    val configs = lines.flatMap { line =>
//      val parts = line.split(",").map(_.trim)
//      if (parts.length == 4) Some((parts(0), parts(1), parts(2), parts(3)))
//      else None
//    }.toList
//    source.close()
//    configs
//  }
//
//  def createInstance(className: String, arg: String): Any = {
//    val mirror = runtimeMirror(getClass.getClassLoader)
//    val classSymbol = mirror.staticClass(className)
//    val classMirror = mirror.reflectClass(classSymbol)
//    val ctorSymbol = classSymbol.primaryConstructor.asMethod
//    val ctorMirror = classMirror.reflectConstructor(ctorSymbol)
//    ctorMirror.apply(arg)
//  }
//
//
//
//  // Load test configurations from the CSV file
//  val testConfigs = parseCSV("/home/karel/FEL/ZKS/asciiconvertor-output.csv")
//
//
////  testConfigs.foreach { case (importerName, converterName, filterName, exporterName, rgbExporterName) =>
////    s"ASCII Art conversion with $importerName, $converterName, $filterName, $exporterName, $rgbExporterName" should "work correctly" in {
////      // Create a Controller instance (replace with actual controller initialization)
////      val controller = new ConsoleController()
////
////      // Dynamically create instances of importer, converter, filter, and exporter
////      val importer = Some(createInstance(importerName, "path_to_import").asInstanceOf[ImageImporter[RGBImage]])
////      val converter = Some(createInstance(converterName, "converter_param").asInstanceOf[ImageConverter[RGBImage, AsciiImage]])
////      val filter = List(createInstance(filterName, "filter_param").asInstanceOf[ImageFilter[RGBImage]])
////      val exporter = createInstance(exporterName, "exporter_param").asInstanceOf[ImageExporter[AsciiImage]]
////      val rgbExporter = createInstance(rgbExporterName, "exporter_param").asInstanceOf[ImageExporter[RGBImage]]
////
////      // For simplicity, assuming the same exporter works for both RGB and Ascii Images
//////      val rgbExporters = List(exporter.asInstanceOf[ImageExporter[RGBImage]])
////      val asciiExporters = List(exporter)
////      val rgbExporters = List(rgbExporter)
////
////      // Create a TestableConsoleView instance with these components
////      val view = new TestableConsoleView(controller, importer, converter, rgbExporters, asciiExporters, filter)
////
////      // Perform the ASCII art conversion
////      val result = view.executeAndCaptureOutput()
////
////      // Assert the expected outcome
////      val expectedResult = Some(AsciiImage(null)) // Replace 'expectedResult' with the actual expected result
////      assert(result == expectedResult) // Replace 'expectedResult' with the actual expected result
////    }
////  }
//
//}
//
//
//
////class ASCIIArtConverterTests extends AnyFlatSpec with Matchers {
////  // Function to parse the JSON configuration file
////  def parseConfig(filePath: String): JsValue = {
////    val source = Source.fromFile(filePath)
////    val configJson = Json.parse(source.mkString)
////    source.close()
////    configJson
////  }
////
////  // Function to create an instance of a class with optional arguments
////  def createInstance(className: String, config: JsValue): Any = {
////    val mirror = runtimeMirror(getClass.getClassLoader)
////    val classSymbol = mirror.staticClass(className)
////    val classMirror = mirror.reflectClass(classSymbol)
////    val ctorSymbol = classSymbol.primaryConstructor.asMethod
////    val ctorMirror = classMirror.reflectConstructor(ctorSymbol)
////
////    config match {
////      case JsString(arg) => ctorMirror.apply(arg)
////      case JsObject(_) => ctorMirror.apply() // No arguments for empty object
////      case _ => ctorMirror.apply() // Default case for no arguments
////    }
////  }
////
////  // Load configuration
////  val config = parseConfig("/path/to/your/config.json")
////
////  // Load test configurations from the CSV file
////  val testConfigs = parseCSV("/path/to/your/testfile.csv")
////
////  testConfigs.foreach { case (importerName, filterName, exporterName, rgbExporterName) =>
////    s"ASCII Art conversion with $importerName, $filterName, $exporterName, $rgbExporterName" should "work correctly" in {
////      // Create a Controller instance (replace with actual controller initialization)
////      val controller = new ConsoleController()
////
////      // Dynamically create instances of importer, converter, filter, and exporter
////      val importerConfig = (config \ "importers" \ importerName).getOrElse(JsString(""))
////      val importer = Some(createInstance(importerName, importerConfig).asInstanceOf[ImageImporter[RGBImage]])
////
////      val converterConfig = (config \ "converters" \ "PatternBasedAsciiImageConverter").getOrElse(JsString(""))
////      val converter = Some(createInstance("asciiart.image.convertors.image.PatternBasedAsciiImageConverter", converterConfig).asInstanceOf[ImageConverter[RGBImage, AsciiImage]])
////
////      val filterConfig = (config \ "filters" \ filterName).getOrElse(JsString(""))
////      val filter = List(createInstance(filterName, filterConfig).asInstanceOf[ImageFilter[RGBImage]])
////
////      val exporterConfig = (config \ "exporters" \ exporterName).getOrElse(JsString(""))
////      val exporter = createInstance(exporterName, exporterConfig).asInstanceOf[ImageExporter[AsciiImage]]
////
////      val rgbExporterConfig = (config \ "rgb_exporters" \ rgbExporterName).getOrElse(JsString(""))
////      val rgbExporter = createInstance(rgbExporterName, rgbExporterConfig).asInstanceOf[ImageExporter[RGBImage]]
////
////      val asciiExporters = List(exporter)
////      val rgbExporters = List(rgbExporter)
////
////      // Create a TestableConsoleView instance with these components
////      val view = new TestableConsoleView(controller, importer, converter, rgbExporters, asciiExporters, filter)
////
////      // Perform the ASCII art conversion
////      val result = view.executeAndCaptureOutput()
////
////      // Assert the expected outcome
////      val expectedResult = Some(AsciiImage(null)) // Replace 'expectedResult' with the actual expected result
////      assert(result == expectedResult) // Replace 'expectedResult' with the actual expected result
////    }
////  }
////
////  // Function to parse the CSV file and return a list of test configurations
//////  def parseCSV(filePath: String): List[(String, String, String, String)] = {
//////    // ... (existing implementation)
//////  }
////
////  def parseCSV(filePath: String): List[(String, String, String, String)] = {
////    val source = Source.fromFile(filePath)
////    val lines = source.getLines().drop(4) // Skipping header lines
////    val configs = lines.flatMap { line =>
////      val parts = line.split(",").map(_.trim)
////      if (parts.length == 4) Some((parts(0), parts(1), parts(2), parts(3)))
////      else None
////    }.toList
////    source.close()
////    configs
////  }
////}
////
//
////
////import scala.io.Source
////import org.json4s._
////import org.json4s.native.JsonMethods._
////import org.scalatest.flatspec.AnyFlatSpec
////import org.scalatest.matchers.should.Matchers
////import scala.reflect.runtime.universe._
//
////class ASCIIArtConverterTests extends AnyFlatSpec with Matchers {
////  implicit val formats: Formats = DefaultFormats
////
////  // Function to parse the JSON configuration file
////  def parseConfig(filePath: String): JValue = {
////    val source = Source.fromFile(filePath)
////    val configJson = parse(source.mkString)
////    source.close()
////    configJson
////  }
////
////  // Function to create an instance of a class with optional arguments
////  def createInstance(className: String, config: JValue): Any = {
////    val mirror = runtimeMirror(getClass.getClassLoader)
////    val classSymbol = mirror.staticClass(className)
////    val classMirror = mirror.reflectClass(classSymbol)
////    val ctorSymbol = classSymbol.primaryConstructor.asMethod
////    val ctorMirror = classMirror.reflectConstructor(ctorSymbol)
////
////    config match {
////      case JString(arg) => ctorMirror.apply(arg)
////      case JObject(_) => ctorMirror.apply() // No arguments for empty object
////      case _ => ctorMirror.apply() // Default case for no arguments
////    }
////  }
////
////  // Load configuration
////  val config = parseConfig("/path/to/your/config.json")
////
////  // Load test configurations from the CSV file
////  val testConfigs = parseCSV("/path/to/your/testfile.csv")
////
////  testConfigs.foreach { case (importerName, filterName, exporterName, rgbExporterName) =>
////    s"ASCII Art conversion with $importerName, $filterName, $exporterName, $rgbExporterName" should "work correctly" in {
////      // Create a Controller instance (replace with actual controller initialization)
////      val controller = new ConsoleController()
////
////      // Dynamically create instances of importer, converter, filter, and exporter
////      val importerConfig = (config \ "importers" \ importerName).getOrElse(JString(""))
////      val importer = Some(createInstance(importerName, importerConfig).asInstanceOf[ImageImporter[RGBImage]])
////
////      val converterConfig = (config \ "converters" \ "PatternBasedAsciiImageConverter").getOrElse(JString(""))
////      val converter = Some(createInstance("asciiart.image.convertors.image.PatternBasedAsciiImageConverter", converterConfig).asInstanceOf[ImageConverter[RGBImage, AsciiImage]])
////
////      val filterConfig = (config \ "filters" \ filterName).getOrElse(JString(""))
////      val filter = List(createInstance(filterName, filterConfig).asInstanceOf[ImageFilter[RGBImage]])
////
////      val exporterConfig = (config \ "exporters" \ exporterName).getOrElse(JString(""))
////      val exporter = createInstance(exporterName, exporterConfig).asInstanceOf[ImageExporter[AsciiImage]]
////
////      val rgbExporterConfig = (config \ "rgb_exporters" \ rgbExporterName).getOrElse(JString(""))
////      val rgbExporter = createInstance(rgbExporterName, rgbExporterConfig).asInstanceOf[ImageExporter[RGBImage]]
////
////      val asciiExporters = List(exporter)
////      val rgbExporters = List(rgbExporter)
////
////      // Create a TestableConsoleView instance with these components
////      val view = new TestableConsoleView(controller, importer, converter, rgbExporters, asciiExporters, filter)
////
////      // Perform the ASCII art conversion
////      val result = view.executeAndCaptureOutput()
////
////      // Assert the expected outcome
////      val expectedResult = Some(AsciiImage(null)) // Replace 'expectedResult' with the actual expected result
////      assert(result == expectedResult) // Replace 'expectedResult' with the actual expected result
////    }
////  }
////
////  // Function to parse the CSV file and return a list of test configurations
////  def parseCSV(filePath: String): List[(String, String, String, String)] = {
////    // ... (existing implementation)
////  }
////}
//











import scala.io.Source
import play.api.libs.json._

class ASCIIArtConverterTests extends FlatSpec with Matchers {
  // Parse the JSON configuration
//  val configJson: JsValue = Json.parse(Source.fromFile("path/to/config.json").mkString)
  val configJson: JsValue = Json.parse(Source.fromFile("/home/karel/FEL/ZKS/asciiart/src/test/scala/combinations/testConfig.json").mkString)

  // Function to create an instance of a component
  def createComponent(className: String, config: JsValue): Any = {
    // Reflection or other logic to create an instance based on className and config
  }

  // Function to parse the CSV file and return test configurations
//  def parseCSV(filePath: String): List[(String, String, String, String)] = {
//    val source = Source.fromFile(filePath)
//    val lines = source.getLines().drop(1) // Skip header line
//    val configs = lines.map { line =>
//      val parts = line.split(",").map(_.trim)
//      (parts(0), parts(1), parts(2), parts(3))
//    }.toList
//    source.close()
//    configs
//  }

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


//  // Load test configurations from the CSV file
//  val testConfigs = parseCSV("/home/karel/FEL/ZKS/asciiconvertor-output.csv")
  val testConfigs = parseCSV("/home/karel/FEL/ZKS/AsciiArt-output.csv")
//
//  testConfigs.foreach { case (importerName, filterName, exporterName, rgbExporterName) =>
//    s"ASCII Art conversion with $importerName, $filterName, $exporterName, $rgbExporterName" should "work correctly" in {
////      val controller = new Controller[RGBImage, AsciiImage]() // Replace with actual controller initialization
//      val controller = new ConsoleController()
//
//      val importerConfig = (configJson \ "importers" \ importerName).get
//      val importer = createComponent(importerName, importerConfig).asInstanceOf[ImageImporter[RGBImage]]
//
//      val converterConfig = (configJson \ "converters" \ "PatternBasedAsciiImageConverter").get
//      val converter = createComponent("asciiart.image.convertors.image.PatternBasedAsciiImageConverter", converterConfig).asInstanceOf[ImageConverter[RGBImage, AsciiImage]]
//
//      val filterConfig = (configJson \ "filters" \ filterName).get
//      val filter = createComponent(filterName, filterConfig).asInstanceOf[ImageFilter[RGBImage]]
//
//      val exporterConfig = (configJson \ "exporters" \ exporterName).get
//      val exporter = createComponent(exporterName, exporterConfig).asInstanceOf[ImageExporter[AsciiImage]]
//
//      val rgbExporterConfig = (configJson \ "rgb_exporters" \ rgbExporterName).get
//      val rgbExporter = createComponent(rgbExporterName, rgbExporterConfig).asInstanceOf[ImageExporter[RGBImage]]
//
//      val view = new TestableConsoleView(controller, Some(importer), Some(converter), List(rgbExporter), List(exporter), List(filter))
//      val result = view.executeAndCaptureOutput()
//
//      // Assertions about the result
//    }
//  }



//  testConfigs.foreach { case (importerName, filterName, exporterName, rgbExporterName) =>
//    s"ASCII Art conversion with $importerName, $filterName, $exporterName, $rgbExporterName" should "work correctly" in {
//      val controller = new ConsoleController()
//
//      val importerConfig = TestConfig.importers.getOrElse(importerName, "")
//      val importer = createComponent(importerName, importerConfig).asInstanceOf[ImageImporter[RGBImage]]
//
//      val converterConfig = TestConfig.converters.getOrElse("PatternBasedAsciiImageConverter", "")
//      val converter = createComponent("asciiart.image.convertors.image.PatternBasedAsciiImageConverter", converterConfig).asInstanceOf[ImageConverter[RGBImage, AsciiImage]]
//
//      val filterConfig = TestConfig.filters.getOrElse(filterName, Map.empty)
//      val filter = createComponent(filterName, filterConfig).asInstanceOf[ImageFilter[RGBImage]]
//
//      val exporterConfig = TestConfig.exporters.getOrElse(exporterName, "")
//      val exporter = createComponent(exporterName, exporterConfig).asInstanceOf[ImageExporter[AsciiImage]]
//
//      val rgbExporterConfig = TestConfig.rgbExporters.getOrElse(rgbExporterName, "")
//      val rgbExporter = createComponent(rgbExporterName, rgbExporterConfig).asInstanceOf[ImageExporter[RGBImage]]
//
//      // ... rest of the code ...
//    }
//  }
//



  testConfigs.foreach { case (importerName, filterName, exporterName, rgbExporterName) =>
    s"ASCII Art conversion with $importerName, $filterName, $exporterName, $rgbExporterName" should "work correctly" in {
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



  // Function to create a component instance
//  def createComponent(className: String, config: Any): Any = {
//    // Reflection or other logic to create an instance based on className and config
//
//  }


//  def createComponent(className: String, config: Any): Any = {
//    val mirror = currentMirror
//    val classSymbol = mirror.staticClass(className)
//    val classMirror = mirror.reflectClass(classSymbol)
//    val ctorSymbol = classSymbol.primaryConstructor.asMethod
//    val ctorMirror = classMirror.reflectConstructor(ctorSymbol)
//
//    config match {
//      case configMap: Map[_, _] =>
//        // If the config is a Map, assume it's a set of named parameters
//        val args = ctorSymbol.paramLists.flatten.map { param =>
//          val paramName = param.name.toString
//          configMap.getOrElse(paramName, getDefaultParamValue(param.typeSignature))
//        }
//        ctorMirror(args: _*)
//
//      case _ =>
//        // If the config is not a Map, assume it's a single parameter or no parameter
//        ctorMirror(config)
//    }
//  }
//
//  def getDefaultParamValue(tpe: Type): Any = tpe match {
//    case t if t =:= typeOf[String] => ""
//    case t if t =:= typeOf[Int] => 0
//    case t if t =:= typeOf[Double] => 0.0
//    case t if t =:= typeOf[Boolean] => false
//    case _ => null
//  }



//  def createComponent(className: String, config: Any): Any = {
//    System.out.println("createComponent " + className)
//    val mirror = currentMirror
//    val classSymbol = mirror.staticClass(className)
//    val classMirror = mirror.reflectClass(classSymbol)
//    val ctorSymbol = classSymbol.primaryConstructor.asMethod
//    val ctorMirror = classMirror.reflectConstructor(ctorSymbol)
//
//    config match {
//      case configMap: Map[String, _] =>
//        // If the config is a Map[String, Any], assume it's a set of named parameters
//        val args = ctorSymbol.paramLists.flatten.map { param =>
//          val paramName = param.name.toString
//          configMap.getOrElse(paramName, getDefaultParamValue(param.typeSignature))
//        }
//        ctorMirror(args: _*)
//
//      case _ =>
//        // If the config is not a Map, assume it's a single parameter or no parameter
//        ctorMirror(config)
//    }
//  }



//  def createComponent(className: String, config: Any): Any = {
//    try {
//      val mirror = scala.reflect.runtime.currentMirror
//      val classSymbol = mirror.staticClass(className)
//      val classMirror = mirror.reflectClass(classSymbol)
//      val ctorSymbol = classSymbol.primaryConstructor.asMethod
//      val ctorMirror = classMirror.reflectConstructor(ctorSymbol)
//
//      val instance = config match {
////        case configMap: Map[String, ConfigValue] =>
////          val args = ctorSymbol.paramLists.flatten.map { param =>
////            val paramName = param.name.toString
////            val paramValue = configMap.getOrElse(paramName, getDefaultParamValue(param.typeSignature))
////            println(s"Param for $className: $paramName = $paramValue (${paramValue.getClass})")
////            paramValue
////          }
////          ctorMirror(args: _*)
//
//
//
//        case configMap: Map[String, ConfigValue] =>
//          val args = ctorSymbol.paramLists.flatten.map { param =>
//            val paramName = param.name.toString
//            val paramConfigValue = configMap.getOrElse(paramName, getDefaultParamValue(param.typeSignature))
//
//            paramConfigValue match {
//              case StringValue(value) => value
//              case CharValue(value) => value
//              case IntValue(value) => value
//              // Handle other types as needed
//              case _ => getDefaultParamValue(param.typeSignature)
//            }
//          }
//          ctorMirror(args: _*)
//
//
//
//        case _ =>
//          println(s"Single param for $className: $config (${config.getClass})")
//          ctorMirror(config)
//      }
//
//      println(s"Created instance of $className")
//      instance
//
//    } catch {
//      case e: Exception =>
//        println(s"Error creating instance of class $className with config $config: ${e.getMessage}")
//        throw e
//    }
//  }


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
