import java.io.BufferedReader;
import java.io.InputStreamReader;

class IsPrime {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(isPrime(n));
    }

    public static boolean isPrime(int n) {
        boolean flag = true;
        for (int i = 2; i < (int) Math.sqrt(n); i++) {
            if (n % i == 0)
                flag = false;
        }
        return flag;
    }
}