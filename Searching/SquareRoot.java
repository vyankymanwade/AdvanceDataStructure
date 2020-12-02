import java.util.Scanner;

/*
    find square root of given number without using Sqrt function
    if number is not perfect square then print floor value
    n = 9       o/p = 3
    n = 15      o/p = 3
*/
public class SquareRoot {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println("root is : " + findNaive(n));
        System.out.println("root is : " + find(n));
    }

    public static int findNaive(int n) {
        int i = 1;
        while (i * i <= n) {
            i++;
        }
        return i - 1;
    }

    public static int find(int n) {
        int res = -1;
        int l = 1, r = n;
        while (l <= r) {
            int mid = (l + r) / 2;
            int midSq = mid * mid;
            if (midSq == n)
                return mid;
            else if (midSq > n)
                r = mid - 1;
            else {
                l = mid + 1;
                res = mid;
            }
        }
        return res;
    }
}