package exercises.Uebung12;

public enum Operator {
  ADD("+"),
  SUBTRACT("-"),
  MULTIPLY("*"),
  DIVIDE("/");

  private final String symbol;

  Operator(String s) {
    this.symbol = s;
  }

  @Override
  public String toString() {
    return symbol;
  }
}
