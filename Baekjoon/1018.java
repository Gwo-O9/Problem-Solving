import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        char[][] arr = new char[m][n];
        sc.nextLine();
        for(int i = 0;i<m;i++){
            String s = sc.nextLine();
            for(int j = 0; j<n;j++){
                arr[i][j] = s.charAt(j);
            }
        }
        int min = Integer.MAX_VALUE;
        int ans = Integer.MAX_VALUE;
        int temp = 0;
        int temp2 = 0;
        for(int k = 0; k<m-7;k++){
            for(int t = 0;t<n-7;t++){
                for(int i = k; i<k+8;i++){
                    for(int j = t;j<t+8;j++){
                        if(i%2 == 0 && j%2 == 0 && arr[i][j] == 'W') temp++;
                        else if(i%2 == 1 && j%2 == 1 && arr[i][j] == 'W') temp++;
                        else if(i%2 == 1 && j%2 == 0 && arr[i][j] == 'B') temp++;
                        else if(i%2 == 0 && j%2 == 1 && arr[i][j] == 'B') temp++;
                        
                        if(i%2 == 0 && j%2 == 0 && arr[i][j] == 'B') temp2++;
                        else if(i%2 == 1 && j%2 == 1 && arr[i][j] == 'B') temp2++;
                        else if(i%2 == 1 && j%2 == 0 && arr[i][j] == 'W') temp2++;
                        else if(i%2 == 0 && j%2 == 1 && arr[i][j] == 'W') temp2++;
                    }
                }
                min = Math.min(temp, temp2);
                ans = Math.min(ans, min);
                temp = 0;
                temp2 = 0;
            }
        }
        System.out.println(ans);
    }
}
