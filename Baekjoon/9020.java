import java.util.*;

public class Main {
    static boolean[] isPrime;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        eratosthenes(10000);

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int a = n / 2;
            int b = n / 2;
            while (true) {
                if (isPrime[a] && isPrime[b]) {
                    System.out.println(a + " " + b);
                    break;
                }
                a--;
                b++;
            }
        }
        sc.close();
    }

    static void eratosthenes(int n) {
        isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }
}
