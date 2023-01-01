import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int[] arr = new int[28];
        int[] ishandin = new int[30];
        
        for(int i = 0;i<28;i++){
            arr[i] = scan.nextInt();
        }
        
        for(int i = 0;i<30;i++){
            ishandin[i] = 0;
        }
        
        for(int i = 0;i<28;i++){
            int x = arr[i];
            ishandin[x-1] = 1;
        }
        
        for(int i = 0; i<30;i++){
            if(ishandin[i] != 1) System.out.println((i+1));
        }
    }
}
