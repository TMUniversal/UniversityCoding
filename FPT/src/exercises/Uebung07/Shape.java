package exercises.Uebung07;

import java.util.HashSet;

public class Shape implements Figure {
  private final HashSet<Figure> components;

  public Shape() {
    this.components = new HashSet<>();
  }

  public void add(Figure figure) {
    this.components.add(figure);
  }

  public void remove(Figure figure) {
    this.components.remove(figure);
  }

  @Override
  public void move(int x, int y) {
    for (Figure figure : components) {
      figure.move(x, y);
    }
  }

  @Override
  public double surface() {
    return this.components.stream().map(Figure::surface).reduce(0d, (a, c) -> a += c);
  }

  @Override
  public String toString() {
    return "Shape{" +
      "s=" + surface() +
      ", components=" + components +
      '}';
  }
}
