import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            boolean[][] arr = new boolean[r][c];
            int cnt = 0;
            for (int j = 0; j < k; j++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st2.nextToken());
                int b = Integer.parseInt(st2.nextToken());
                arr[a][b] = true;
            }
            for (int j = 0; j < r; j++) {
                for (int t = 0; t < c; t++) {
                    if (arr[j][t]) {
                        dfs(arr, j, t, r, c);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    private static void dfs(boolean[][] arr, int i, int j, int r, int c) {
        if (i < 0 || i >= r || j < 0 || j >= c || !arr[i][j]) return;
        arr[i][j] = false;
        dfs(arr, i - 1, j, r, c);
        dfs(arr, i + 1, j, r, c);
        dfs(arr, i, j - 1, r, c);
        dfs(arr, i, j + 1, r, c);
    }
}
