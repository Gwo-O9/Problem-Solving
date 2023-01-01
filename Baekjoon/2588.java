import java.util.Scanner;

public class Main{
    public static void main (String[] args){
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int o1, o2, o3;
        o1 = b%10;
        o2 = b%100 - o1;
        o3 = b - o1 - o2;
        System.out.println(a*o1);
        System.out.println(a*o2/10);
        System.out.println(a*o3/100);
        System.out.println(a*b);
    }
}
