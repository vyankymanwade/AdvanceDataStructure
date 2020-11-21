import java.util.Scanner;

/*
    a[] = {1,0,1,1,1}
    o/p = 3

    a[] = {1,1,1}
    o/p   = 3

    a[] = {0 0 0 0 }
    o/p   = 0

    a[] = {1,0,1,1,1,1,0,1,1}
    o/p   = 4
*/
public class ConsecutiveOne {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }
        System.out.println("Maximum Consecutive One Naive: " + findNaive(a));
        System.out.println("Maximum Consecutive One Fast: " + findFast(a));
    }

    public static int findFast(int a[]) {
        /*
         * here instead of cheking for all element we are resetting curr count to 0 if
         * we get 0 otherwise increasing curr and updating res with max value
         */
        int n = a.length;
        int res = 0;
        int curr = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == 0)
                curr = 0;
            else {
                curr++;
                res = Integer.max(curr, res);
            }
        }
        return res;
    }

    public static int findNaive(int a[]) {
        /*
         * here for every element from that position we are checking consecutive count
         * and updating res with maximum count so Time Complexity = O(n^2)
         */
        int n = a.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int curr = 0;
            int j = i;
            while (j < n && a[j] == 1) {
                curr++;
                j++;
            }
            res = Integer.max(curr, res);
        }
        return res;
    }
}