package combinations


sealed trait ConfigValue
case class StringValue(value: String) extends ConfigValue
case class CharValue(value: Char) extends ConfigValue
case class IntValue(value: Int) extends ConfigValue
case class FloatValue(value: Float) extends ConfigValue
case class NullValue() extends ConfigValue



object TestConfig {
  val importers: Map[String, ConfigValue] = Map(
    "asciiart.image.importers.JPGImageImporter" -> StringValue("/home/karel/FEL/ZKS/asciiart/samples/cloud.jpg"),
    "asciiart.image.importers.PNGImageImporter" -> StringValue("/home/karel/FEL/ZKS/asciiart/samples/cloud.png"),
    "asciiart.image.importers.BMPImageImporter" -> StringValue("/home/karel/FEL/ZKS/asciiart/samples/cloud.bmp"),
    "asciiart.image.importers.GIFImageImporter" -> StringValue("/home/karel/FEL/ZKS/asciiart/samples/cloud.gif"),
    "asciiart.image.importers.RandomImageGeneratorImporter" -> NullValue(),
    "asciiart.image.importers.GradientRandomImageGeneratorImporter" -> NullValue(),
  )

  val converters: Map[String, ConfigValue] = Map(
    "asciiart.image.convertors.image.PatternBasedAsciiImageConverter" -> NullValue(),
  )

//  val filters: Map[String, Map[String, ConfigValue]] = Map(
  val filters: Map[String, ConfigValue] = Map(
//    "asciiart.image.filters.flip.FlipImageFilter" -> Map("flipValue" -> "x"),
    "asciiart.image.filters.flip.FlipImageFilter" -> CharValue('x'),
//    "asciiart.image.filters.invert.InvertImageFilter" -> Map(),
    "asciiart.image.filters.invert.InvertImageFilter" -> NullValue(),
//    "asciiart.image.filters.invert.InvertImageFilter" -> Map(),
//    "asciiart.image.filters.rotate.RotateImageFilter" -> Map("degrees" -> "90"),
    "asciiart.image.filters.rotate.RotateImageFilter" -> IntValue(90),
//    "asciiart.image.filters.scale.ScaleImageFilter" -> Map("scale" -> "1")
    "asciiart.image.filters.scale.ScaleImageFilter" -> FloatValue(1)
  )

  val exporters: Map[String, ConfigValue] = Map(
    "asciiart.image.exporters.StdoutImageExporter" -> NullValue(),
    "asciiart.image.exporters.TxtImageExporter" -> StringValue("/home/karel/FEL/ZKS/asciiart/samples/output-cloud.txt"),
  )

  val rgbExporters: Map[String, ConfigValue] = Map(
    "asciiart.image.exporters.JPGImageExporter" -> StringValue("/home/karel/FEL/ZKS/asciiart/samples/output-cloud.jpg"),
    "asciiart.image.exporters.PNGImageExporter" -> StringValue("/home/karel/FEL/ZKS/asciiart/samples/output-cloud.png"),
    "asciiart.image.exporters.BMPImageExporter" -> StringValue("/home/karel/FEL/ZKS/asciiart/samples/output-cloud.bmp"),
    "asciiart.image.exporters.GIFImageExporter" -> StringValue("/home/karel/FEL/ZKS/asciiart/samples/output-cloud.gif"),
  )
}
