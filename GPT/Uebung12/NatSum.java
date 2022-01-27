public class NatSum {
    public static void main(String[] args) {
        int sum = 0;

        for (int i = 1; i < Integer.parseInt(args[0]) + 1; i++) {
            sum += i;
        }

        System.out.println(sum);
    }
}
