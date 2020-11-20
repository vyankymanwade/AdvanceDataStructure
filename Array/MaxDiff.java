import java.util.Scanner;

class MaxDiff {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }
        System.out.println("Max Difference: " + findMaxDiffNaive(a));
        System.out.println("Max Difference: " + findMaxDiffFast(a));
    }

    public static int findMaxDiffFast(int a[]) { // O(n)
        int n = a.length;
        int maxDiff = a[1] - a[0];
        int minVal = a[0];
        for (int j = 1; j < n; j++) {
            maxDiff = Integer.max(maxDiff, a[j] - minVal);
            minVal = Integer.min(minVal, a[j]);
        }
        return maxDiff;
    }

    public static int findMaxDiffNaive(int a[]) { // O(n^2)
        int n = a.length;
        int max = a[1] - a[0];
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                max = Integer.max(max, a[j] - a[i]);
            }
        }
        return max;
    }
}