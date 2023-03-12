import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int n = str.length();
        int[] arr = new int[26];
        int i;
        for(i = 0; i<n;i++){
            char ch = str.charAt(i);
            ch = Character.toLowerCase(ch);
            arr[(int)ch - 97]++;
        }
        int maxindex = 0;
        int questionmark = 0;
        int max = -1;
        for(i = 0; i<26;i++){
            if(max < arr[i]){
                max = arr[i];
                maxindex = i;
            }
        }
        for(i = 0; i<26;i++){
            if(max == arr[i]) questionmark++;
        }
        if(questionmark > 1) System.out.println("?");
        else{
            char ans = (char) (maxindex+65);
            System.out.println(ans);
        }
    }
}
