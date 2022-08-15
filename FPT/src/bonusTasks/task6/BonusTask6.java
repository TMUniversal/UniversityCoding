package bonusTasks.task6;

public class BonusTask6 {
  public static void main(String[] args) throws InterruptedException {
    Thread serverThread = new Thread(Server::start);
    Thread clientThread = new Thread(Client::start);

    serverThread.start();
    Thread.sleep(10);
    clientThread.start();
  }
}
