import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[20000002];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            if(a < 0) arr[a*(-1)]++;
            else if(a > 0) arr[a+10000000]++;
            else arr[0]++;
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++) {
            int b = Integer.parseInt(st.nextToken());
            if(b < 0) sb.append(arr[b*(-1)]);
            else if(b > 0) sb.append(arr[b+10000000]);
            else sb.append(arr[0]);
            sb.append(" ");
        }
        System.out.println(sb.toString());
    }
}
