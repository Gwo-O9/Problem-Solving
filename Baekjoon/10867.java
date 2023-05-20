import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr= new int[n];
        Set set = new HashSet<Integer>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int index = 0;
        for(int i = 0; i<n;i++){
            int num = Integer.parseInt(st.nextToken());
            if(set.contains(num)) continue;
            else{
                arr[index++] = num;
                set.add(num); 
            }
        }
        arr = Arrays.copyOf(arr, index);
        Arrays.sort(arr);
        for(int a : arr){
            System.out.print(a + " ");
        }
    }
}

