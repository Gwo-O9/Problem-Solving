import java.util.*;
import java.io.*;

class node{
    int index;
    int dist;
    node(int index, int dist){
        this.index = index;
        this.dist = dist;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int nodes = Integer.parseInt(st.nextToken());
        int edges = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<node>> graph = new ArrayList<ArrayList<node>>();
        int[] dist = new int[nodes+1];
        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < nodes+1; i++){
            graph.add(new ArrayList<node>());
        }

        for(int i = 1; i<=edges;i++){ // u -> v (w)
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new node(v,w));
        } 

        for(int i = 1; i<=nodes;i++){ //Initialize the dist 
            dist[i] = Integer.MAX_VALUE;
        } 

        //PriorityQueue for dijakstra algorithm
        PriorityQueue<node> pq = new PriorityQueue<node>((a,b) -> Integer.compare(a.dist,b.dist));
        pq.offer(new node(start, 0));
        dist[start] = 0;    

        while(!pq.isEmpty()){
            node tmpnode = pq.poll();

            if (dist[tmpnode.index] < tmpnode.dist) continue;

            for(node tmp : graph.get(tmpnode.index)){
                if(dist[tmp.index] > tmpnode.dist + tmp.dist) {
                    dist[tmp.index] = tmpnode.dist + tmp.dist;
                    pq.offer(new node(tmp.index, dist[tmp.index]));
                }
            }
        }

        for(int i = 1; i<=nodes;i++){
            if(dist[i] == Integer.MAX_VALUE) bw.write("INF\n");
            else bw.write(dist[i] + "\n");
        }
        bw.flush();
        bw.close();
    }
}
