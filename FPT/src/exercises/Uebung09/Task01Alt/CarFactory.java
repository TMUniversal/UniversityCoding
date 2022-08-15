package exercises.Uebung09.Task01Alt;

public abstract class CarFactory {
  public abstract Car createCar();

  @Override
  public String toString() {
    return this.getClass().getSimpleName();
  }
}
