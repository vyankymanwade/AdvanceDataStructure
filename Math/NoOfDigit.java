import java.io.BufferedReader;
import java.io.InputStreamReader;

class Digit {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println("iterative: " + iterative(n));
        System.out.println("recursive: " + recursive(n));
        System.out.println("logarithmic: " + logarithmic(n));
    }

    public static int logarithmic(int n) {
        return (int) Math.floor(Math.log10(n)+1);
    }

    public static int recursive(int n) {
        if (n == 0)
            return 0;
        else
            return (1 + recursive(n / 10));
    }

    public static int iterative(int n) {
        int count = 0;
        while (n != 0) {
            n = n / 10;
            count++;
        }
        return count;
    }
}