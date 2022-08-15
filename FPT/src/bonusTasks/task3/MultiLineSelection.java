package bonusTasks.task3;

import java.util.HashSet;
import java.util.Set;

public class MultiLineSelection implements Selection {
  private final Set<LineSelection> lines = new HashSet<>();

  public void add(LineSelection lineSelection) {
    this.lines.add(lineSelection);
  }

  public void remove(LineSelection lineSelection) {
    this.lines.remove(lineSelection);
  }

  @Override
  public void delete() {

  }
}
