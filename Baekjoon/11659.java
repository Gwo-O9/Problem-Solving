import java.util.*;
import java.io.*;

public class Main{
    public static void main  (String[] args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
       int n = Integer.parseInt(st.nextToken());
       int m = Integer.parseInt(st.nextToken());
       StringBuilder sb = new StringBuilder();
       int[] arr = new int[n];
       StringTokenizer st2 = new StringTokenizer(br.readLine());
       int[] sumarr = new int[n];
       arr[0] = Integer.parseInt(st2.nextToken());
       sumarr[0] = arr[0];
       for(int i = 1; i<n;i++){
            arr[i] = Integer.parseInt(st2.nextToken());
            sumarr[i] = sumarr[i-1] + arr[i];
       }
       for(int i = 0; i<m;i++){
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st3.nextToken()) -1;
            int b = Integer.parseInt(st3.nextToken()) -1;
            int sum = 0;
            if(a == 0) sum = sumarr[b];
            else sum = sumarr[b] - sumarr[a-1];
            sb.append(sum+"\n");
       }
       System.out.println(sb.toString());
    }
}
