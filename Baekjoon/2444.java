import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0 ; i<n;i++){
            for(int j = n-1-i;j>0;j--){
                System.out.print(" ");
            }
            for(int k = 0;k<i+1;k++){
                System.out.print("*");
            }
            for(int t = 0;t<i;t++){
                System.out.print("*");
            }
            System.out.print("\n");
        }
        for(int i = 0;i<n-1;i++){
            for(int j = 0;j<i+1;j++){
                System.out.print(" ");
            }
            for(int k = n-1-i;k>0;k--){
                System.out.print("*");
            }
            for(int t = n-2;t>i;t--){
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }
}
