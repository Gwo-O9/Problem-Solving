import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int sum = 0;
        for(int i = 0; i<5;i++){
            sum += Math.pow(in.nextInt(),2);
        }
        System.out.println(sum%10);
    }
}
