import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int A = in.nextInt();
        int B = in.nextInt();
        int C = in.nextInt();
        int same;
        
        if(A == B && B == C) same = 1;
        else if(A == B) same = 2;
        else if(B == C) same = 3;
        else if(A == C) same = 4;
        else same = 0;
        
        if(same == 0){
            int max = A;
            if(B > max) max = B;
            if(C > max) max = C;
            System.out.println(max*100);
        }
        else if(same ==2){
            System.out.println(1000+A*100);
        }
        else if(same ==3){
            System.out.println(1000+B*100);
        }
        else if(same == 4){
            System.out.println(1000+C*100);
        }
        else{
            System.out.println(10000+A*1000);
        }
    }
}
