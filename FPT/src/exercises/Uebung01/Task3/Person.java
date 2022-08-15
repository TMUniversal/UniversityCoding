package exercises.Uebung01.Task3;

import java.util.Arrays;

public class Person {
  private String name;
  private int age;
  private float size;

  public Person(String name, int age, float size) {
    this.name = name;
    this.age = age;
    this.size = size;
  }

  public Person() {
    this("Max Mustermann", 22, 1.90f);
  }

  public static void main(String[] args) {
    Person[] people = new Person[2];
    people[0] = new Person();
    people[1] = new Person();
    people[1].setName("Max Planck");

    System.out.println(Arrays.toString(people));
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public float getSize() {
    return size;
  }

  public void setSize(float size) {
    this.size = size;
  }

  @Override
  public String toString() {
    return String.format("Name: %s, Age: %d, Size: %.2f", name, age, size);
  }
}
