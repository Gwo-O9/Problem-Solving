import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int sum = 0;
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        int[] forfreq = new int[8001];
        Arrays.sort(arr);
        int mean = (int) Math.round((double)sum / n);
        int mid = arr[n / 2];

        //최빈값
        for(int i = 0; i < n; i++){
            forfreq[arr[i] + 4000]++;
        }
        int mfreq = 0;
        for(int i = 0; i < 8001; i++){
            if (forfreq[i] > mfreq) {
                mfreq = forfreq[i];
            }
        }
        int temp = -4001;
        boolean pass = false;
        for(int i = 0; i < 8001; i++){
            if(forfreq[i] == mfreq) {
                temp = i - 4000;
                if(pass) break;
                else pass = true;
            }
        }

        //최빈값 종료
        int range = arr[n - 1] - arr[0];
        System.out.println(mean);
        System.out.println(mid);
        System.out.println(temp);
        System.out.println(range);
    }
}
