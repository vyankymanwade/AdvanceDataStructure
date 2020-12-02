import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class LastOccuranceIndex {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }
        int k = s.nextInt();
        System.out.println("index of " + k + " is : " + findIndexUsingInbuild(a, k));
        System.out.println("index of " + k + " is : " + binaryFindRecursive(a, 0, n - 1, k));
        System.out.println("index of " + k + " is : " + binaryFindIterative(a, k));
    }

    public static int findIndexUsingInbuild(int a[], int k) {
        List<Integer> al = new ArrayList<Integer>();
        for (Integer i : a)
            al.add(i);
        return al.lastIndexOf(k);
    }

    public static int binaryFindIterative(int a[], int k) {
        int l = 0;
        int r = a.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (k < a[mid])
                r = mid - 1;
            else if (k > a[mid])
                l = mid + 1;
            else {
                if (mid == a.length - 1 ||a[mid + 1] != k)
                    return mid;
                else
                    l = mid + 1;
            }
        }
        return -1;
    }

    public static int binaryFindRecursive(int a[], int l, int r, int k) {
        if (l > r)
            return -1;
        int mid = (l + r) / 2;
        if (k < a[mid])
            return binaryFindRecursive(a, l, mid - 1, k);
        else if (k > a[mid])
            return binaryFindRecursive(a, mid + 1, r, k);
        else {
            if (mid == a.length - 1 || a[mid + 1] != a[mid])
                return mid;
            else
                return binaryFindRecursive(a, l + 1, r, k);
        }
    }
}