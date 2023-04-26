import java.util.*;
import java.io.*;

public class Main{
     public static void main (String[] args) throws IOException{
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          int n = Integer.parseInt(br.readLine());
          int[] dp = new int[n+2];
          int[] value = new int[n+2];
          value[0] = Integer.parseInt(br.readLine());
          dp[0] = value[0];
          if(n == 1) {
               System.out.println(dp[0]);
          }
          else{
               value[1] = Integer.parseInt(br.readLine());
               dp[1] = dp[0] +  value[1];
               if(n == 2){
                    System.out.println(dp[1]);
               }
               else{
                    value[2] = Integer.parseInt(br.readLine());
                    dp[2] = Math.max(value[0] + value[2], value[1] + value[2]);
                    for(int i = 3; i<n;i++){
                         value[i] = Integer.parseInt(br.readLine());
                         dp[i] = Math.max(dp[i-2] + value[i], dp[i-3] + value[i] + value[i-1]);
                    }
                    System.out.println(dp[n-1]);
               }
          }
     }
}
