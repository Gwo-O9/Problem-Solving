import java.util.*;
import java.io.*;

public class Main{
    static int index = 0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        int ans = 0;
        int[] temp = new int[n * n];
        int k = 0;
        for(int i = 0; i < n; i++){
            String input = sc.next();
            for(int j = 0; j < n; j++){
                arr[i][j] = Character.getNumericValue(input.charAt(j));;
                visited[i][j] = false;
            }
        }
    
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(visited[i][j] == false && arr[i][j] == 1){
                    index = 0;
                    ans++;
                    helper(arr, visited, n, i, j);
                    temp[k++] = index;
                }
            }
        }
    
        System.out.println(ans);
        int[] result = new int[ans];
        for (int i = 0, j = 0; i < temp.length; i++) {
            if (temp[i] != 0) {
                result[j++] = temp[i];
            }
        }
    
        Arrays.sort(result);
        for (int element : result) {
            System.out.println(element);
        }
    }

    public static void helper(int[][] arr, boolean[][] visited, int n, int i, int j){
        if(i >= n || j >= n || i < 0 || j < 0) return;
        if(visited[i][j] || arr[i][j] == 0) {
            visited[i][j] = true;
            return;
        }
        index++;
        visited[i][j] = true;
        helper(arr,visited,n,i+1,j);
        helper(arr,visited,n,i-1,j);
        helper(arr,visited,n,i,j+1);
        helper(arr,visited,n,i,j-1);
    }
}
