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
   * Implementation of Task 4.1.
   *
   * @param n the number to start the search from
   * @return the smallest prime number greater than n
   */
  private static int nextPrime(int n) {
    int nextPrime = n + 1;
    while (!isPrime(nextPrime)) {
      nextPrime++;
    }
    return nextPrime;
  }

  public static void main(String[] args) {
    System.out.println("nextPrime(8) = " + nextPrime(8));
  }
}
