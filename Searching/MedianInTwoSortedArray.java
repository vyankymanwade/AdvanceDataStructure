import java.util.Scanner;

public class MedianInTwoSortedArray {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n1 = s.nextInt();
        int n2 = s.nextInt();
        int a1[] = new int[n1];
        int a2[] = new int[n2];
        for (int i = 0; i < n1; i++)
            a1[i] = s.nextInt();
        for (int i = 0; i < n2; i++)
            a2[i] = s.nextInt();
        System.out.println("Median is :" + findMedian(a1, a2, n1, n2));
    }

    public static double findMedian(int a1[], int a2[], int n1, int n2) {
        int l = 0;
        int r = n1;
        while (l <= r) {
            int i1 = (l + r) / 2;
            int i2 = (n1 + n2 + 1) / 2 - i1;
            int min1 = (i1 == n1) ? Integer.MAX_VALUE : a1[i1];
            int max1 = (i1 == 0) ? Integer.MIN_VALUE : a1[i1 - 1];
            int min2 = (i2 == n2) ? Integer.MAX_VALUE : a2[i2];
            int max2 = (i2 == 0) ? Integer.MIN_VALUE : a2[i2 - 1];

            if (min1 >= max2 && min2 >= max1) {
                if ((n1 + n2) % 2 == 0)
                    return (double) (Integer.max(max1, max2) + Integer.min(min1, min2)) / 2;
                else
                    return (double) (Integer.max(max1, max2));
            } else if (max1 > min2)
                r = i1 - 1;
            else
                l = i1 + 1;
        }
        return -1;
    }
}