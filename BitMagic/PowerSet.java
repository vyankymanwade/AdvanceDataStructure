import java.util.Scanner;

public class PowerSet {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        String str = s.next();
        findPowerSet(str);
    }

    public static void findPowerSet(String s) {
        int n = (int) Math.pow(2, s.length());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < s.length(); j++) {
                if ((i & (1 << j)) != 0)
                    System.out.print(s.charAt(j));
            }
            System.out.print(" ");
        }
    }
}