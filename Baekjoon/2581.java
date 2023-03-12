import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for(int i = a;i<= b;i++){
            if(isprime(i)){
                min = Math.min(min,i);
                sum += i;
            }
        }
        if(min == Integer.MAX_VALUE) System.out.println(-1);
        else{
            System.out.println(sum);
            System.out.println(min);
        }
    }
    
    public static boolean isprime(int n){
        int cnt = 0;
        for(int i = 1;i<=n;i++){
            if(n%i == 0) cnt++;
        }
        return cnt == 2 ? true : false;
    }
}
