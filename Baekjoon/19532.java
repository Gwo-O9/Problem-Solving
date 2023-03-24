import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        int d = in.nextInt();
        int e = in.nextInt();
        int f = in.nextInt();
        for(int i = -999; i<1000;i++){
            for(int j = -999; j<1000;j++){
                if(a*i + b*j == c && d*i + e*j == f) {
                    System.out.println(i + " " + j);
                    return;
                }
            }
        }
    }
}
