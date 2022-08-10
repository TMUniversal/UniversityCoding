package Uebung09.Task01Alt;

public class LimousineFactory extends CarFactory {
  @Override
  public Car createCar() {
    return new Limousine();
  }
}
