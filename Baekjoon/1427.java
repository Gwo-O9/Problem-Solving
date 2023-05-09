import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = str.length();
        int[] arr = new int[n];
        for(int i = 0; i<n;i++){
            arr[i] = str.charAt(i)-48;
        }
        Arrays.sort(arr);
        for(int i = 0; i<n;i++){
            System.out.print(arr[n-i-1]);
        }
    }
}
