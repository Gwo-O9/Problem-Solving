import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = str.length();
        HashSet<String> set = new HashSet<String>();
        int cnt = 0;
        for(int i = 0;i<=n;i++){
            for(int j = i; j<=n;j++){
                String temp = str.substring(i, j);
                if(set.contains(temp)) continue;
                else {
                    set.add(temp);
                    cnt++;
                }
            }
        }
        System.out.println(cnt-1);
    }
}
