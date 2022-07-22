package Uebung05;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Car extends Vehicle implements Serializable {
  private String model;
  private Engine engine;
  private List<Seat> seatList;
  private List<Wheel> wheelList;

  public Car() {
  }

  public Car(String model, Engine engine, List<Seat> seatList, List<Wheel> wheelList) {
    this.model = model;
    this.engine = engine;
    this.seatList = seatList;
    this.wheelList = wheelList;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public Engine getEngine() {
    return engine;
  }

  public void setEngine(Engine engine) {
    this.engine = engine;
  }

  public List<Seat> getSeatList() {
    return seatList;
  }

  public void setSeatList(List<Seat> seatList) {
    this.seatList = seatList;
  }

  public List<Wheel> getWheelList() {
    return wheelList;
  }

  public void setWheelList(List<Wheel> wheelList) {
    this.wheelList = wheelList;
  }

  @Override
  public String toString() {
    return "Car{" +
      "model='" + model + '\'' +
      ", engine=" + engine +
      ", seatList=" + seatList +
      ", wheelList=" + wheelList +
      '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Car car = (Car) o;

    if (!super.equals(o)) return false;
    if (!Objects.equals(model, car.model)) return false;
    if (!Objects.equals(engine, car.engine)) return false;
    if (!Objects.equals(seatList, car.seatList)) return false;
    return Objects.equals(wheelList, car.wheelList);
  }

  @Override
  public int hashCode() {
    int result = model != null ? model.hashCode() : 0;
    result = 31 * result + (engine != null ? engine.hashCode() : 0);
    result = 31 * result + (seatList != null ? seatList.hashCode() : 0);
    result = 31 * result + (wheelList != null ? wheelList.hashCode() : 0);
    return result;
  }

  private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
    System.out.println("readObject");

    this.model = (ois.readUTF());
    this.engine = (Engine) ois.readObject();

    int seatListSize = ois.readInt();
    List<Seat> seats = new ArrayList<>();
    for (int i = 0; i < seatListSize; i++) {
      seats.add((Seat) ois.readObject());
    }
    this.seatList = seats;

    int wheelListSize = ois.readInt();
    List<Wheel> wheels = new ArrayList<>();
    for (int i = 0; i < wheelListSize; i++) {
      wheels.add((Wheel) ois.readObject());
    }
    this.wheelList = wheels;

//    ois.close();
  }

  private void writeObject(ObjectOutputStream oos) throws IOException {
    System.out.println("writeObject");

    oos.writeUTF(model);
    oos.writeObject(engine);

    oos.writeInt(seatList.size());

    for (Seat seat : seatList) {
      oos.writeObject(seat);
    }

    oos.writeInt(wheelList.size());
    for (Wheel wheel : wheelList) {
      oos.writeObject(wheel);
    }

//    oos.close();
  }
}
