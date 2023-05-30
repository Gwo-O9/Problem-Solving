import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int map[][] = new int[n+1][n+1];
        boolean isvist[][] = new boolean[n+1][n+1];
        for(int i = 0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = map[b][a] = 1;
        }
        for(int i = 1; i<=n;i++){
            for(int j = 1; j<=n;j++){
                for(int k = 1;k<=n;k++){
                    if(map[j][i] != 0 && map[i][k] != 0) {
                        if(map[j][k] != 0) map[j][k] = Math.min(map[j][k],map[j][i] + map[i][k]);
                        else map[j][k] = map[j][i] + map[i][k]; 
                    }

                }
            }
        }
        int min = Integer.MAX_VALUE;
        int ans = -1;
        for(int i = n;i>0;i--){
            int tmp = 0;
            for(int j = 1; j<=n;j++){
                tmp += map[i][j];
            }
            if(min >= tmp) {
                min = tmp;
                ans = i;
            }
        }
        System.out.println(ans);
    }
}
