public class NatSum {
  public static void main(String[] args) {
    int sum = 0;
    String ret = "";
    for (int i = 1; i < Integer.parseInt(args[0]) + 1; i++) {
      if (ret != "") {
        ret += " + " + String.valueOf(i);
      } else {
        ret += String.valueOf(i);
      }
      sum += i;
    }

    ret += " = " + String.valueOf(sum);

    System.out.println(ret);
  }
}
