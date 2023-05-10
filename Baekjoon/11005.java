import java.util.*;
import java.io.*;
import java.math.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(st.nextToken());
        int index = Integer.parseInt(st.nextToken());
        while(num > 0){
            if(num%index >= 10){
                sb.append((char)('A' + (num%index)-10));
            }
            else{
                sb.append((char)(num%index +'0'));
            }
            num /= index;
        }
        String ans = sb.toString();
        for(int i = ans.length()-1;i>=0;i--){
            System.out.print(ans.charAt(i));
        }
    }
}
