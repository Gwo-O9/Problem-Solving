import java.util.*;
import java.io.*;
import java.math.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        long[] dp = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        long max;
        for(int i = 0; i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }   
        dp[0] = max = arr[0];
        for(int i = 1; i<n;i++){
            dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
            max = Math.max(dp[i], max);
        }
        System.out.println(max);
    }
}
