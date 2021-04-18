import scalafx.application.JFXApp3
import scalafx.application.JFXApp3.PrimaryStage
import scalafx.geometry.Insets
import scalafx.scene.Scene
import scalafx.scene.effect.DropShadow
import scalafx.scene.layout.HBox
import scalafx.scene.paint.Color._
import scalafx.scene.paint._
import scalafx.scene.shape.{Polygon, Rectangle, TriangleMesh}
import scalafx.scene.shape.StrokeLineCap.Square
import scalafx.scene.text.Text

import scala.language.implicitConversions

object SierpinskiScalaFX extends JFXApp3 {

  override def start(): Unit = {

    stage = new PrimaryStage {
      title = "Sierpinski's Carpet"

      val triangleSide = 256.0
      val triangleHeight = Math.sqrt(triangleSide*triangleSide - (triangleSide/2.0 * triangleSide/2.0))

      val xShift = 0.0
      val yShift = 0.0

      val triangle1 = Triangle(xShift + 0, yShift + triangleHeight, triangleSide, Red)
      val triangle2 = Triangle(xShift + 0, yShift + triangleHeight, triangleSide, Red)
      val triangle3 = Triangle(xShift - triangleSide * 1.5, yShift + 0, triangleSide, Red)

      val triangles = Seq(triangle1, triangle2, triangle3)

      scene = new Scene {
        fill = White
        content = new HBox {
          padding = Insets(0, 0, 0, 0)
          children = triangles
        }
      }
    }

  }
}

object Triangle:
  def apply(x: Double, y: Double, side: Double, colour: Color): Polygon =
    val polygon = Polygon(
      0,        0,
      side/2.0, -Math.sqrt((side*side-((side/2.0)*(side/2.0)))),
      side,     0)
    polygon.fill = White
    polygon.stroke = colour
    polygon.translateX = x
    polygon.translateY = y
    polygon
