//4134.java

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<n;i++){
            long num = Long.parseLong(br.readLine());
            if(num>=0 && num <=2){
                sb.append(2 + "\n");
                continue;
            }
            while(true){
                if(isprime(num)) {
                    sb.append(num + "\n");
                    break;
                }
                else num++;
            }
        }
        System.out.println(sb.toString());
    }

    private static boolean isprime(long n){
        long i = 2;
        while(i*i <= n){
            if(n%i == 0) return false;
            i += 1;
        }
        return true;
    }
}
