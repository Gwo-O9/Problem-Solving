import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[100001];
        int sum = 0;
        for(int i = 0; i<n;i++){
            int x = sc.nextInt();
            int color = sc.nextInt();
            arr[x] = color;
        }
        for(int i  = 0; i<100000;i++){
            if(arr[i] != 0){
                int j = i;
                int k = 1;
                while(true){
                    if(j-k >= 0){
                        if(arr[j-k] == arr[i]) break;
                    }
                    if(j+k<100001){
                        if(arr[j+k] == arr[i]) break;
                    }
                    k++;
                }
                sum += k;
            }
        }
        System.out.println(sum);
    }
}
