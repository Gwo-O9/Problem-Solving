import java.util.*;
import java.io.*;
import java.math.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        System.out.println(fact(n).divide(fact(r).multiply(fact(n-r))));
        
    }

    private static BigInteger fact(int n){
        BigInteger tmp = BigInteger.ONE;
        for(int i = 1; i<=n;i++){
            tmp = tmp.multiply(new BigInteger(Integer.toString(i)));
        }
        return tmp;
    }
}

