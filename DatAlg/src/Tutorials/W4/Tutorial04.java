package Tutorials.W4;

public class Tutorial04 {
  private static boolean isPrime(int n) {
    if (n == 2) {
      return true;
    }
    if (n % 2 == 0) {
      return false;
    }
    for (int i = 3; i * i <= n; i += 2) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }

  /**
   * Implementation of Task 4.1.1.
   *
   * @param n the number to start the search from
   * @return the smallest prime number greater than n
   */
  private static int nextPrime(int n) {
    if (n < 0) {
      throw new IllegalArgumentException("n must be non-negative");
    }
    int nextPrime = n + 1;
    while (!isPrime(nextPrime)) {
      nextPrime++;
    }
    return nextPrime;
  }

  /**
   * Implementation of Task 4.1.2.
   *
   * @param a the first number
   * @param b the second number
   * @return the greatest common divisor of a and b
   */
  private static int GCD(int a, int b) {
    if (a < 0 || b < 0) {
      throw new IllegalArgumentException("a and b must be non-negative");
    }
    /*
        recursive solution
        if (b == 0) {
          return a;
        }
        return GCD(b, a % b);
    */

    while (b != 0) {
      int temp = a % b;
      a = b;
      b = temp;
    }
    return a;
  }

  /**
   * Implementation of Task 4.1.3.
   *
   * @param base     the base of the number
   * @param exponent the exponent of the number
   * @return base^exponent
   */
  private static int power(int base, int exponent) {
    int result = 1;
    for (int i = 0; i < exponent; i++) {
      result *= base;
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println("nextPrime(8) = " + nextPrime(8));
    System.out.println("GCD(24, 9) = " + GCD(24, 9));
    System.out.println("power(2, 3) = " + power(2, 3));
  }
}
