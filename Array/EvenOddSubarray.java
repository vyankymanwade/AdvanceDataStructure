import java.util.Scanner;

/*
    Maximum Length subarray with even-odd or odd-even sequence
    a[] = {10 12 14 7 8}        o/p = 3
    a[] = {7 10 13 14}          o/p = 4
    a[] = {10 12 8 4}           o/p = 1
*/
public class EvenOddSubarray {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }
        System.out.println("Maximum Sum Sub Array: " + findNaive(a));
        System.out.println("Maximum Sum Sub Array: " + findFast(a));
    }

    public static int findFast(int[] a) {
        int maxCount = 0;
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            if ((a[i] % 2 == 0 && a[i + 1] % 2 == 1) || (a[i] % 2 == 1 && a[i + 1] % 2 == 0))
                maxCount++;
            else
                maxCount = 0;
        }
        return maxCount + 1;
    }

    public static int findNaive(int[] a) {
        int n = a.length;
        int maxCount = 0;
        for (int i = 0; i < n - 1; i++) {
            int curr = 0;
            for (int j = i; j < n - 1; j++) {
                if ((a[j] % 2 == 0 && a[j + 1] % 2 == 1) || (a[j] % 2 == 1 && a[j + 1] % 2 == 0))
                    curr++;
                else
                    break;
            }
            maxCount = Integer.max(maxCount, curr);
        }
        return maxCount + 1;
    }
}