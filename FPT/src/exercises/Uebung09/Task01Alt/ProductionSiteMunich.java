package exercises.Uebung09.Task01Alt;


public class ProductionSiteMunich extends ProductionSite {
  @Override
  public Car createCar() {
    return createCar(CarType.LIMOUSINE);
  }
}
