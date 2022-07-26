package Uebung07;

public class Uebung07 {
  public static void main(String[] args) {
    Circle circle = new Circle(0, 0, 1);
    Rectangle rectangle = new Rectangle(3, 4, 5, 6);

    Shape shape = new Shape();

    shape.add(circle);
    shape.add(rectangle);

    System.out.println(circle);
    System.out.println(rectangle);
    System.out.println(shape);

    shape.move(1, 1);

    System.out.println(shape);
    System.out.println(circle);

    shape.remove(circle);
    shape.move(1, 2);

    System.out.println(shape);

    Shape shape1 = new Shape();
    shape1.add(shape);
    System.out.println(shape1);

    shape1.move(-3, -2);

    System.out.println(shape1);
  }
}
