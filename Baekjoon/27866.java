import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int n = in.nextInt();
        System.out.println(str.charAt(n-1));
    }
}
