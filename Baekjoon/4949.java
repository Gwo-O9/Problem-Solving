import java.util.*;
import java.io.*;

public class Main{
    public static void main  (String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> s = new Stack<Character>();
        while(true){
            String str = br.readLine();
            int n = str.length();
            if(str.equals(".")) break;
            boolean pass = false;
            for(int i = 0; i<n;i++){
                if(str.charAt(i) == '(' || str.charAt(i) == '[') s.push(str.charAt(i));
                else if((str.charAt(i) == ')' && s.isEmpty()) || (str.charAt(i) == ']' && s.isEmpty())) {
                    System.out.println("no");
                    pass = true;
                    break;
                } 
                else if((str.charAt(i) == ')' && s.peek() == '[') || (str.charAt(i) == ']' && s.peek() == '(')){
                    System.out.println("no");
                    pass = true;
                    break;
                }
                else if((str.charAt(i) == ')' && s.peek() == '(') || (str.charAt(i) == ']' && s.peek() == '[')){
                    s.pop();
                    continue;
                }
                else if(str.charAt(i) == '.' && !s.isEmpty()){
                    System.out.println("no");
                    pass = true;
                }
                else if(str.charAt(i) == '.' && s.isEmpty()){
                    System.out.println("yes");
                    pass = true;
                }
            }
            if(!pass && s.isEmpty()) System.out.println("yes");
            s.clear();
        }
    }
}
