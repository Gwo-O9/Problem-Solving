import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        long length = Long.parseLong(st.nextToken());
        Long[] arr = new Long[k];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i = 0; i<k;i++){
            arr[i] = Long.parseLong(st2.nextToken());
        }
        Arrays.sort(arr);
        long max = arr[k-1];
        long min = 0;
        while(min < max){
            long mid = (max+min)/2;
            long len = 0;
            for(int i = 0; i<k;i++){
                if(arr[i] > mid) len += (arr[i]-mid);
            }
            if(len < length){
                max = mid;
            }
            else{
                min = mid+1;
            }
        }
        System.out.println(min-1);
    }
}
