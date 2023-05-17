import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        LinkedList<Integer> dq = new LinkedList<>();
        for(int i = 1; i<=n;i++){
            dq.addLast(i);
        }
        st = new StringTokenizer(br.readLine());
        int cnt = 0;
        for(int i = 0; i<m;i++){
            int target = Integer.parseInt(st.nextToken());
            int index = dq.indexOf(target);
            int size = dq.size();
            if(target == dq.peek()) dq.removeFirst();
            else if(index > size/2){
                while(target != dq.peek()){
                    dq.addFirst(dq.pollLast());
                    cnt++;
                }
                dq.removeFirst();
            }
            else{
                while(target != dq.peek()){
                    dq.addLast(dq.pollFirst());
                    cnt++;
                }
                dq.removeFirst();
            }
        }
        System.out.println(cnt);
    }
}
