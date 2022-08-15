package Uebung11Udp;

public class Uebung11Udp {
  public static void main(String[] args) throws InterruptedException {
    serverThread();
    Thread.sleep(10);
    clientThread();
  }

  private static void serverThread() {
    new Thread(ServerUdp::start).start();
  }

  private static void clientThread() {
    new Thread(ClientUdp::start).start();
  }
}
