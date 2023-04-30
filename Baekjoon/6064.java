import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i<T;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int max = lcm(M,N);
            int ans = x;
            while(true){
                if(ans > max){
                    System.out.println("-1");
                    break;
                }
                if((ans - x)%M == 0 && (ans-y)%N == 0){
                    System.out.println(ans);
                    break;
                }
                ans += M;
            }
        }
    }

    private static int gcd(int x, int y){
        if(x%y == 0) return y;
        return gcd(y, x%y);
    }

    private static int lcm(int x, int y){
        return (x*y)/gcd(x,y);
    }
}
