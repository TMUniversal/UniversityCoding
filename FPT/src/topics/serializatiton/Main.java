package topics.serializatiton;

import java.awt.*;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;

public class Main {
  public static void main(String[] args) throws CloneNotSupportedException {
//    binary();
//    xml();

    Dog dog = new Dog(4, 5, 7, Color.BLUE, true, new Owner("a"));

    Dog dog2 = dog.clone();

    System.out.println(dog);
    System.out.println(dog2);

    System.out.println(dog == dog2);
    System.out.println(dog.equals(dog2));
  }

  private static void xml() {
    try (FileOutputStream fos = new FileOutputStream("dog.xml");
         XMLEncoder encoder = new XMLEncoder(fos)) {
      Dog dog = new Dog(4, 5, 6, Color.BLUE, true, new Owner("a"));

      System.out.println(dog);

      encoder.writeObject(dog);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    try (FileInputStream fis = new FileInputStream("dog.xml");
         XMLDecoder decoder = new XMLDecoder(fis)) {
      Dog dog = (Dog) decoder.readObject();

      System.out.println(dog);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private static void binary() {
    try (FileOutputStream fos = new FileOutputStream("dog.bin");
         ObjectOutputStream oos = new ObjectOutputStream(fos)) {
      Dog dog = new Dog(3, 2, 1, Color.BLACK, true, new Owner("a"));

      System.out.println(dog);

      oos.writeObject(dog);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    try (FileInputStream fis = new FileInputStream("dog.bin");
         ObjectInputStream ois = new ObjectInputStream(fis)) {
      Dog dog = (Dog) ois.readObject();

      System.out.println(dog);
    } catch (IOException | ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
}
