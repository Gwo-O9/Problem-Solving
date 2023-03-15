import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static long[] dp = new long[1000001];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        eratosthenes(1000000);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(br.readLine());
            sb.append(dp[k]).append('\n');
        }
        System.out.print(sb);
    }

    public static void eratosthenes(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; i * j <= n; j++) {
                dp[i*j] += i;
            }
            dp[i] += dp[i-1];
        }
    }
}
