import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if(n < 10){
            if (n == 2) System.out.println(1);
            else if (n == 4) System.out.println(2);
            else if (n == 6) System.out.println(3);
            else if (n == 8) System.out.println(4);
            else System.out.println(0);
            return;
        }
        int i = 1;
        while(i <= n){
            int sum = i;
            int ans = i;
            while(i > 0){
                sum += i%10;
                i /= 10;
            }
            if(sum == n) {
                System.out.println(ans);
                return;
            }
            i = ans + 1;
        }
        System.out.println(0);
    }
}
