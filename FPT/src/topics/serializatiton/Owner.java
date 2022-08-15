package topics.serializatiton;

import java.util.Objects;

public class Owner {
  String name;

  public Owner(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {

    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Owner owner = (Owner) o;

    return Objects.equals(name, owner.name);
  }

  @Override
  public int hashCode() {
    return name != null ? name.hashCode() : 0;
  }
}
