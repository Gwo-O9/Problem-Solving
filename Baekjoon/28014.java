import java.util.*;
import java.io.*;
import java.math.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int cnt = 0;
        arr[0] = Integer.parseInt(st.nextToken());
        for(int i = 1; i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i] >= arr[i-1]) cnt++; 
        }
        System.out.println(cnt+1);
    }
}
