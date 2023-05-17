import java.util.*;
import java.io.*;
import java.math.*;

//5430 AC (in acmic);
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<T;i++){
            Deque<Integer> dq = new ArrayDeque<Integer>();
            boolean isleft = true;
            boolean iserror = false;
            String cmd = br.readLine();
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), "[],");
            for(int j = 0; j<n;j++){
                dq.addLast(Integer.parseInt(st.nextToken()));
            }
            int len = cmd.length();
            for(int j = 0; j<len;j++){
                if(cmd.charAt(j) == 'R'){
                    isleft = !isleft;
                }
                else{
                    if(dq.size() == 0) {
                        sb.append("error\n");
                        iserror = true;
                        break;
                    }
                    else if(isleft){
                        dq.removeFirst();
                    }
                    else {
                        dq.removeLast();
                    }
                }
            }
            if(iserror) continue;
            else{
                sb.append("[");
                if(isleft){
                    for(int j : dq){
                        sb.append(j + ",");
                    }
                    if(sb.charAt(sb.length()-1) != '[') sb.deleteCharAt(sb.length()-1);
                    sb.append("]\n");
                }
                else{
                    while(!dq.isEmpty()){
                        sb.append(dq.pollLast() + ",");
                    }
                    if(sb.charAt(sb.length()-1) != '[') sb.deleteCharAt(sb.length()-1);
                    sb.append("]\n");
                }
            }
        }
        System.out.println(sb.toString());
    }
}
