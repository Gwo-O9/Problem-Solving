import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] A = new int[N];
        int[] B = new int[N];
        for(int i = 0; i<N;i++){
            A[i] = in.nextInt();
        }
        for(int i = 0; i<N;i++){
            B[i] = in.nextInt();
        }
        Arrays.sort(A);
        Arrays.sort(B);
        int sum = 0;
        for(int i = 0; i<N;i++){
            sum += (B[i]*A[N-1-i]);
        }
        System.out.println(sum);
    }
}
