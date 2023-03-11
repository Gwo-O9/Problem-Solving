import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String str = in.nextLine();
        int sum = 0;
        for(int i = 0; i<n;i++){
            sum += ((int) str.charAt(i) - 48);
        }
        System.out.println(sum);
    }
}
