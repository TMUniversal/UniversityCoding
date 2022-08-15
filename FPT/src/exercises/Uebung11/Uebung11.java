package exercises.Uebung11;

import java.sql.SQLException;

public class Uebung11 {
  public static void main(String[] args) {
    startServerThread();

    Client.main(null);
  }

  public static void startServerThread() {
    new Thread(() -> {
      Server server = new Server();
      try {
        server.start();
      } catch (SQLException e) {
        throw new RuntimeException(e);
      }
    }).start();
  }
}
