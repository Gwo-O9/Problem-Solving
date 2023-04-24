import java.util.*;
import java.io.*;

public class Main{
    public static void main  (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        int index = 0;
        for(int i = 0; i<N;i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int j = 0;j<M;j++){
                arr[i][j] = Integer.parseInt(st2.nextToken());
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i<257;i++){
            int inblock = 0;
            int outblock = 0;
            for(int j = 0; j<N;j++){
                for(int k = 0;k<M;k++){
                    if(arr[j][k] > i) outblock += (arr[j][k] - i);
                    else inblock += (i - arr[j][k]);
                }
            }
            if(outblock + B < inblock) continue;
            int time = outblock*2 + inblock;
            if(ans >= time){
                index = i;
                ans = time;
            }
        }
        System.out.println(ans + " " + index);
    }
}
