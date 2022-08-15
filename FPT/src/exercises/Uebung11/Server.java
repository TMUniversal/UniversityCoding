package exercises.Uebung11;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;

public class Server {
  private final Connection connection;

  public Server() {
    Connection connection;
    try {
      connection = DriverManager.getConnection("jdbc:sqlite:uebung11.sqlite");
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

    prepareDb(connection);
    this.connection = connection;
  }

  public static void main(String[] args) throws SQLException {
    Server server = new Server();
    server.start();
  }

  public void start() throws SQLException {
    try (ServerSocket serverSocket = new ServerSocket(3000, 50, InetAddress.getLocalHost())) {
      // for this exercise, we won't be running the server for more than one connection.
      Socket socket = serverSocket.accept();

      try (ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
           ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream())) {
        Action action;

        while ((action = (Action) ois.readObject()) != Action.CLOSE) {
          handleClientAction(ois, oos, action);
        }

        oos.flush();
        socket.close();
      } catch (ClassNotFoundException e) {
        throw new RuntimeException(e);
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    this.connection.close();
  }

  private void handleClientAction(ObjectInputStream ois, ObjectOutputStream oos, Action action) throws IOException, ClassNotFoundException {
    switch (action) {
      case LOGIN:
        User user = login((User) ois.readObject());
        if (user != null) {
          oos.writeObject(Action.LOGIN_SUCCESSFUL);
        } else {
          oos.writeObject(Action.LOGIN_UNSUCCESSFUL);
        }
        break;
      case REGISTER:
        user = (User) ois.readObject();
        User res = saveUser(user);
        if (res == null) {
          oos.writeObject(Action.REGISTER_UNSUCCESSFUL);
        } else {
          oos.writeObject(Action.REGISTER_SUCCESSFUL);
        }
        break;
    }
    oos.flush();
  }

  public User login(User user) {
    return getUser(user);
  }

  public User saveUser(User user) {
    if (existsUser(user)) return null;

    try (PreparedStatement statement = this.connection.prepareStatement(
      "INSERT INTO users (name, pass) VALUES (?, ?)"
    )) {
      statement.setString(1, user.getName());
      statement.setString(2, user.getPass());

      statement.execute();

      return user;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public User getUser(User user) {
    try (PreparedStatement statement = this.connection.prepareStatement(
      "SELECT * FROM users WHERE name = ? AND pass = ?"
    )) {
      statement.setString(1, user.getName());
      statement.setString(2, user.getPass());

      ResultSet resultSet = statement.executeQuery();
      boolean exists = resultSet.next();
      if (!exists) return null;

      resultSet.close();

      return user;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public boolean existsUser(User user) {
    try (PreparedStatement statement = this.connection.prepareStatement(
      "SELECT * FROM users WHERE name = ?"
    )) {
      statement.setString(1, user.getName());

      ResultSet resultSet = statement.executeQuery();
      boolean exists = resultSet.next();
      resultSet.close();
      return exists;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public static void prepareDb(Connection connection) {
    try (PreparedStatement statement = connection.prepareStatement(
      "CREATE TABLE IF NOT EXISTS users (name VARCHAR(255) PRIMARY KEY, pass VARCHAR(255))"
    )) {
      statement.execute();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
