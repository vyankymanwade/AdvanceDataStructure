import java.util.Scanner;

/*
    finding any one peak element from given input array in O(logN)
*/
public class PeakElement {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = s.nextInt();
        System.out.println("peak is: " + find(a));
    }

    public static int find(int a[]) {
        int n = a.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if ((mid == 0 || a[mid - 1] <= a[mid]) && (mid == n - 1 || a[mid + 1] <= a[mid]))
                return a[mid];
            if (mid > 0 && a[mid - 1] > a[mid])
                r = mid - 1;
            else
                l = mid + 1;
        }
        return -1;
    }
}