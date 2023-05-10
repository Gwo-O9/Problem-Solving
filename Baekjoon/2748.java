import java.util.*;
import java.io.*;
import java.math.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long f = 0;
        long g = 1;
        for(int i = 2; i<=n;i++){
            if(i%2 == 0) f+=g;
            else g += f;
        }
        if(n%2 == 0) System.out.println(f);
        else System.out.println(g);
    }
}
