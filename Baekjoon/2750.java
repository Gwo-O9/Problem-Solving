import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] arr = new int[T];
        int i;
        for(i = 0; i<T;i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        for(i = 0; i<T;i++){
            System.out.println(arr[i]);
        }
        sc.close();
    }
}
