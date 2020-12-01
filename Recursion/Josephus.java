import java.util.Scanner;

class Josephus {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        System.out.println("with start index 0: " + josephus0(n, k));
        System.out.println("with start index 1: " + (josephus0(n, k) + 1));
    }

    public static int josephus0(int n, int k) {
        if (n == 1)
            return 0;
        else
            return (josephus0(n - 1, k) + k) % n;
    }
}