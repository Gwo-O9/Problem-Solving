import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int king = in.nextInt();
        int a = 1-king;
        int Queen = in.nextInt();
        int b = 1-Queen;
        int L = in.nextInt();
        int c = 2-L;
        int V = in.nextInt();
        int d = 2-V;
        int Kn = in.nextInt();
        int e = 2-Kn;
        int P = in.nextInt();
        int f = 8-P;
        System.out.println(a+" "+b+" "+c+" "+d+" "+ e+" "+f);
    }
}
