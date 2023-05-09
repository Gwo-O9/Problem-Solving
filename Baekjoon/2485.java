//2485.java
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int cnt = 0;
        for(int i = 0; i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int[] arr2 = new int[n-1];
        for(int i = 0; i<n-1;i++){
            arr2[i] = arr[i+1] - arr[i];
        }
        int width = arr2[0];
        for(int i = 1; i<n-1;i++){
            width = gcd(Math.max(width,arr2[i]), Math.min(width,arr2[i]));
        }
        int first = arr[0];
        int index = 0;
        while(first < arr[n-1]){
            if(first != arr[index]) {
                first += width;
                cnt++;
            }
            else {
                first += width;
                index++;
            }
            
        }
        System.out.println(cnt);
    }

    private static int gcd(int a, int b){
        int c;
        while(b!=0){
            c = a%b;
            a = b;
            b = c;
        }
        return a;
    }

    private static int lcd(int a, int b){
        return a*b/gcd(a,b);
    }
}
