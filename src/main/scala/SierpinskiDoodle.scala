  import doodle.core.Transform.translate
  import doodle.core._
  import doodle.image._
  import doodle.image.syntax._
  import doodle.image.syntax.core._
  import doodle.java2d._
  import doodle.java2d.effect.Frame
  import EquilateralTriangle._

  object EquilateralTriangle:
    // From https://en.wikipedia.org/wiki/Square_root_of_3:
    // The square root of 3 ...is also known as Theodorus' constant,
    // after Theodorus of Cyrene, who proved its irrationality.
    private val constantOfTheodorus: Double = Math.sqrt(3)
    // From https://en.wikipedia.org/wiki/Equilateral_triangle:
    // The altitude (height) h from any side a is √3÷2×a
    private val widthToHeightMultiplier = constantOfTheodorus / 2
    def heightFromWidth(width: Double): Double =
      widthToHeightMultiplier * width

  def fillTriangle(size: Int): Image =
    Image.triangle(width = size, height = EquilateralTriangle.heightFromWidth(size))
         .strokeColor(triangleColour)
         .fillColor(Color.red)

  def sierpinskiTriangle(size: Int): Image =
    if size <= minSize
    then fillTriangle(size)
    else
      val triangle = sierpinskiTriangle(size / 2)
      triangle above (triangle beside triangle)

  val minSize = 8
  val frameTitle = "Sierpinski's Triangle"
  val frameWidth = 660
  val frameHeight = 660
  val frameBackgroundColour = Color.white
  val frame = Frame.size(frameWidth,frameHeight).title(frameTitle).background(frameBackgroundColour)
  val triangleSize = 512
  val triangleColour = Color.red

  @main def sierpinskiWithDoodle: Unit =
    sierpinskiTriangle(triangleSize).draw(frame)