import java.util.Scanner;

public class NoOfSetBit {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println("In build method: " + Integer.bitCount(n));
        System.out.println(bitCount(n));
    }

    public static int bitCount(int n) {
        int count = 0;
        while (n > 0) {
            n = (n & (n - 1));
            count++;
        }
        return count;
    }
}