package Uebung05;

import java.awt.*;
import java.io.Serializable;
import java.util.Objects;

public class Seat implements Serializable {
  private Color color;

  public Seat() {
  }

  public Seat(Color color) {
    this.color = color;
  }

  public Color getColor() {
    return color;
  }

  public void setColor(Color color) {
    this.color = color;
  }

  @Override
  public String toString() {
    return "Seat{" +
      "color=" + color +
      '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Seat seat = (Seat) o;

    return Objects.equals(color, seat.color);
  }

  @Override
  public int hashCode() {
    return color != null ? color.hashCode() : 0;
  }
}
