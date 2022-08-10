package Uebung09.Task01Alt;


public class ProductionSiteHamburg extends ProductionSite {
  @Override
  public Car createCar() {
    return createCar(CarType.SUV);
  }
}
