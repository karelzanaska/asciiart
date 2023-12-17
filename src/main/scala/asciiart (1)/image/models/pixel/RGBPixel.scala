package asciiart.image.models.pixel

case class RGBPixel(red: Int, green: Int, blue: Int) extends Pixel {

  require(red >= 0 && red <= 255, "Red value must be between 0 and 255")
  require(green >= 0 && green <= 255, "Green value must be between 0 and 255")
  require(blue >= 0 && blue <= 255, "Blue value must be between 0 and 255")

  private var _grayScaleValue: Int = (red * 0.3 + green * 0.59 + blue * 0.11).toInt

  def setGrayScaleValue(value: Int) = {
    if (value < 0 || value > 255) {
      throw new IllegalArgumentException("Grayscale value must be between 0 and 255")
    }
    _grayScaleValue = value
  }
  def grayScaleValue = _grayScaleValue

}
