import java.util.*;
import java.io.*;
import java.math.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(fact(n));
    }
    
    private static long fact(long n){
        if(n == 1) return 1;
        else return n*fact(n-1);
    }
}
