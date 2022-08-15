package exercises.Uebung07;

public class Rectangle implements Figure {
  private double width;
  private double height;
  private int x;
  private int y;

  public Rectangle(int x, int y, double width, double height) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
  }

  @Override
  public String toString() {
    return "Rectangle{" + this.x + ", " + y + " d=" + width + "x" + height + ", s=" + surface() + '}';
  }

  public void move(int x, int y) {
    this.x += x;
    this.y += y;
  }

  public double surface() {
    return this.width * this.height;
  }
}
