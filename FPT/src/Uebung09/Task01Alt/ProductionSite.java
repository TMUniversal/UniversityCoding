package Uebung09.Task01Alt;


public abstract class ProductionSite {
  private static final SUVFactory suvFactory = new SUVFactory();
  private static final CabrioletFactory cabrioletFactory = new CabrioletFactory();
  private static final LimousineFactory limousineFactory = new LimousineFactory();

  public Car createCar(Uebung09.Task01Alt.CarType type) {
    switch (type) {
      case SUV:
        return suvFactory.createCar();
      case CABRIOLET:
        return cabrioletFactory.createCar();
      case LIMOUSINE:
        return limousineFactory.createCar();
      default:
        throw new IllegalArgumentException();
    }
  }

  public abstract Car createCar();

  @Override
  public String toString() {
    return this.getClass().getName();
  }
}
