import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        int[] x = new int[T];
        int[] y = new int[T];
        for(int i = 0; i<T;i++){
            x[i] = in.nextInt();
            y[i] = in.nextInt();
        }
        Arrays.sort(x);
        Arrays.sort(y);
        int ans = (x[T-1] - x[0])*(y[T-1] - y[0]);
        System.out.println(ans);
    }
}
