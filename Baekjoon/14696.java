import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[5];
        int[] B = new int[5];
        for(int i = 0 ; i<n;i++){
            int out = 0;
            int anum = sc.nextInt();
            for(int j = 0; j< anum;j++){
                A[sc.nextInt()]++;
            }
            int bnum = sc.nextInt();
            for(int k = 0; k<bnum;k++){
                B[sc.nextInt()]++;
            }
            for(int t = 4 ; t>=1;t--){
                if(A[t] > B[t]) {
                    out = 1;
                    break;
                }
                else if(A[t] == B[t]) continue;
                else {
                    out = 2;
                    break;
                }
            }
            if(out == 1) System.out.println("A");
            else if(out == 2) System.out.println("B");
            else System.out.println("D");
            Arrays.fill(A,0);
            Arrays.fill(B,0);
        }
    }
}
