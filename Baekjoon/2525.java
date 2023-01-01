import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int H = in.nextInt();
        int M = in.nextInt();
        int T = in.nextInt();
        if(M+T < 60) System.out.println(H + " " + (M+T));
        else{
            int outH = (H + (M+T)/60)%24;
            int outM = (M+T)%60;
            System.out.println(outH+" "+outM);
        }
    }
}
