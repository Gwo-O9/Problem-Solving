import java.util.*;
import java.io.*;

public class Main{
     public static void main (String[] args) throws IOException{
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          int n = Integer.parseInt(br.readLine());
          PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
          StringBuilder sb = new StringBuilder();
          for(int i  = 0; i<n;i++){
               int a = Integer.parseInt(br.readLine());
               if(a == 0) {
                    if(pq.size() != 0) sb.append(pq.poll() + "\n");
                    else sb.append("0\n");
               }
               else{
                    pq.add(a);
               }
          }
          System.out.println(sb.toString());
     }
}
