import java.util.*;
import java.io.*;

public class Main{
     public static void main (String[] args) throws IOException{
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          int n = Integer.parseInt(br.readLine());
          HashMap<String,Integer> map = new HashMap<>();
          HashSet<String> set = new HashSet<>();
          for(int i = 0; i<n;i++){
               int m = Integer.parseInt(br.readLine());
               for(int j = 0; j<m;j++){
                    StringTokenizer st = new StringTokenizer(br.readLine());
                    String dummy = st.nextToken();
                    String temp = st.nextToken();
                    if(map.containsKey(temp)){
                         map.put(temp, map.get(temp)+1);
                    }
                    else{
                         map.put(temp, 1);
                         set.add(temp);
                    }
               }
               int ans = 1;
               for(String a : set){
                    ans *= (map.get(a) + 1);
               }
               System.out.println(ans-1);
               map.clear();
               set.clear();
          }
     }
}
