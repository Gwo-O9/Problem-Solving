import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<Integer>();
        sb.append("<");
        for(int i = 0;i<n;i++){
            q.add(i+1);
        }
        while(!q.isEmpty()){
            for(int i = 0; i<k-1;i++){
                int temp = q.poll();
                q.add(temp);
            }
            sb.append(q.poll());
            if(q.isEmpty()) sb.append(">");
            else sb.append(", ");
        }
        System.out.println(sb.toString());
    }
}
