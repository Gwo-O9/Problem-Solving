import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Stack<Integer> s = new Stack<Integer>();
        for(int i = 0;i<n;i++){
            String str = sc.nextLine();
            int len = str.length();
            boolean isYes = true;
            for(int j = 0; j<len;j++){
                if(str.charAt(j) == '(') s.push(1);
                else{
                    if(s.isEmpty()) {
                        isYes = false;
                        break;
                    }
                    else s.pop();
                }
            }
            if(!s.isEmpty()) isYes = false;
            if(isYes) System.out.println("YES");
            else System.out.println("NO");
            s.clear();
        }
    }
}
