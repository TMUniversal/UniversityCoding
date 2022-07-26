package Uebung07;

public class Circle implements Figure {
  private int x;
  private int y;
  private double radius;

  public Circle(int x, int y, double radius) {
    this.x = x;
    this.y = y;
    this.radius = radius;
  }

  @Override
  public void move(int x, int y) {
    this.x += x;
    this.y += y;
  }

  @Override
  public double surface() {
    return Math.PI * radius * radius;
  }

  @Override
  public String toString() {
    return "Circle{" + this.x + ", " + this.y + ", r=" + radius + ", s=" + surface() + '}';
  }
}
