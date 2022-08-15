package topics.serializatiton;

import java.awt.*;
import java.io.Serializable;
import java.util.Objects;

public class Dog implements Serializable, Cloneable {
  private static int ddd = 1;
  int age;
  int length;
  double weight;
  Color color;
  transient boolean someBoolean;

  transient char aaa = 'c';
  transient String bbb = "c";
  String ccc = null;

  Owner owner;

  public Dog() {
  }

  public Dog(int age, int length, double weight, Color color, boolean someBoolean, Owner owner) {
    this.age = age;
    this.length = length;
    this.weight = weight;
    this.color = color;
    this.someBoolean = someBoolean;
    this.owner = owner;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public int getLength() {
    return length;
  }

  public void setLength(int length) {
    this.length = length;
  }

  public double getWeight() {
    return weight;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }

  public Color getColor() {
    return color;
  }

  public void setColor(Color color) {
    this.color = color;
  }

  public boolean isSomeBoolean() {
    return someBoolean;
  }

  public void setSomeBoolean(boolean someBoolean) {
    this.someBoolean = someBoolean;
  }

  public char getAaa() {
    return aaa;
  }

  public void setAaa(char aaa) {
    this.aaa = aaa;
  }

  public String getBbb() {
    return bbb;
  }

  public void setBbb(String bbb) {
    this.bbb = bbb;
  }

  public String getCcc() {
    return ccc;
  }

  public void setCcc(String ccc) {
    this.ccc = ccc;
  }

  public Dog clone() throws CloneNotSupportedException {
    return (Dog) super.clone();
  }

  @Override
  public String toString() {
    return "Dog{" +
      "alter=" + age +
      ", laenge=" + length +
      ", gewicht=" + weight +
      ", farbe=" + color +
      ", isSkinWalker=" + someBoolean +
      ", aaa=" + aaa +
      ", bbb='" + bbb + '\'' +
      ", ccc='" + ccc + '\'' +
      ", owner=" + owner +
      '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Dog dog = (Dog) o;

    if (age != dog.age) return false;
    if (length != dog.length) return false;
    if (Double.compare(dog.weight, weight) != 0) return false;
    if (someBoolean != dog.someBoolean) return false;
    if (aaa != dog.aaa) return false;
    if (!Objects.equals(color, dog.color)) return false;
    if (!Objects.equals(bbb, dog.bbb)) return false;
    if (!Objects.equals(ccc, dog.ccc)) return false;
    return Objects.equals(owner, dog.owner);
  }

  @Override
  public int hashCode() {
    int result;
    long temp;
    result = age;
    result = 31 * result + length;
    temp = Double.doubleToLongBits(weight);
    result = 31 * result + (int) (temp ^ (temp >>> 32));
    result = 31 * result + (color != null ? color.hashCode() : 0);
    result = 31 * result + (someBoolean ? 1 : 0);
    result = 31 * result + (int) aaa;
    result = 31 * result + (bbb != null ? bbb.hashCode() : 0);
    result = 31 * result + (ccc != null ? ccc.hashCode() : 0);
    result = 31 * result + (owner != null ? owner.hashCode() : 0);
    return result;
  }
}
