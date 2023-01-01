import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int H = in.nextInt();
        int M = in.nextInt();
        if(M>=45) System.out.println(H + " " + (M-45));
        else{
            if(H==0) System.out.println("23 "+ (60-45+M));
            else System.out.println((H-1) +" "+ (60-45+M));
        }
    }
}
