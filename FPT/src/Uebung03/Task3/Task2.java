package Task3;

public class Task2 {
  public static void main(String[] args) {
    Watermelon w1 = new Watermelon(15L, (double) 1.5, "A", (float) 0.3);
    Watermelon w2 = new Watermelon(15L, (double) 1.5, "A", (float) 0.3);

    System.out.println(w1 == w2);
    System.out.println(w1.equals(w2));
  }
}
