package Task3;

public class Watermelon extends Fruit {
  public Float waterContents;

  public Watermelon(Long harvestDate, Double weight, String countryOfOrigin, Float waterContents) {
    super(harvestDate, weight, countryOfOrigin, Colour.GREEN);
    this.waterContents = waterContents;
  }

  @Override
  public boolean equals(Object obj) {
    return super.equals(obj) && waterContents.equals(((Watermelon) obj).waterContents);
  }
}
