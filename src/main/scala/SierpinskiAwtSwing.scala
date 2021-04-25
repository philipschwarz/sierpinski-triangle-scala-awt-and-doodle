import java.awt.*;
import javax.swing.*;

object SierpinskiAwtSwing extends JPanel:

  override def paintComponent(g: Graphics): Unit =
    val x = Array(50,100,0)
    val y = Array(0,100,100)
    g.drawPolygon(x, y, 3)

@main def drawTriangle: Unit =
  JFrame.setDefaultLookAndFeelDecorated(true)
  val frame: JFrame = new JFrame("Sierpinski")
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
  frame.setBackground(Color.white);
  frame.setSize(300, 200);

  frame.add(SierpinskiAwtSwing);
  frame.setVisible(true)