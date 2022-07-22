package Task3;

public class Apple extends Fruit {
  public Boolean bio;

  public Apple(Long harvestDate, Double weight, String countryOfOrigin, Boolean bio) {
    super(harvestDate, weight, countryOfOrigin, Colour.RED);
    this.bio = bio;
  }

  @Override
  public boolean equals(Object obj) {
    return super.equals(obj) && bio.equals(((Apple) obj).bio);
  }
}
