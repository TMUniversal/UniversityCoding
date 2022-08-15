package bonusTasks.task4;

import java.util.ArrayList;
import java.util.List;

import static util.Util.threadPrintln;

public class BonusTask4 {
  private static final List<Visitor> eventLocation = new ArrayList<>();
  private static int MAX_VISITORS = 300;

  public static void main(String[] args) {
    for (int i = 0; i < 4; i++) {
      createEntrance(i);
    }
    for (int i = 0; i < 4; i++) {
      createExit(i);
    }
  }

  private static void createEntrance(int n) {
    new Thread(
      null,
      () -> {
        try {
          while (!Thread.currentThread().isInterrupted()) {
            synchronized (eventLocation) {
              while (eventLocation.size() >= MAX_VISITORS) {
                threadPrintln("The location has no space for additional visitors.");
                eventLocation.wait();
              }

              eventLocation.add(new Visitor());
              threadPrintln("New visitor has entered the location.");
              eventLocation.notifyAll();
            }
          }
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      },
      "Entrance-" + n
    ).start();
  }

  private static void createExit(int n) {
    new Thread(
      null,
      () -> {
        try {
          while (!Thread.currentThread().isInterrupted()) {
            synchronized (eventLocation) {
              while (eventLocation.isEmpty()) {
                threadPrintln("No visitors to exit.");
                eventLocation.wait();
              }

              eventLocation.remove(0);
              threadPrintln("Visitor has left the location.");
              eventLocation.notifyAll();
            }
          }
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      },
      "Exit-" + n
    ).start();
  }
}
