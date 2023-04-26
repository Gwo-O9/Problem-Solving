import java.util.*;
import java.io.*;

public class Main{
    public static void main  (String[] args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int n = Integer.parseInt(br.readLine());
       Set<Integer> set = new HashSet<>();
       StringBuilder sb = new StringBuilder();
       for(int i = 0; i<n;i++){
          StringTokenizer st = new StringTokenizer(br.readLine());
          String cmd = st.nextToken();
          if(cmd.equals("add")) set.add(Integer.parseInt(st.nextToken()));
          else if(cmd.equals("remove")) set.remove(Integer.parseInt(st.nextToken()));
          else if(cmd.equals("check")){
               if(set.contains(Integer.parseInt(st.nextToken()))) sb.append("1\n");
               else sb.append("0\n");
          }
          else if(cmd.equals("toggle")){
               int a= Integer.parseInt(st.nextToken());
               if(set.contains(a)) set.remove(a);
               else set.add(a);
          }
          else if(cmd.equals("all")){
               set.clear();
               for(int j = 0 ; j<20;j++){
                    set.add(j+1);
               }
          }
          else if(cmd.equals("empty")) set.clear();
       }
       System.out.println(sb.toString());
    }
}
