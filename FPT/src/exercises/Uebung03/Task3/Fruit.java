package exercises.Uebung03.Task3;

public class Fruit {
  public Long harvestDate;
  public Double weight;
  public String countryOfOrigin;
  public Colour colour;

  public Fruit(Long harvestDate, Double weight, String countryOfOrigin, Colour colour) {
    this.harvestDate = harvestDate;
    this.weight = weight;
    this.countryOfOrigin = countryOfOrigin;
    this.colour = colour;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof Fruit)) {
      return false;
    }
    Fruit fruit = (Fruit) obj;
    return harvestDate.equals(fruit.harvestDate) && weight.equals(fruit.weight)
        && countryOfOrigin.equals(fruit.countryOfOrigin) && colour.equals(fruit.colour);
  }
}
