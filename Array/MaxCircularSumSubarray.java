import java.util.Scanner;

public class MaxCircularSumSubarray {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = s.nextInt();
        System.out.println("Maximum Circular Sum Subarray: " + solveFast(a));
        System.out.println("Maximum Circular Sum Subarray: " + solveNaive(a));
    }

    public static int solveNaive(int a[]) {
        int n = a.length;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int currSum = a[i];
            int currMax = a[i];
            for (int j = 1; j <= n; j++) {
                int index = (i + j) % n;
                currSum += a[index];
                currMax = Integer.max(currSum, currMax);
            }
            res = Integer.max(currMax, res);
        }
        return res;
    }

    public static int findNormalSum(int a[], int n) {
        // Kadane's Algorithm to find out maximum sum subarray
        int maxSum = a[0];
        int currSum = a[0];
        for (int i = 1; i < n; i++) {
            currSum = Integer.max(a[i], currSum + a[i]);
            maxSum = Integer.max(maxSum, currSum);
        }
        return maxSum;
    }

    public static int solveFast(int a[]) {
        /*
         * in order to find out max circular sum subarray we need to find out
         * max(cicularSum,normalSum)
         */
        int n = a.length;
        int maxNormalSum = findNormalSum(a, n);
        if (maxNormalSum < 0)
            return maxNormalSum;
        int arraySum = 0;
        // here we are finding the minimum sum subarrya and deleting this from array sum
        // to find out circular sum subarray
        // but little tricky way....
        // we are finding array sum and inverting array and finding max sum
        for (int i = 0; i < n; i++) {
            arraySum += a[i];
            a[i] = -a[i];
        }
        int circularSum = arraySum + findNormalSum(a, n);
        return Integer.max(circularSum, maxNormalSum);
    }
}