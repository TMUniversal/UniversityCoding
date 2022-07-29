package exercises.exercise05;

public class LCD {
  /**
   * Find the least common multiple of two numbers
   *
   * @param n first number
   * @param m second number
   * @return least common multiple of n and m
   */
  public static int lcd(int n, int m) {
    int i = 1, leastCommonMultiple = n * m;
    while (leastCommonMultiple - i >= Math.max(n, m)) {
      if ((leastCommonMultiple - i) % n == 0 && (leastCommonMultiple - i) % m == 0) {
        leastCommonMultiple = leastCommonMultiple - i;
      }
      i++;
    }

    return leastCommonMultiple;
  }

  public static void main(String[] args) {
    System.out.println("lcd(50, 40) = " + lcd(50, 40));
    System.out.println("lcd(8, 2) = " + lcd(8, 2));
  }
}
