import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        Long[] arr = new Long[k];
        for(int i = 0; i<k;i++){
            arr[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(arr);
        long max = arr[k-1]+1;
        long min = 0;
        while(min < max){
            long mid = (max+min)/2;
            long EA = 0;
            for(int i = 0; i<k;i++){
                EA += (arr[i]/mid);
            }
            if(EA < n){
                max = mid;
            }
            else{
                min = mid+1;
            }
        }
        System.out.println(min-1);
    }
}
