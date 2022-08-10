package Uebung09.Task01Alt;

import java.util.ArrayList;
import java.util.List;

public class Uebung09Task01Alt {
  private static final int AMOUNT_PRODUCERS = 4;
  private static final int AMOUNT_CONSUMERS = 3;

  private static final int MAX_SPOTS = 25;
  private static final List<Car> carPark = new ArrayList<>();

  public static void main(String[] args) {
    ProductionSite siteA = new ProductionSiteCologne();
    ProductionSite siteB = new ProductionSiteHamburg();
    ProductionSite siteC = new ProductionSiteMunich();

    for (int i = 0; i < AMOUNT_PRODUCERS; i++) {
      ProductionSite site = i % 2 == 0 ? siteA : (i % 3 == 0 ? siteB : siteC);
      createProducer(site, i);
    }

    for (int i = 0; i < AMOUNT_CONSUMERS; i++) {
      createRetailer(i);
    }
  }

  public static void createProducer(ProductionSite site, int n) {
    new Thread(
      null,
      () -> {
        while (!Thread.currentThread().isInterrupted()) {
          try {
            synchronized (carPark) {
              while (carPark.size() >= MAX_SPOTS) {
                System.out.println(Thread.currentThread().getName() + ": car park has no free spots");
                carPark.wait();
              }

              Car car = site.createCar(CarType.values()[(int) Math.floor(Math.random() * CarType.values().length)]);
              carPark.add(car);
              System.out.println(Thread.currentThread().getName() + ": " + car + " produced by " + site);

              carPark.notifyAll();
            }
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
        }
      },
      "Producer-" + n
    ).start();
  }

  public static void createRetailer(int n) {
    new Thread(
      null,
      () -> {
        while (!Thread.currentThread().isInterrupted()) {
          try {
            synchronized (carPark) {
              while (carPark.size() < 1) {
                System.out.println(Thread.currentThread().getName() + ": no cars available to sell.");
                carPark.wait();
              }

              Car car = carPark.get(0);
              carPark.remove(0);
              System.out.println(Thread.currentThread().getName() + ": " + car + " sold.");

              carPark.notifyAll();
            }
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
        }
      },
      "Retailer-" + n
    ).start();
  }
}
