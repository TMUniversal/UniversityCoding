package exercises.Uebung03.Task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Calculator {
  private Boolean hasQuit = false;
  private ArrayList<Double> numbers = new ArrayList<Double>();
  private static Scanner scanner = new Scanner(System.in);

  private static void printMenu() {
    System.out.println("\n");
    System.out.println("show - show all values in the list");
    System.out.println("sum - show the sum of all values in the list");
    System.out.println("prod - show the product of all values in the list");
    System.out.println("sum and prod clear the list after showing the result");
    System.out.println("quit - quit the program");
    System.out.println("\n");
  }

  private static String getUserInput() {
    System.out.println("Enter a number to add to the list, or a command: ");
    return scanner.nextLine();
  }

  private void show() {
    System.out.println("\nThe list contains:");
    System.out.println(Arrays.toString(numbers.toArray()));
  }

  private void sum() {
    double sum = 0;
    for (double number : numbers) {
      sum += number;
    }
    System.out.println("\nThe sum of all values in the list is: " + sum);
    numbers.clear();
  }

  private void prod() {
    double prod = 1;
    for (double number : numbers) {
      prod *= number;
    }
    System.out.println("\nThe product of all values in the list is: " + prod);
    numbers.clear();
  }

  private void quit() {
    hasQuit = true;
    System.out.println("Goodbye!");
  }

  public void start(String[] args) {
    System.out.println("Welcome to the calculator!");
    // loop until user quits
    while (!hasQuit) {
      printMenu();

      String input = getUserInput();
      // try to parse the input as a number
      try {
        double number = Double.parseDouble(input);
        numbers.add(number);
      } catch (NumberFormatException e) {
        // if not a number, try to parse the input as a command
        switch (input) {
          case "show":
            show();
            break;
          case "sum":
            sum();
            break;
          case "prod":
            prod();
            break;
          case "quit":
            quit();
            break;
          default:
            System.out.println("Unknown command: " + input);
        }
      }
    }
  }

  public static void main(String[] args) {
    Calculator calc = new Calculator();
    calc.start(args);
  }
}
