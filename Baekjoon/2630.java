import java.util.*;
import java.io.*;

public class Main {
    static int[] cnt = new int[2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] paper = new int[n][n];
        for(int i = 0; i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j =0; j<n;j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cut(paper, 0, n, 0, n);
        System.out.println(cnt[0] + "\n" + cnt[1]);
    }

    private static void cut(int[][] arr, int startrow, int endrow, int startcol, int endcol){
        int color = arr[startrow][startcol];
        boolean issame = true;
        for(int i = startrow; i<endrow;i++){
            for(int j = startcol; j<endcol;j++){
                if(color != arr[i][j]){
                    issame = false;
                    break;
                }
            }
            if(!issame) break;
        }
        if(issame){
            cnt[color]++;
            return;
        }
        else{
            int rowLength = (endrow - startrow) / 2;
            int colLength = (endcol - startcol) / 2;
            cut(arr, startrow, startrow+rowLength, startcol, startcol+colLength);
            cut(arr, startrow, startrow+rowLength, startcol+colLength, endcol);
            cut(arr, startrow+rowLength, endrow, startcol+colLength, endcol);
            cut(arr, startrow+rowLength, endrow, startcol, startcol+colLength);
        }
    }
}
