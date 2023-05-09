import java.util.*;
import java.io.*;
import java.math.*;


public class Main {
    static BigInteger[] fact = new BigInteger[31];
    public static void main(String[] args) throws IOException {
        fact[0] = BigInteger.ONE;
        for(int i = 1;i<=30;i++){
            fact[i] = fact[i-1].multiply(BigInteger.valueOf(i));
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int b = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            sb.append(fact[a].divide(fact[b].multiply(fact[a-b]))+ "\n");
        }
        System.out.println(sb.toString());
    }
}
