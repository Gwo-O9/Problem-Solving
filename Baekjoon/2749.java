import java.util.*;
import java.io.*;
import java.math.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine()) % 1500000;
        long f = 0;
        long g = 1;
        for(int i = 2; i<=n;i++){
            if(i%2 == 0) f = (f+g)%1000000;
            else g = (g+f)%1000000;
        }
        if(n%2 == 0) System.out.println(f%1000000);
        else System.out.println(g%1000000);
    }
}
