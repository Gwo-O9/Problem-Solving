import java.util.*;
import java.io.*;
import java.math.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        BigInteger f = BigInteger.ZERO;
        BigInteger g = BigInteger.ONE;
        for(int i = 2; i<=n;i++){
            if(i%2 == 0) f = f.add(g);
            else g = g.add(f);
        }
        if(n%2 == 0) System.out.println(f);
        else System.out.println(g);
    }
}
