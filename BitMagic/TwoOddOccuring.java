import java.util.Scanner;

public class TwoOddOccuring {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }
        find(a);
    }

    // a[] = {3 4 3 4 5 4 4 6 7 7}
    public static void find(int a[]) {
        int xor = 0, n1 = 0, n2 = 0;
        // after this loop xor variable will contain xor of required two element i.e 5^6
        for (int i = 0; i < a.length; i++) {
            xor = xor ^ a[i];
        }
        int setBit = xor & ~(xor - 1); // this will gives us rightmost set bit for xor variable

        // after this loop element will divided into two groups according to set
        // bit such that one
        // contain first odd element another contain second
        for (int i = 0; i < a.length; i++) {
            if ((a[i] & setBit) != 0)
                n1 = n1 ^ a[i];
            else
                n2 = n2 ^ a[i];
        }
        System.out.println(n1 + " " + n2);
    }
}