import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        while(a > 1){
            for(int i = 2; i<=a;i++){
                if(a%i == 0){
                    System.out.println(i);
                    a /= i;
                    break;
                }
            }
        }
    }
}
