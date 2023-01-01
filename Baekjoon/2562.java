import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int[] arr = new int[9];
        for(int i = 0;i<9;i++){
            arr[i] = scan.nextInt();
        }
        int max = arr[0];
        int maxindex = 1;
        for(int i = 1;i<9;i++){
            if(max < arr[i]){
                max = arr[i];
                maxindex = i+1;
            }
        }
        System.out.println(max);
        System.out.println(maxindex);
    }
}
