import java.util.*;
import java.io.*;
import java.math.*;


public class Main {
    static long[] cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n == 1) System.out.println(1);
        else{
            cnt = new long[n+1];
            cnt[1] = 1;
            cnt[2] = 2;
            for(int i = 3; i<=n;i++){
                cnt[i] = (cnt[i-2] + cnt[i-1])%15746;
            }
            System.out.println(cnt[n]%15746);
        }
    }
}
