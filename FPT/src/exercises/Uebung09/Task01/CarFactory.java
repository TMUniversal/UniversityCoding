package exercises.Uebung09.Task01;

public abstract class CarFactory {
  public CarFactory() {
  }

  public Car createCar(CarType type) {
    switch (type) {
      case SUV:
        return new SUV();
      case CABRIOLET:
        return new Cabriolet();
      case LIMOUSINE:
        return new Limousine();
      default:
        throw new IllegalArgumentException();
    }
  }

  public abstract Car createCar();

  @Override
  public String toString() {
    return this.getClass().getSimpleName();
  }
}
