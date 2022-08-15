package util;

public class Util {
  public static void threadPrint(String msg) {
    System.out.print(Thread.currentThread().getName() + ": " + msg);
  }

  public static void threadPrintln(String msg) {
    threadPrint(msg + "\n");
  }
}
