package Uebung05;

import java.io.Serializable;

public abstract class Vehicle implements Serializable {
  private int id;

  public Vehicle() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "Vehicle{" +
      "id=" + id +
      '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Vehicle vehicle = (Vehicle) o;

    return id == vehicle.id;
  }

  @Override
  public int hashCode() {
    return id;
  }
}
