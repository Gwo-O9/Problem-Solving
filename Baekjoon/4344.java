import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            int n = in.nextInt();
            int[] arr = new int[n];
            int sum = 0;
            for (int j = 0; j < n; j++) {
                arr[j] = in.nextInt();
                sum += arr[j];
            }
            double mean = (double) sum / n;
            int cnt = 0;
            for (int k = 0; k < n; k++) {
                if (arr[k] > mean) cnt++;
            }
            double ans = (double) cnt / n * 100;
            System.out.println(String.format("%.3f", ans) + "%");
        }
    }
}
