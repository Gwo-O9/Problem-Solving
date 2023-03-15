import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i<n;i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int l = 0;
        int r = 1;
        while(r<n && l<n){
            int temp = arr[r] - arr[l];
            if(temp >= m) {
                ans = Math.min(ans, temp);
                l++;
            }
            else r++;
        }
        System.out.println(ans);
    }
}
