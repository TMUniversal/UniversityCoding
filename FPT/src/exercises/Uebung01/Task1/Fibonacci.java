package exercises.Uebung01.Task1;

public class Fibonacci {
  /**
   * Calculate the Fibonacci number with the given index. (beginning at 0)
   *
   * @param n the index of the Fibonacci number
   * @return the index'th Fibonacci number
   */
  public static long fibonacci(long n) {
    if (n == 0) return 0;
    long[] fib = new long[(int) (n + 1)];

    fib[0] = 0;
    fib[1] = 1;

    for (int i = 2; i <= n; i++) {
      fib[i] = fib[i - 1] + fib[i - 2];
    }

    return fib[(int) n];
  }

  public static void main(String[] args) {
    System.out.println(fibonacci(54));
  }
}
