import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] arr = new long[n];
        for(int i = 0 ; i<n;i++){
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);
        int i = 0;
        int j = n-1;
        long minSum = Long.MAX_VALUE;
        long ans1 = 0;
        long ans2 = 0;
        while(i < j){
            long sum = arr[i] + arr[j];
            if(Math.abs(sum) < minSum) {
                minSum = Math.abs(sum);
                ans1 = arr[i];
                ans2 = arr[j];
            }
            if(sum < 0) {
                i++;
            } else if(sum > 0) {
                j--;
            } else {
                break;
            }
        }
        System.out.println(ans1 + " " + ans2);
    }
}
