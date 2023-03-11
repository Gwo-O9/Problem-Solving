import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int[] arr = new int[26];
        for(int i = 0; i<26;i++){
            arr[i] = -1;
        }
        for(int i = 0; i<str.length();i++){
            if(arr[(int)str.charAt(i)-97] == -1) arr[(int)str.charAt(i)-97] = i;
            else continue;
        }
        for(int i = 0; i<26;i++){
            System.out.print(arr[i] + " ");
        }
    }
}
