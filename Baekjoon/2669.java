import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[][] xy = new int[101][101];
        for(int i = 0; i<4; i++){
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            for(int j = x1;j<x2;j++){
                for(int k = y1; k<y2;k++){
                    xy[j][k] = 1;
                }
            }
        }
        int w = 0;
        for(int i = 0;i<100;i++){
            for(int j = 0; j<100;j++){
                if(xy[i][j] == 1) w++;
            }
        }
        System.out.println(w);
    }
}
