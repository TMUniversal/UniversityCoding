package exercises.Uebung11Udp;

import exercises.Uebung11.User;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.sql.*;

public class ServerUdp {
  public static void start() {
    try (DatagramSocket socket = new DatagramSocket(3000);
         Connection connection = DriverManager.getConnection("jdbc:sqlite:uebung11.sqlite")) {
      ByteBuffer recvBuffer = ByteBuffer.allocate(1024);
      DatagramPacket recvPacket = new DatagramPacket(recvBuffer.array(), recvBuffer.array().length);
      socket.receive(recvPacket);

//      System.out.printf("Packet received: %s\n", new String(recvPacket.getData()));

      Action clientAction = Action.values()[recvBuffer.getInt()];
      String clientMsg = new String(recvBuffer.array(), 4, 1024 - 4);
      String[] s = clientMsg.split("\0");
      String username = s[0];
      String password = s[1];

      System.out.printf("Client message: %s; user: %s; pass: %s\n", clientAction.name(), username, password);

      ByteBuffer buffer = ByteBuffer.allocate(1024);

      User user = getUser(connection, username);
      if (user == null) {
        buffer.putInt(Action.LOGIN_UNSUCCESSFUL.ordinal());
        buffer.put("No user with that username".getBytes());
      } else if (user.getPass().equals(password)) {
        buffer.putInt(Action.LOGIN_SUCCESSFUL.ordinal());
        buffer.put("You've logged in.".getBytes());
      } else {
        buffer.putInt(Action.LOGIN_UNSUCCESSFUL.ordinal());
        buffer.put("Wrong password.".getBytes());
      }

      DatagramPacket packet = new DatagramPacket(buffer.array(), buffer.position(), InetAddress.getLocalHost(), 3001);
      socket.send(packet);
//      System.out.printf("Packet sent: %s\n", new String(packet.getData()));
    } catch (IOException | SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public static User getUser(Connection connection, String username) {
    try (PreparedStatement statement = connection.prepareStatement(
      "SELECT * FROM users WHERE name = ?"
    )) {
      statement.setString(1, username);
      ResultSet resultSet = statement.executeQuery();

      if (!resultSet.next()) return null;

      return new User(resultSet.getString("name"), resultSet.getString("pass"));
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
