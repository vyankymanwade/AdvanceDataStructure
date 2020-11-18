import java.util.Scanner;

class Check {
    public static void main(String args[]) throws Exception {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        System.out.println(isSet(n, k));
    }

    public static boolean isSet(int n, int k) {
        if ((n & (1 << (k - 1))) != 0)
            return true;
        else
            return false;
    }
}