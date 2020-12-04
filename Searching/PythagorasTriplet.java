import java.util.Arrays;
import java.util.Scanner;

public class PythagorasTriplet {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = s.nextInt();
        System.out.println("Is Array Contain Triplet: " + isTripletAvlNaive(a));
        System.out.println("Is Array Contain Triplet: " + isTripletAvlFast(a));
    }

    public static boolean isTripletAvlFast(int a[]) {
        for (int i = 0; i < a.length; i++)
            a[i] = a[i] * a[i];
        Arrays.sort(a);
        // for every last
        for (int i = a.length - 1; i >= 2; i--) {
            int l = 0;
            int r = i - 1;
            // this while loop uses TWO POINTER approch to find the pair
            while (l < r) {
                if (a[l] + a[r] == a[i])
                    return true;
                if (a[l] + a[r] > a[i])
                    r--;
                else
                    l++;
            }
        }
        return false;
    }

    public static boolean isTripletAvlNaive(int a[]) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    int x = a[i] * a[i], y = a[j] * a[j], z = a[k] * a[k];
                    if (x + y == z || y + z == x || z + x == y)
                        return true;
                }
            }
        }
        return false;
    }
}






