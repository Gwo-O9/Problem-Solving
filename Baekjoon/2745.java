import java.util.*;
import java.io.*;
import java.math.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String num = st.nextToken();
        int n = num.length();
        int index = Integer.parseInt(st.nextToken());
        int ans = 0;
        for(int i = 0; i<n;i++){
            char ch = num.charAt(i);
            if(ch >= '0' && ch <= '9') ans += ((ch-48)*Math.pow(index,n-i-1));
            else ans += ((ch-55)*Math.pow(index,n-1-i));
        }
        System.out.println(ans);
    }
}
