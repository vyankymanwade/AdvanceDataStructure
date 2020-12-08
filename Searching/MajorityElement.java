import java.util.Scanner;

/*
    Find the majority element's index from array
    a[] = {8 3 4 8 8}       o/p = 0 or 3 or 4
    a[] = {3 7 4 7 7 5}     op = -1
    a[] = {20 30 40 50 50 50 50}        o/p = 3 or 4 or 5 or 6
*/
public class MajorityElement {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = s.nextInt();
        System.out.println("Majority Element Index: " + findMajorityNaive(a));
        System.out.println("Majority Element Index: " + findMajorityFast(a));
    }

    public static int findMajorityNaive(int a[]) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int count = 1;
            for (int j = i + 1; j < n; j++) {
                if (a[i] == a[j])
                    count++;
            }
            if (count > n / 2)
                return i;
        }
        return -1;
    }

    public static int findMajorityFast(int a[]) {
        int res = 0;
        int count = 1;
        int n = a.length;
        for (int i = 1; i < n; i++) {
            if (a[res] == a[i])
                count++;
            else
                count--;
            if (count == 0) {
                count = 1;
                res = i;
            }
        }
        count = 0;
        for (int i = 0; i < n; i++) {
            if (a[res] == a[i])
                count++;
        }
        if (count <= n / 2)
            return -1;
        return res;
    }
}