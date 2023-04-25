import java.util.*;
import java.io.*;

public class Main{
    public static void main  (String[] args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
       int n = Integer.parseInt(st.nextToken());
       int m = Integer.parseInt(st.nextToken());
       HashMap<String, Integer> map = new HashMap<>();
       StringBuilder sb = new StringBuilder();
       String[] arr = new String[n+1];
       for(int i = 1; i<=n;i++){
          String a = br.readLine();
          map.put(a,i);
          arr[i] = a;
       }
       for(int i = 1; i<=m;i++){
          String s = br.readLine();
          if(s.charAt(0) >= 48 && s.charAt(0) <= 57){
            sb.append(arr[Integer.parseInt(s)] + "\n");
          }
          else{
            sb.append(map.get(s) + "\n");
          }
       }
       System.out.println(sb.toString());
    }
}
