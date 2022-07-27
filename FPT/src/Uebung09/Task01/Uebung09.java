package Uebung09.Task01;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Uebung09 {
  private static List<Car> carPark = new ArrayList<>();
  private static Lock carParkLock = new ReentrantLock();

  private static Condition emptyCondition = carParkLock.newCondition();
  private static Condition fullCondition = carParkLock.newCondition();

  public static void main(String[] args) {
    createRetailer();
    createRetailer();
    createProducer(new FactoryHamburg(), CarType.SUV);
    createProducer(new FactoryHamburg(), CarType.CABRIOLET);
    createProducer(new FactoryCologne(), CarType.LIMOUSINE);
  }

  public static void createRetailer() {
    new Thread(() -> {
      try {
        while (!Thread.currentThread().isInterrupted()) {
          carParkLock.lock();

          while (carPark.size() < 1) {
            System.out.println(Thread.currentThread().getName() + ": " + "Fuhrpark hat keine Wagen zum Verkauf.");

            emptyCondition.await();
          }

          Car car = carPark.get(0);
          carPark.remove(0);
          System.out.println(Thread.currentThread().getName() + ": " + car + " verkauft.");

          fullCondition.signalAll();

          carParkLock.unlock();
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }).start();
  }

  public static void createProducer(CarFactory factory, CarType type) {
    new Thread(() -> {
      try {
        while (!Thread.currentThread().isInterrupted()) {
          carParkLock.lock();

          while (carPark.size() >= 20) {
            System.out.println(Thread.currentThread().getName() + ": " + "Fuhrpark hat keine freien Plätze.");

            fullCondition.await();
          }

          Car car = factory.createCar(type);
          carPark.add(car);
          System.out.println(Thread.currentThread().getName() + ": " + car + " von " + factory + " auf den Fuhrpark geliefert.");

          emptyCondition.signalAll();

          carParkLock.unlock();

          Thread.sleep(350);
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }).start();
  }
}
