  import doodle.core.Transform.translate
  import doodle.core._
  import doodle.image._
  import doodle.image.syntax._
  import doodle.image.syntax.core._
  import doodle.java2d._
  import doodle.java2d.effect.Frame

  def fillTri(size: Int): Image = {
  //  val width = Math.sqrt(size * size + size * size)
  //  val height = Math.sqrt(size * size - ((width / 2) * (width / 2)))
  //  Image.triangle(width, height).strokeColor(Color.blue)
      Image.triangle(size,size).strokeColor(triangleColour)//.fillColor(Color.red)
      //Image.triangle(size, size / 2.0 * Math.sqrt(3)).strokeColor(triangleColour)
      //Image.triangle(size, size * 0.866025403784439).strokeColor(triangleColour)
  }

  def sierpinskiTri(size: Int): Image =
    if size <= minSize
    then fillTri(size)
    else
      val image = sierpinskiTri(size / 2)
      image above (image beside image)

  val minSize = 128
  val title = "Sierpinsky's carpet"
  val width = 660
  val height = 660
  val backgroundColour = Color.white
  val frame = Frame.size(width,height).title(title).background(backgroundColour)
  val carpetSize = 512
  val triangleColour = Color.red

  @main def sierpinski: Unit =
    sierpinskiTri(carpetSize).draw(frame)



