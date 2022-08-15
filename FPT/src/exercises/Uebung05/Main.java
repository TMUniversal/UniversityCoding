package exercises.Uebung05;

import java.awt.*;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    Car car1 = new Car(
      "Bobbert",
      new Engine(
        4,
        new ArrayList<>(Arrays.asList(
          new Piston(1),
          new Piston(1)
        ))
      ),
      new ArrayList<>(Arrays.asList(
        new Seat(Color.BLACK), new Seat(Color.BLACK), new Seat(Color.BLACK), new Seat(Color.BLACK))
      ),
      new ArrayList<>(Arrays.asList(
        new Wheel(45), new Wheel(45), new Wheel(45), new Wheel(45)
      )
      )
    );

    System.out.println(car1);

    String fileName = car1.getClass().getName();
    saveObject(car1, fileName + ".bin");
    saveObjectXml(car1, fileName + ".xml");

    Car binaryCar = loadCar(fileName + ".bin");

    System.out.println(binaryCar);
    System.out.println("car1.equals(binaryCar): " + car1.equals(binaryCar));
    assert car1.equals(binaryCar);


    Car xmlCar = loadCarXml(fileName + ".xml");

    System.out.println(xmlCar);
    System.out.println("car1.equals(xmlCar): " + car1.equals(xmlCar));
    assert car1.equals(xmlCar);
  }

  public static void saveObject(Object obj, String fileName) {
    try (FileOutputStream fos = new FileOutputStream(fileName);
         ObjectOutputStream oos = new ObjectOutputStream(fos)
    ) {
      oos.writeObject(obj);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public static void saveObjectXml(Object obj, String fileName) {
    try (FileOutputStream fos = new FileOutputStream(fileName);
         XMLEncoder encoder = new XMLEncoder(fos)) {
      encoder.writeObject(obj);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public static Car loadCar(String fileName) {
    try (FileInputStream fis = new FileInputStream(fileName);
         ObjectInputStream ois = new ObjectInputStream(fis)) {
      return (Car) ois.readObject();
    } catch (IOException | ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }

  public static Car loadCarXml(String fileName) {
    try (FileInputStream fis = new FileInputStream(fileName);
         XMLDecoder decoder = new XMLDecoder(fis)) {
      return (Car) decoder.readObject();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
