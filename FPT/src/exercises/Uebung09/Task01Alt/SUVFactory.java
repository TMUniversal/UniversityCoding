package exercises.Uebung09.Task01Alt;

public class SUVFactory extends CarFactory {
  @Override
  public Car createCar() {
    return new SUV();
  }
}
