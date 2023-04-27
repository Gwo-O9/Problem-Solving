import java.util.*;
import java.io.*;

public class Main{
     public static void main (String[] args) throws IOException{
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          int n = Integer.parseInt(br.readLine());
          int m = Integer.parseInt(br.readLine());
          boolean[] check = new boolean[n+1];
          check[1] = true;
          int ch = -1;
          int[][] arr = new int[m][2];
          for(int i = 0; i<m;i++){
               StringTokenizer st = new StringTokenizer(br.readLine());
               arr[i][0] = Integer.parseInt(st.nextToken());
               arr[i][1] = Integer.parseInt(st.nextToken());
          }
          int j = 0;
          while(ch != 0){
               ch = 0;
               for(int i = 0; i<m;i++){
                    if(check[arr[i][0]] && !check[arr[i][1]]){
                         check[arr[i][1]] = true;
                         ch++;
                    }
                    if(check[arr[i][1]] && !check[arr[i][0]]){
                         check[arr[i][0]] = true;
                         ch++;
                    }
               }
          }
          int cnt = 0;
          for(int i = 2; i<=n;i++){
               if(check[i]) cnt++;
          }
          System.out.println(cnt);
     }
}
