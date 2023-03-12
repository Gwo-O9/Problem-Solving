import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int max = sc.nextInt();
        int[] arr = new int[T];
        int ans = -1;
        for(int t = 0; t<T;t++){
            arr[t] = sc.nextInt();
        }
        for(int i = 0;i<T-2;i++){
            for(int j = i+1;j<T-1;j++){
                for(int k = j+1;k<T;k++){
                    if(arr[i] + arr[j] + arr[k] <= max && ans < arr[i] + arr[j] + arr[k]) ans = arr[i] + arr[j] + arr[k];
                }
            }
        }
        System.out.println(ans);
    }
}
