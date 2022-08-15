package exercises.Uebung09.Task01Alt;

public class CabrioletFactory extends CarFactory {
  @Override
  public Car createCar() {
    return new Cabriolet();
  }
}
