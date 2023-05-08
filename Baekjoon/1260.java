import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N,M,V;
    static int[][] Graph;
    static boolean[] isvisited;
    static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // # of Nodes
        M = Integer.parseInt(st.nextToken()); // # of Edges
        V = Integer.parseInt(st.nextToken()); // Starting point
        Graph = new int[N+1][N+1];
        isvisited = new boolean[N+1];
        for(int i = 0; i<M;i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            Graph[a][b] = Graph[b][a] = 1;
        }
        dfs(V);
        sb.append("\n");
        Arrays.fill(isvisited,false);
        bfs(V);
        System.out.println(sb.toString());
    }

    private static void dfs(int i){
        isvisited[i] = true;
        sb.append(i + " ");
        for(int j = 0; j<=N;j++){
            if(Graph[i][j] == 1 && !isvisited[j]) dfs(j);
        }
    }
    private static void bfs(int i){
        isvisited[i] = true;
        q.add(i);
        while(!q.isEmpty()){
            i = q.poll();
            sb.append(i + " ");
            for(int j = 0; j<=N;j++){
                if(Graph[i][j] == 1 && !isvisited[j]){
                    q.add(j);
                    isvisited[j] = true;
                }
            }
        }
    }
}
