package exercises.Uebung05;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Engine implements Serializable {
  private double size;
  private List<Piston> pistonList;

  public Engine() {
  }

  public Engine(double size, List<Piston> pistonList) {
    this.size = size;
    this.pistonList = pistonList;
  }

  public double getSize() {
    return size;
  }

  public void setSize(double size) {
    this.size = size;
  }

  public List<Piston> getPistonList() {
    return pistonList;
  }

  public void setPistonList(List<Piston> pistonList) {
    this.pistonList = pistonList;
  }

  @Override
  public String toString() {
    return "Engine{" +
      "size=" + size +
      ", pistonList=" + pistonList +
      '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Engine engine = (Engine) o;

    if (Double.compare(engine.size, size) != 0) return false;
    return Objects.equals(pistonList, engine.pistonList);
  }

  @Override
  public int hashCode() {
    int result;
    long temp;
    temp = Double.doubleToLongBits(size);
    result = (int) (temp ^ (temp >>> 32));
    result = 31 * result + (pistonList != null ? pistonList.hashCode() : 0);
    return result;
  }
}
