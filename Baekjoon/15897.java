import java.util.*;
import java.io.*;
import java.math.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long ans = 0;
        if(n == 1) System.out.println(1);
        else{
            for(int i = 1, temp; i<n;i = temp+1){
                int index = (n-1)/i +1;
                temp = (n-1)/((n-1)/i);
                ans += ((temp-i+1)*index);
            }
            System.out.println(ans+1);
        }
    }
}
