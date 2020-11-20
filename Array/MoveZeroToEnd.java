import java.util.Scanner;

public class MoveZeroToEnd {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }
        System.out.println("Aftre moving zero to end: ");
        move(a);
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("Aftre moving zero to end: ");
        fast(a);
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    public static void fast(int a[]) { // O(n)
        /*
         * here we are maintaning count of non zero element visited at at point of time
         * and if we come across non zero element then we swap that new with element
         * with index count
         */
        int n = a.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] != 0) {
                int temp = a[count];
                a[count] = a[i];
                a[i] = temp;
                count++;
            }
        }
    }

    public static void move(int a[]) { // O(n^2)
        int end = a.length;
        for (int i = 0; i < end; i++) {
            if (a[i] == 0) {
                for (int j = i + 1; j < end; j++) {
                    if (a[j] != 0) {
                        int temp = a[i];
                        a[i] = a[j];
                        a[j] = temp;
                    }
                }
            }
        }
    }
}