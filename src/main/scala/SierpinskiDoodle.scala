import doodle.core.Transform.translate
import doodle.core._
import doodle.image._
import doodle.image.syntax._
import doodle.image.syntax.core._
import doodle.java2d._

def fillTri(x: Int, y: Int, size: Int): Image = {
//  val width = Math.sqrt(size * size + size * size)
//  val height = Math.sqrt(size * size - ((width / 2) * (width / 2)))
//  Image.triangle(width, height).strokeColor(Color.blue)
    Image.triangle(size,size).strokeColor(Color.red)//.fillColor(Color.red)
}

def sierpinskiTri(x: Int, y: Int, size: Int): Image =
  if size <= 32
  then fillTri(x, y, size)
  else
    val image = sierpinskiTri(x, y, size / 2)
    image above (image beside image)

@main def sierpinski: Unit =
  sierpinskiTri(50, 300, 512).draw



