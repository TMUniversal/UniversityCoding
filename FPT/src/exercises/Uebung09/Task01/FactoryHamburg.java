package exercises.Uebung09.Task01;

public class FactoryHamburg extends CarFactory {
  @Override
  public Car createCar() {
    return createCar(CarType.CABRIOLET);
  }
}
