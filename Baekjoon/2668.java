import java.util.*;
import java.io.*;

public class Main{
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n+1];
        int[] ans = new int[n];
        boolean[] visited = new boolean[n+1];
        int index = 0;
        for(int i = 1;i<=n;i++){
            arr[i] = sc.nextInt();
        }
        for(int i = 1; i<=n;i++){
            if(dfs(visited,arr,i,i)) ans[index++] = i; 
            Arrays.fill(visited, false);
        }
        Arrays.sort(ans);
        System.out.println(index);
        for(int element : ans){
            if(element == 0) continue;
            System.out.println(element);
        }
    }

    private static boolean dfs(boolean[] visited, int[] arr, int target, int curr){
        if(visited[curr] == false){
            visited[curr] = true;
            return dfs(visited, arr, target, arr[curr]);
        }
        else{
            if(target == curr) return true;
            else return false;
        }
    }
}
