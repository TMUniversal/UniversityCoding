package exercises.Uebung09.Task01Alt;

public class ProductionSiteCologne extends ProductionSite {
  @Override
  public Car createCar() {
    return createCar(CarType.CABRIOLET);
  }
}
