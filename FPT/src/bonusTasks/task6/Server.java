package bonusTasks.task6;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
  private static int counter = 0;

  public static void start() {
    try (ServerSocket serverSocket = new ServerSocket(3000)) {
      while (!Thread.currentThread().isInterrupted()) {
        try (Socket socket = serverSocket.accept();
             ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream ois = new ObjectInputStream(socket.getInputStream())) {
          Action action = (Action) ois.readObject();

          switch (action) {
            case GET_VALUE:
              oos.writeInt(counter);
              oos.flush();
              break;
            case INCREMENT:
              int n = ois.readInt();
              counter += n;
              break;
            case QUIT:
              Thread.currentThread().interrupt();
              break;
          }
        } catch (ClassNotFoundException e) {
          throw new RuntimeException(e);
        }
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
