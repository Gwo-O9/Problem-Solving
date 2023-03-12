import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int cnt = 0;
        for(int i = 0;i< T;i++){
            if(isprime(sc.nextInt())) cnt++;
        }
        System.out.println(cnt);
    }
    public static boolean isprime(int n){
        int cnt = 0;
        for(int i = 1;i<=n;i++){
            if(n%i == 0) cnt++;
        }
        return cnt == 2 ? true : false;
    }
}
