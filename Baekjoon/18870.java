import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<Integer>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int index = 0;
        int[] arr2 = new int[n];
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken()); 
        }
        
        for(int i = 0; i<n;i++){
            if(set.contains(arr[i])) continue;
            else {
                set.add(arr[i]);
                arr2[index++] = arr[i];
            }
        }
        int[] arr3 = Arrays.copyOf(arr2, index);
        Arrays.sort(arr3);
        for(int i = 0; i<index;i++){
            map.put(arr3[i],i);
        }
        for(int i = 0; i<n;i++){
            sb.append(map.get(arr[i]) + " ");
        }
        System.out.println(sb.toString());
    }
}
