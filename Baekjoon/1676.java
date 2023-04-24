import java.util.*;
import java.io.*;

public class Main{
    public static void main  (String[] args) throws IOException{
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       int ans = 0;
       if(n==1) System.out.println(0);
       for(int i = 1; i<=n;i++){
           int temp = i;
           while(temp%5 == 0){
               ans++;
               temp /= 5;
           }
       }
       System.out.println(ans);
    }
}
