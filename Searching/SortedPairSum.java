import java.util.Scanner;

/*
    given sorted array we need to find the pair with given sum
    a[] = {2 5 8 12 30 }     sum = 17        o/p = YES/true
    a[] = {3 8 13 18}        sum = 14        o/p = No/false
*/
public class SortedPairSum {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = s.nextInt();
        int sum = s.nextInt();
        System.out.println("Is Sum Available: " + isAvailable(a, sum));

    }

    public static boolean isAvailable(int a[], int sum) {
        // O(N)
        int l = 0;
        int r = a.length - 1;
        while (l < r) {
            if (a[l] + a[r] == sum)
                return true;
            if (a[l] + a[r] > sum) // here we need smaller sum so we are moving our right pointer left
                r--;
            else // here we need bigger sum so we are moving our left pointer right
                l++;
        }
        return false;
    }
}