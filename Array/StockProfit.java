
/*
    a[] = {1,5,3,8,12}
    o/p = 13

    a[] = {30.20.10}
    o/p = 0

    a[] = {1,5,3,1,2,8}
    o/p = 11             explaination: buy 0 index sell 1 index  profit = 5-1 = 4
                                       buy 3 index sell 5 index  profit = 8-1 = 7
                                       Total maxProfit = 4+7 = 11
*/
import java.util.*;

public class StockProfit {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }
        System.out.println("Max Profit: " + maxProfitNaive(a, 0, n - 1));
        System.out.println("Max Profit: " + maxProfitFast(a, 0, n));
    }

    public static int maxProfitFast(int a[], int start, int n) {
        // we buy stock when price at lowest value and sell it at highest peak
        // so we check if price is increasing we add it to profit
        int maxProfit = 0;
        for (int i = 1; i < n; i++) {
            if (a[i] > a[i - 1]) {
                maxProfit += (a[i] - a[i - 1]);
            }
        }
        return maxProfit;
    }

    public static int maxProfitNaive(int a[], int start, int end) {
        if (start >= end)
            return 0;
        int maxProfit = 0;
        for (int i = start; i < end; i++) {
            for (int j = i + 1; j <= end; j++) {
                if (a[j] > a[i]) {
                    // calling maxProfit for less than i and for greater than j
                    int currentProfit = a[j] - a[i] + maxProfitNaive(a, start, i - 1) + maxProfitNaive(a, j + 1, end);
                    maxProfit = Integer.max(currentProfit, maxProfit);
                }
            }
        }
        return maxProfit;
    }
}