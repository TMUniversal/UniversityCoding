package exercises.Uebung09.Task01;

public class FactoryCologne extends CarFactory {
  public FactoryCologne() {
  }

  @Override
  public Car createCar() {
    return createCar(CarType.SUV);
  }
}
