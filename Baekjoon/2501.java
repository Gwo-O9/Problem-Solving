import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int index = 0;
        for(int i = 1;i<=a;i++){
            if(a%i == 0){
                index++;
            }
            if(index == b) {
                System.out.println(i);
                break;
            }
        }
        if(index < b) System.out.println(0);
    }
}
