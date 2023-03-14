import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[T];
        int i;
        for(i = 0; i<T;i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        System.out.println(arr[T-k]);
        sc.close();
    }
}
