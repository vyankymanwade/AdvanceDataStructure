import java.util.Scanner;

class PowerOfTwo {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(isPowerOf2(n));
        System.out.println("naive: " + naive(n));
        System.out.println("Best Sol: " + best(n));
    }

    public static boolean best(int n) {
        // if number is ZERO return false
        // number is power of 2 iff there is only one bit set so here we are cheking
        // if we switch off 1 bit and it turns 0 then only one bit is set
        return ((n != 0) && (n & (n - 1)) == 0);
    }

    public static boolean naive(int n) {
        /*
         * dividing number until it turns one if we get ODD Number at any time then it
         * is not power of two so we returns false
         */
        while (n != 1) {
            if (n % 2 != 0)
                return false;
            n = n / 2;
        }
        return true;
    }

    public static boolean isPowerOf2(int n) {
        // only checking if only ONE BIT IS SET then it is Power Of Two
        if (n == 0)
            return false;
        if (count(n) == 1)
            return true;
        else
            return false;
    }

    public static int count(int n) {
        int count = 0;
        while (n > 0) {
            n = (n & (n - 1));
            count++;
        }
        return count;
    }
}