public class Multi {
    public static void main(String[] args) {
        String ret = "";

        for (int i = 0; i < Integer.parseInt(args[1]); i++) {
            ret += args[0];
        }

        System.out.println(ret);
    }
}
