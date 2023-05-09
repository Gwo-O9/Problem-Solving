import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        boolean[] isPrime = new boolean[2000002];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i * i <= 2000001; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= 2000001; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        for(int i = 0; i<n;i++){
            int num = Integer.parseInt(br.readLine());
            int cnt = 0;
            int a = 1;
            int b = num-1;
            while(a<=b){
                if(isPrime[a] && isPrime[b]) cnt++;
                a++;
                b--;
            }
            sb.append(cnt + "\n");
        }
        System.out.println(sb.toString());
    }
}
