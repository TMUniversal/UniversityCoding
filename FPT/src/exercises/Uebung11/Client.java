package exercises.Uebung11;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
  public static void main(String[] args) {
    try (Socket socket = new Socket(InetAddress.getLocalHost(), 3000);
         ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
         ObjectInputStream ois = new ObjectInputStream(socket.getInputStream())) {

      Scanner scanner = new Scanner(System.in);

      System.out.print("Do you want to log in or register? <login|register> ");
      String action = scanner.nextLine();

      System.out.println("Please enter your account details");
      System.out.print("Username: ");
      String username = scanner.nextLine();
      System.out.print("Password: ");
      String password = scanner.nextLine();

      User user = new User(username, password);

      switch (action) {
        case "login":
          login(oos, user);
          break;
        case "register":
          register(oos, user);
          break;
        default:
          System.out.println("Unknown action!");
      }

      Action serverAction = (Action) ois.readObject();
      System.out.println(serverAction);

      oos.writeObject(Action.CLOSE);
      oos.flush();
    } catch (IOException | ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }

  private static void register(ObjectOutputStream oos, User user) throws IOException {
    logInOrRegister("Trying to register with username '%s' and password '%s'...\n", user, oos, Action.REGISTER);
  }

  private static void login(ObjectOutputStream oos, User user) throws IOException, ClassNotFoundException {
    logInOrRegister("Trying to log in with username '%s' and password '%s'...\n", user, oos, Action.LOGIN);
  }

  private static void logInOrRegister(String format, User user, ObjectOutputStream oos, Action action) throws IOException {
    System.out.printf(format,
      user.getName(),
      user.getPass()
    );

    oos.writeObject(action);
    oos.writeObject(user);
    oos.flush();
  }
}
