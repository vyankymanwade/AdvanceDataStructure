import java.util.Scanner;

public class OddOccuring {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }
        System.out.println(find(a));
    }

    public static int find(int a[]) {
        int n = a.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = res ^ a[i];
        }
        return res;
    }
}