package exercises.exercise10;

import java.util.HashMap;
import java.util.Objects;

/**
 * The following class shall provide a library for sorting algorithms
 */
public class Sorting {
  /**
   * The method ordered checks if a given array is ordered.
   * The ordering is given by the Comparable interface of Java.
   */
  public <T extends Comparable<? super T>> boolean ordered(T[] a) {
    for (int i = 0; i < a.length - 1; i++) {
      if (a[i].compareTo(a[i + 1]) > 0) return false;
    }
    return true;
  }


  /**
   * The method checks if two given arrays are permutations of each other.
   */
  public <T extends Comparable<? super T>> boolean permutation(T[] a, T[] b) {
    if (a.length != b.length) return false;

    HashMap<T, Integer> mapA, mapB;
    mapA = new HashMap<>();
    mapB = new HashMap<>();

    for (int i = 0; i < a.length; i++) {
      mapA.put(a[i], 0);
      mapB.put(b[i], 0);
    }

    for (int i = 0; i < a.length; i++) {
      mapA.put(a[i], mapA.get(a[i]) + 1);
      mapB.put(b[i], mapB.get(b[i]) + 1);
    }

    for (int i = 0; i < mapA.size(); i++) {
      if (!Objects.equals(mapA.get(a[i]), mapB.get(a[i]))) return false;
    }

    return true;
  }


  /**
   * This method implements bubble sort
   */
  public <T extends Comparable<? super T>> void bubbleSort(T[] a) {
    while (!ordered(a)) {
      for (int i = 0; i < a.length - 1; i++) {
        if (a[i].compareTo(a[i + 1]) > 0) {
          T temp = a[i];
          a[i] = a[i + 1];
          a[i + 1] = temp;
        }
      }
    }
  }

  /**
   * This method implements insertion sort
   */
  public <T extends Comparable<? super T>> void insertionSort(T[] a) {
    for (int i = 1; i < a.length; i++) {
      // find the space for the current number a[i]
      int targetIndex = 0;
      for (int j = 0; j <= i; j++) {
        if (a[i].compareTo(a[j]) > 0) targetIndex++;
      }

      T element = a[i];

      // move following indices out of the way
      for (int j = i; j > targetIndex; j--) {
        a[j] = a[j - 1];
      }

      a[targetIndex] = element;
    }
  }

  /**
   * This method implements selection sort
   */
  public <T extends Comparable<? super T>> void selectionSort(T[] a) {
    for (int i = 0; i < a.length; i++) {
      // find the index of the minimal element in the unsorted part of the array (i..length)
      int minIndex = i;
      for (int j = i; j < a.length; j++) {
        if (a[minIndex].compareTo(a[j]) >= 0) minIndex = j;
      }

      // swap the *current* and the minimal element
      T temp = a[i];
      a[i] = a[minIndex];
      a[minIndex] = temp;
    }
  }


  /**
   * Test the implementations of bubblesort, insertionsort and selectionsort using the array a
   */
  public <T extends Comparable<? super T>> void sortTester(T[] a) {
    //Clone the given array to memorize before state
    T[] b = a.clone();

    System.out.println("Bubblesort " + arrayToString(a));
    bubbleSort(a);
    System.out.println(arrayToString(a) + " is" + (ordered(a) ? "" : " not") + " ordered");
    System.out.println(arrayToString(a) + " is" + (permutation(a, b) ? "" : " not") + " a permutation of " + arrayToString(b));

    a = b.clone();
    System.out.println("Insertionsort " + arrayToString(a));
    insertionSort(a);
    System.out.println(arrayToString(a) + " is" + (ordered(a) ? "" : " not") + " ordered");
    System.out.println(arrayToString(a) + " is" + (permutation(a, b) ? "" : " not") + " a permutation of " + arrayToString(b));

    a = b.clone();
    System.out.println("Selectionsort " + arrayToString(a));
    selectionSort(a);
    System.out.println(arrayToString(a) + " is" + (ordered(a) ? "" : " not") + " ordered");
    System.out.println(arrayToString(a) + " is" + (permutation(a, b) ? "" : " not") + " a permutation of " + arrayToString(b));
  }

  /**
   * The method randomIntegerArray returns an integer array with size n and randomly chosen integer values.
   */
  private Integer[] randomIntegerArray(int n) {
    assert n >= 1 : "Precondition of randomIntegerArray not satisfied";
    Integer[] r = new Integer[n];
    for (int i = 0; i < n; i++)
      r[i] = new Double((Math.random() * 10000) % 100).intValue();
    return r;
  }

  /**
   * The method arrayToString returns a String representation of the array a
   */
  private String arrayToString(Object[] a) {
    String r = "[";
    if (a.length > 0)
      r += a[0];
    for (int i = 1; i < a.length; i++)
      r += ", " + a[i];
    r += "]";
    return r;
  }

  /**
   * The main method initiates the test
   */
  public static void main(String[] args) {
    Sorting s = new Sorting();
    Integer[] a1 = {5, 4, 3, 2, 1};
    Integer[] a2 = {2, 1, 2, 2, 1};
    Integer[] a3 = s.randomIntegerArray(10);
    String[] s1 = {"Apfel", "Apfelsine", "Orange", "Banane"};
    //The first paragraph of the preface of the CSP book of C.A.R. Hoare
    String[] s2 = {"This", "is", "a", "book", "for", "the", "aspiring", "programmer", "the",
      "programmer", "who", "aspires", "to", "greater", "understanding", "and",
      "skill", "in", "the", "practice", "of", "an", "intellectually",
      "demanding", "profession", "It", "is", "designed", "to", "appeal",
      "first", "to", "a", "natural", "sense", "of", "curiosity", "which", "is",
      "aroused", "by", "a", "new", "approach", "to", "a", "familiar", "topic",
      "The", "approach", "is", "illustrated", "by", "a", "host", "of",
      "examples", "drawn", "from", "a", "wide", "range", "of", "applications",
      "from", "vending", "machines", "through", "fairy", "stories", "and",
      "games", "to", "computer", "operating", "systems", "The", "treatment",
      "is", "based", "on", "a", "mathematical", "theory", "which", "is",
      "described", "by", "a", "systematic", "collection", "of", "algebraic",
      "laws"};
    s.sortTester(a1);
    System.out.println();
    s.sortTester(a2);
    System.out.println();
    s.sortTester(a3);
    System.out.println();
    s.sortTester(s1);
    System.out.println();
    s.sortTester(s2);

  }

}
