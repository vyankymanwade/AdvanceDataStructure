import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/*
    given unsorted array we need to find the pair with given sum
    a[] = {3 5 9 2 8 10 11}     sum = 17        o/p = YES/true
    a[] = {8 4 6}               sum = 11        o/p = No/false
*/
public class PairSum {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = s.nextInt();
        int sum = s.nextInt();
        System.out.println("Is Sum Available: " + isAvailable(a, sum));
        System.out.println("Is Sum Available: " + isAvailableUsingHashing(a, sum));
    }

    // using Hashset gives advantage that it will search sum-a[i] in O(1) time
    // which will improve time complexity
    public static boolean isAvailableUsingHashing(int a[], int sum) {
        HashSet<Integer> hs = new HashSet<Integer>();
        for (int i = 0; i < a.length; i++) {
            if (hs.contains(sum - a[i]))
                return true;
            else
                hs.add(a[i]);
        }
        System.out.println(hs);
        return false;
    }

    public static boolean isAvailable(int a[], int sum) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        for (Integer i : a)
            al.add(i);
        for (int i = 0; i < al.size(); i++) {
            if (al.contains(sum - al.get(i)))
                return true;
        }
        return false;
    }
}