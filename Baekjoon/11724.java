import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int T;
    static int[][] graph = new int[1001][1001];
    static boolean[] isvisited = new boolean[1001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //# of Nodes
        T = Integer.parseInt(st.nextToken()); //# of Edges
        int components = 0; //# of Components

        for(int i = 0; i<T;i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            graph[a][b] = graph[b][a] = 1; //Linking Nodes with Edge.
        }

        for(int i = 1; i<n+1;i++){
            if(!isvisited[i]){
                dfs(i);
                components++;
            }
        }
        System.out.println(components);
    }

    private static void dfs(int k){
        if(isvisited[k] == true) return;
        else{
            isvisited[k] = true;
            for(int i = 1; i<n+1; i++){
                if(graph[k][i] == 1) dfs(i);
            }
        }
    }
}
