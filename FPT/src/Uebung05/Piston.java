package Uebung05;

import java.io.Serializable;

public class Piston implements Serializable {
  private float thickness;

  public Piston() {}

  public Piston(float thickness) {
    this.thickness = thickness;
  }

  public float getThickness() {
    return thickness;
  }

  public void setThickness(float thickness) {
    this.thickness = thickness;
  }

  @Override
  public String toString() {
    return "Piston{" +
      "thickness=" + thickness +
      '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Piston piston = (Piston) o;

    return Float.compare(piston.thickness, thickness) == 0;
  }

  @Override
  public int hashCode() {
    return (thickness != 0.0f ? Float.floatToIntBits(thickness) : 0);
  }
}
