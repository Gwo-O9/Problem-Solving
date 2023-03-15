import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        int cnt = 0;
        int i;
        HashSet<Integer> set = new HashSet<Integer>();
        for(i = 0; i<n;i++){
            arr[i] = in.nextInt();
            set.add(arr[i]);
        }
        int x = in.nextInt();
        for(i = 0; i<n; i++){
            if(set.contains(x - arr[i])) cnt++;
        }
        System.out.println(cnt/2);
    }
}
