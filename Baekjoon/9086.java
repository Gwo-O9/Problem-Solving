import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        for(int i = 0; i<n;i++){
            String str = in.nextLine();
            String ans = new String("");
            if(str.length() == 0) {
                System.out.println("");
                continue;
            }
            ans = ans + str.charAt(0) + str.charAt(str.length()-1);
            System.out.println(ans);
        }
    }
}
