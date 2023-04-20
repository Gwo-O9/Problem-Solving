import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String ans = "";
        for(int i = 0;i<str.length();i++){
            if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z'){
                ans += (char)(str.charAt(i) - 'a' + 'A');
            }
            else if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z'){
                ans += (char) (str.charAt(i) - 'A' + 'a');
            }
        }
        System.out.println(ans);
    }
}
