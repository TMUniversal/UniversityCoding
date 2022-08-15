package exercises.Uebung09.Task02;

import java.util.concurrent.*;

public class Uebung09Task02 {
  private static ExecutorService exec = Executors.newCachedThreadPool();

  public static void main(String[] args) {
    Future<Food> foodFuture = order();

    System.out.println(Thread.currentThread().getName() + ": " + "I've ordered some food!");

    int waitTime = 800;

    try {
      while (!foodFuture.isDone()) {
        System.out.println(Thread.currentThread().getName() + ": " + "Not yet done... I'll check again in " + (waitTime / 1000d) + "s");
        Thread.sleep(waitTime);
      }

      Food food = foodFuture.get();
      System.out.println(Thread.currentThread().getName() + ": " + "It's ready! " + food);
    } catch (InterruptedException | ExecutionException e) {
      throw new RuntimeException(e);
    }

    exec.shutdown();
  }

  public static Future<Food> order() {
    Callable<Food> c = () -> {
      for (int i = 1; i <= 5; i++) {
        System.out.println(Thread.currentThread().getName() + ": " + "Working on your order! (" + (i - 1) + " seconds elapsed)");
        Thread.sleep(1000);
      }
      return new Food();
    };

    return exec.submit(c);
  }
}
