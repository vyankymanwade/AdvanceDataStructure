import java.util.Scanner;

public class SubsetWithGivenSum {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }
        int sum = s.nextInt();
        int res = solve(a, a.length, sum);
        System.out.println(res);
    }

    public static int solve(int a[], int n, int sum) {
        if (n == 0)
            return (sum == 0) ? 1 : 0;
        else
            return solve(a, n - 1, sum) + solve(a, n - 1, sum - a[n-1]);
    }
}