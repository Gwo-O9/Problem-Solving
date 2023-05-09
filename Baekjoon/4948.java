import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        boolean[] isPrime = new boolean[246913];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i * i <= 246912; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= 246912; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        while(true){
            int n = Integer.parseInt(br.readLine());
            if(n == 0) break;
            int cnt = 0;
            for(int i = n+1; i<=n*2;i++){
                if(isPrime[i]) cnt++;
            }
            sb.append(cnt + "\n");
        }
        System.out.println(sb.toString());
    }
}
