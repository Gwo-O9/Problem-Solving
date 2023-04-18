import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<Long> s = new Stack<Long>();
        long sum = 0;
        for(int i = 0; i<n;i++){
            long temp = sc.nextLong();
            if(temp == 0) {
                long a = s.pop();
                sum -= a;
            }
            else{
                sum += temp;
                s.push(temp);
            }
        }
        System.out.println(sum);
    }
}
