import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int sum = 1;
        for(int i = 0; i<3;i++){
            sum *= in.nextInt();
        }
        String temp = Integer.toString(sum);
        int[] arr = new int[10];
        for(int j = 0; j<temp.length();j++){
            arr[temp.charAt(j)-48]++;
        }
        for(int k = 0; k<10;k++){
            System.out.println(arr[k]);
        }
    }
}
