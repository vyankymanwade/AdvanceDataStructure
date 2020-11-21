import java.util.Scanner;

/*
    Maximum Sum of Subarray
    a[] = {2,3,-8,7,-1,2,3}     o/p = 11
    a[] = {5,8,3}               o/p = 16
    a[] = {-6,-1,-8}            o/p = -1
*/

public class MaxSumSubarray {

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

    public static int findNaive(int a[]) {
        // here we are checking for every sub array
        int maxSum = Integer.MIN_VALUE;
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int curr = 0;
            for (int j = i; j < n; j++) {
                curr += a[j];
                maxSum = Integer.max(maxSum, curr);
            }
        }
        return maxSum;
    }

    public static int findFast(int a[]) {
        // here we are pre computing sum of subarray till that index i
        // a[] = 2,3,-8,7,-1,2,3
        // maxEnding[] = 2 5 -3 7 6 8 11
        int maxSum = Integer.MIN_VALUE;
        int n = a.length;
        int maxEnding[] = new int[n];
        maxEnding[0] = a[0];
        for (int i = 1; i < n; i++) {
            maxEnding[i] = Integer.max(maxEnding[i - 1] + a[i], a[i]);
            maxSum = Integer.max(maxSum, maxEnding[i]);
        }
        return maxSum;
    }
}