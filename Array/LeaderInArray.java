import java.util.Scanner;
import java.util.Stack;

public class LeaderInArray {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }
        findLeader(a);
    }

    public static void findLeader(int a[]) {
        int n = a.length;
        Stack<Integer> stack = new Stack<>();
        stack.push(a[n - 1]);
        int max = a[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (max <= a[i]) {
                stack.push(a[i]);
                max = a[i];
            }
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}