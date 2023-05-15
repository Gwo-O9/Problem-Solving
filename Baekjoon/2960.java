import java.util.*;
import java.io.*;
import java.math.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        boolean[] eratosthenes = new boolean[n+1];
        Arrays.fill(eratosthenes, true);
        int cnt = 0;
        int ans = 0;
        for(int i = 2; i<=n;i++){
            for(int j = i; j <= n; j+=i){
                if(eratosthenes[j]){
                    eratosthenes[j] = false;
                    cnt++;
                }
                if(cnt == r) {
                    ans = j;
                    break;
                }
            }
            if(ans != 0) break;
        }   
        System.out.println(ans);
    }
}
