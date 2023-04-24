import java.util.*;
import java.io.*;

public class Main{
    public static void main  (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int index = 1;
        Stack<Integer> s = new Stack<Integer>();
        for(int i = 0; i<n;i++){
            int num = Integer.parseInt(br.readLine());
            while(index <= num){
                sb.append("+\n");
                s.push(index++);
            }
            if(!s.peek().equals(num)) {
                sb.delete(0, sb.length());
                sb.append("NO");
                break;
            }
            else{
                sb.append("-\n");
                s.pop();
            }
        }
        System.out.println(sb.toString());
    }
}
