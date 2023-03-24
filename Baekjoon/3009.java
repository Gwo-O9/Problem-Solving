import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] x = new int[3];
        int[] y = new int[3];
        for(int i = 0; i<3;i++){
            x[i] = in.nextInt();
            y[i] = in.nextInt();
        }
        int a = x[0];
        int b = y[0];
        int ans1 = 0;
        int ans2 = 0;
        if(a == x[1]) ans1 = x[2];
        else ans1 = x[0] == x[2] ? x[1] : x[0]; 
        if(b == y[1]) ans2 = y[2];
        else ans2 = y[0] == y[2] ? y[1] : y[0];
        System.out.println(ans1 + " " + ans2);
    }
}
