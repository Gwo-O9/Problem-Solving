//13241.java
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long ans = lcd(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        System.out.println(ans);
    }

    private static long gcd(long a, long b){
        long c;
        while(b!=0){
            c = a%b;
            a = b;
            b = c;
        }
        return a;
    }

    private static long lcd(long a, long b){
        return a*b/gcd(a,b);
    }
}
