package Uebung11Udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;

public class ClientUdp {
  public static void start() {
    try (DatagramSocket socket = new DatagramSocket(3001)) {

      int action = Action.LOGIN.ordinal();
      String username = "user1";
      String password = "password1";
      byte[] usernameBytes = username.getBytes(StandardCharsets.UTF_8);
      byte[] passwordBytes = password.getBytes(StandardCharsets.UTF_8);

      ByteBuffer buffer = ByteBuffer.allocate(Integer.BYTES + 1 + usernameBytes.length + 1 + passwordBytes.length);
      buffer.order(ByteOrder.BIG_ENDIAN);

      buffer.putInt(action);
      buffer.put(usernameBytes);
      buffer.put("\0".getBytes()[0]);
      buffer.put(passwordBytes);

      DatagramPacket packet = new DatagramPacket(buffer.array(), buffer.position(), InetAddress.getLocalHost(), 3000);
      socket.send(packet);

//      System.out.printf("Packet sent: %s\n", new String(packet.getData()));

      ByteBuffer recvBuffer = ByteBuffer.allocate(1024);
      recvBuffer.order(ByteOrder.BIG_ENDIAN);

      DatagramPacket p = new DatagramPacket(recvBuffer.array(), recvBuffer.array().length);
      socket.receive(p);

//      System.out.printf("Packet received: %s\n", new String(p.getData()));


      Action serverAction = Action.values()[recvBuffer.getInt()];
      String serverMsg = new String(recvBuffer.array(), 4, 1024 - 4).split("\0")[0];

      System.out.printf("Server response: %s %s\n", serverAction, serverMsg);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
