package bonusTasks.task6;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
  public static void start() {
    Scanner scanner = new Scanner(System.in);
    String input;

    System.out.print("Please enter a command (get/inc/quit): ");
    while (!(input = scanner.nextLine()).equals("quit")) {
      switch (input) {
        case "inc":
          System.out.print("Increment by which amount: ");
          String i = scanner.nextLine();

          if (!i.trim().matches("\\d+")) {
            System.out.println("Amount must be a number!");
            continue;
          }

          int n = Integer.parseInt(i.trim());

          incrementCounter(n);
          System.out.println("Incremented by " + n);
          break;
        case "get":
          System.out.println("Current value is: " + getCounterValue());
          break;
        default:
          System.out.println("Unknown command");
      }
    }

    sendQuit();
  }

  private static int getCounterValue() {
    try (Socket socket = new Socket(InetAddress.getLocalHost(), 3000);
         ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
         ObjectInputStream ois = new ObjectInputStream(socket.getInputStream())) {
      oos.writeObject(Action.GET_VALUE);
      oos.flush();

      return ois.readInt();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private static void incrementCounter(int amount) {
    try (Socket socket = new Socket(InetAddress.getLocalHost(), 3000);
         ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream())) {
      oos.writeObject(Action.INCREMENT);
      oos.writeInt(amount);
      oos.flush();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private static void sendQuit() {
    try (Socket socket = new Socket(InetAddress.getLocalHost(), 3000);
         ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream())) {
      oos.writeObject(Action.QUIT);
      oos.flush();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
