import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int len = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int cnt = 0;
        int ans = 0;
        for(int i = 0; i<len-2;i+=1){
            if(s.charAt(i) == 'I' && s.charAt(i+1) == 'O' && s.charAt(i+2) == 'I'){
                cnt++;
                if(cnt == n){
                    ans++;
                    cnt--;
                }
                i++;
            }
            else{
                cnt = 0;
            }
        }
        System.out.println(ans);
    }
}
