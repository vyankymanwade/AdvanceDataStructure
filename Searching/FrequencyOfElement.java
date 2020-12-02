import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/*
    count the frequency of given element in sorted array
    a[] = {10,20,20,20,25}  k = 20  o/p = 3
    a[] = {15,17,19}        k = 20  o/p = -1
*/
public class FrequencyOfElement {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = s.nextInt();
        int k = s.nextInt();
        System.out.println("count of " + k + " is : " + countUsingHashMap(a, k));
        System.out.println("count of " + k + " is : " + countUsingBinary(a, k));
        System.out.println("count of " + k + " is : " + countUsingInbuild(a, k));
    }

    public static int countUsingInbuild(int a[], int k) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        for (Integer i : a)
            al.add(i);
        if (!al.contains(k))
            return -1;
        return (al.lastIndexOf(k) - al.indexOf(k) + 1);
    }

    public static int countUsingBinary(int a[], int k) {
        int firstOccuranceIndex = findFirstIndex(a, k);
        if (firstOccuranceIndex == -1)
            return -1;
        else {
            return (findLastIndex(a, k) - firstOccuranceIndex + 1);
        }
    }

    public static int findLastIndex(int a[], int k) {
        int l = 0;
        int r = a.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (k < a[mid])
                r = mid - 1;
            else if (k > a[mid])
                l = mid + 1;
            else {
                if (mid == a.length - 1 || a[mid + 1] != k)
                    return mid;
                else
                    l = mid + 1;
            }
        }
        return -1;
    }

    public static int findFirstIndex(int a[], int k) {
        int l = 0;
        int r = a.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (k < a[mid])
                r = mid - 1;
            else if (k > a[mid])
                l = mid + 1;
            else {
                if (mid == 0 || a[mid - 1] != k)
                    return mid;
                else
                    r = mid - 1;
            }
        }
        return -1;
    }

    public static int countUsingHashMap(int a[], int k) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (Integer i : a) {
            if (!hm.containsKey(i))
                hm.put(i, 1);
            else {
                hm.put(i, hm.get(i) + 1);
            }
        }
        if (hm.containsKey(k))
            return hm.get(k);
        else
            return -1;
    }
}