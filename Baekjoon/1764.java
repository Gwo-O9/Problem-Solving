import java.util.*;
import java.io.*;

public class Main{
    public static void main  (String[] args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
       int n = Integer.parseInt(st.nextToken());
       int m = Integer.parseInt(st.nextToken());
       int len = Math.min(n,m);
       String[] str = new String[len];
       int index = 0;
       HashSet<String> set = new HashSet<String>();
       StringBuilder sb = new StringBuilder();
       int cnt = 0;
       for(int i = 0; i<n;i++){
            set.add(br.readLine());
       }
       for(int i = 0; i<m;i++){
            String name = br.readLine();
            if(set.contains(name)) {
                str[index++] = name;
                cnt++;
            } 
       }
       String[] ans = Arrays.copyOfRange(str, 0, index);
       Arrays.sort(ans);
       for(int i = 0; i<index;i++){
            if(i == index-1) sb.append(ans[i]);
            else sb.append(ans[i] + "\n");
       }
       System.out.println(cnt + "\n" + sb.toString());
    }
}
