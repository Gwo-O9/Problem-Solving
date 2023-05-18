import java.util.*;
import java.io.*;
import java.math.*;

//5430 AC (in acmic);
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st= new StringTokenizer(br.readLine());
        int max = 0;
        int[] arr = new int[n];
        for(int i = 0; i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i<k;i++){
            max += arr[i];
        }
        int i = 0;
        int j = k-1;
        int temp = max;
        while(j<n-1){
            temp -= arr[i];
            i++;
            j++;
            temp += arr[j];
            max = Math.max(temp,max);
        }
        System.out.println(max);
    }
}

