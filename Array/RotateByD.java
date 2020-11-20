import java.util.Scanner;

class RotateByD {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }
        int d = s.nextInt();

        System.out.println("before rotation by d: ");
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
        rotate1(a, d); // O(n) space - O(D)
        System.out.println("after rotation by d: ");
        for (int i : a) {
            System.out.print(i + " ");
        }

        System.out.println("before rotation by d: ");
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
        rotate(a, d); // best method O(n) and time - O(1)
        System.out.println("after rotation by d: ");
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    public static void rotate1(int a[], int d) {
        int temp[] = new int[d];
        for (int i = 0; i < d; i++)
            temp[i] = a[i];
        for (int i = d; i < a.length; i++) {
            a[i - d] = a[i];
        }
        for (int i = 0; i < temp.length; i++)
            a[a.length - d + i] = temp[i];
    }

    public static void rotate(int a[], int d) {
        reverse(a, 0, d - 1);
        reverse(a, d, a.length - 1);
        reverse(a, 0, a.length - 1);
    }

    public static void reverse(int a[], int start, int end) {
        while (start < end) {
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;
            start++;
            end--;
        }
    }
}