import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cities = Integer.parseInt(br.readLine());
        int roads = Integer.parseInt(br.readLine());
        int[][] dist = new int[cities+1][cities+1];
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= cities; i++){
            for(int j = 1; j <= cities; j++){
                if(i == j) dist[i][j] = 0;
                else dist[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i = 0; i < roads; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            dist[a][b] = Math.min(dist[a][b], c);
        }

        for(int k = 1; k <= cities; k++) {
            for(int i = 1; i <= cities; i++) {
                for(int j = 1; j <= cities; j++) {
                    if(dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE)
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        for(int i = 1; i <= cities; i++){
            for(int j = 1; j <= cities; j++){
                if(dist[i][j] == Integer.MAX_VALUE) sb.append("0 ");
                else sb.append(dist[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
