import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i<n;i++){
            int temp = Integer.parseInt(st.nextToken());
            max = Math.max(temp, max);
            min = Math.min(temp, min);
        }
        System.out.println(max-min);
    }
}
