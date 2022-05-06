package Tutorials.W2;

import java.awt.*;
import java.awt.event.*;

public class Robot extends Frame {
  Graphics g;
  /* Offset for painting area, such that (0,0) is in the middle */
  final static int offset = 360;
  // final static int xoffset = 510;
  final static int scalefactor = 100;

  /* Constructor */
  public Robot() {
    setTitle("Picture-Drawing Tutorials.W2.Robot");
    setSize(700, 700);
    addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
  }

  private int convert(double x) {
    return new Double(offset + x * scalefactor).intValue();
  }

  private void drawL(double x1, double y1, double x2, double y2) {
    g.drawLine(convert(x1), convert(y1 * -1), convert(x2), convert(y2 * -1));
  }

  /* State of the Picture-Drawing Tutorials.W2.Robot */
  private double orientation = 0;
  private double xpos = 0;
  private double ypos = 0;
  private boolean down = false;

  /* Operations on the Tutorials.W2.Robot */
  public double orientation() {
    return orientation;
  }

  public double xpos() {
    return xpos;
  }

  public double ypos() {
    return ypos;
  }

  public void move(double x) {
    double newx, newy;
    newx = xpos + Math.cos(orientation * Math.PI / 180) * x;
    newy = ypos + Math.sin(orientation * Math.PI / 180) * x;
    if (down) {
      drawL(xpos, ypos, newx, newy);
    }
    xpos = newx;
    ypos = newy;
  }

  public void left(double x) {
    orientation += x;
    if (orientation >= 360)
      orientation -= 360;
    // System.out.println("New Orientation is: "+orientation);
  }

  public void right(double x) {
    orientation -= x;
    if (orientation < 0)
      orientation += 360;
    // System.out.println("New Orientation is: "+orientation);
  }

  public void raisepen() {
    down = false;
  }

  public void lowerpen() {
    down = true;
  }

  /*
   * In the methods below we will only make use
   * of the following methods and methods defined
   * using them.
   * - orientation()
   * - xpos()
   * - ypos()
   * - move(double x)
   * - left(double x)
   * - right(double x)
   * - raisepen()
   * - lowerpen()
   */

  /* Drawpolygon example from the lecture */
  public void drawpolygon(double size, int n) {
    lowerpen();
    for (int i = 0; i < n; i++) {
      move(size);
      left(360 / n);
    }
    raisepen();
  }

  /* Implementation of the algorithm of exercise task 3.1 (1) */
  public void changeorientation(double x) {
    orientation = x;
  }

  /* Implementation of the algorithm of exercise task 3.1 (2) */
  public void movetopoint(double x, double y) {
    if (down) drawL(xpos, ypos, x, y);
    xpos = x;
    ypos = y;
  }

  /* Implementation of the algorithm of tutorial task 2.1 */
  public void nikolaus(double x) {
    double startX = xpos;
    double startY = ypos;
    double lineLength = x;

    lowerpen();
    movetopoint(startX + lineLength, startY);
    movetopoint(startX, startY + lineLength);
    movetopoint(startX + lineLength, startY + lineLength);
    movetopoint(startX, startY);
    movetopoint(startX, startY + lineLength);

    // draw roof
    // get the roof's top point coordinates:
    // the roof is a triangle with its lower left corner at (startX, startY +
    // lineLength)
    // lower right corner at (startX + lineLength, startY + lineLength)
    // and its top point at (startX + lineLength / 2, startY + lineLength +
    // lineLength / 2)
    double roofTopX = startX + lineLength / 2;
    double roofTopY = startY + lineLength + lineLength / 2;

    movetopoint(roofTopX, roofTopY);
    movetopoint(startX + lineLength, startY + lineLength);

    movetopoint(startX + lineLength, startY);
  }

  @Override
  public void paint(Graphics g) {
    /* Initialize Tutorials.W2.Robot */
    this.g = g;
    orientation = 0;
    xpos = 0;
    ypos = 0;
    down = false;
    /* Initialize Coordinate System */
    drawL(-3.1, 0, 3.1, 0);
    drawL(0, -3.1, 0, 3.1);
    for (int i = -3; i <= 3; i++) {
      drawL(i, 0.05, i, -0.05);
      drawL(0.05, i, -0.05, i);
    }

    /*
     * Test programm, drawing one shape in each sector of
     * the coordinate system.
     */
//    movetopoint(1, 1);
//    drawpolygon(1, 5);
//
//    movetopoint(-2, 1);
//    drawpolygon(1.5, 3);
//
//    movetopoint(-2, -2);
//    drawpolygon(1.5, 4);
//
//    movetopoint(1, -2);
//    drawpolygon(1, 6);

    raisepen();
    movetopoint(0.5, 0.5);

    nikolaus(1);
  }

  public static void main(String[] args) {
    new Robot().setVisible(true);
  }
}
