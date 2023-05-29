import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        int[][] canvisit = new int[n][n];
        for(int i = 0; i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0 ; i<n;i++){
            for(int j = 0; j<n;j++){
                for(int k = 0; k<n;k++){
                    if(map[j][i] + map[i][k] == 2) map[j][k] =1;
                }
            }
        }
        for(int i = 0; i<n;i++){
            for(int j = 0; j<n;j++){
                bw.write(map[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
