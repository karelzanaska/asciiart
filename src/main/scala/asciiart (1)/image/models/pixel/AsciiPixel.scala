package asciiart.image.models.pixel

case class AsciiPixel(value: Char) extends Pixel {

  override def toString: String = value.toString

}
