import java.util.Scanner;

/*
    given the sorted rotated array we need to find out index of given element
    a[] = {100 200 400 1000 10 20}      k = 20      o/p = 5
    a[] = {100 500 10 20 30 40 50}      k = 500     o/p = 1
*/
public class SortedRotatedArray {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = s.nextInt();
        int k = s.nextInt();
        System.out.println("Index Of " + k + " is :" + findIndex(a, k));
    }

    /*
     * Idea here is : there is always one sorted side after finding middle element
     * using binary search in check which side is sorted and also check whether
     * required element lies in that range if it is apply binary search on that half
     * otherwise apply on other
     */
    public static int findIndex(int a[], int k) {
        int l = 0;
        int r = a.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (a[mid] == k)
                return mid;
            if (a[l] < a[mid]) {
                if (k >= a[l] && k <= a[mid])
                    r = mid - 1;
                else
                    l = mid + 1;
            } else {
                if (k >= a[mid] && k <= a[r])
                    l = mid + 1;
                else
                    r = mid - 1;
            }
        }
        return -1;
    }
}