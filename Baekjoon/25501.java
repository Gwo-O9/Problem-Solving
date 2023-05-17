import java.util.*;
import java.io.*;
import java.math.*;

//5430 AC (in acmic);
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i<n;i++){
            String str = br.readLine();
            int k = str.length();
            int[] arr = isPalindrome(str);
            System.out.println(arr[0] + " " + arr[1]);
        }
    }

    private static int[] isPalindrome(String str){
        int n = str.length();
        int i = 0;
        int j = n-1;
        int[] arr = new int[2];
        int cnt = 0;
        while(i<j){
            cnt++;
            if(str.charAt(i) != str.charAt(j)) {
                arr[0] = 0;
                arr[1] = cnt;
                return arr;
            }
            i++;
            j--;
        }
        arr[0] = 1;
        arr[1] = (n/2+1);
        return arr;
    }
}
