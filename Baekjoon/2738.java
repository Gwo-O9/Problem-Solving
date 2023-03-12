import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr1 = new int[n][m];
        int[][] arr2 = new int[n][m];
        int i;
        int j;
        for(i = 0;i<n;i++){
            for(j = 0; j<m;j++){
                arr1[i][j] = sc.nextInt();
            }
        }
        for(i = 0;i<n;i++){
            for(j = 0; j<m;j++){
                arr2[i][j] = sc.nextInt();
            }
        }
        for(i = 0;i<n;i++){
            for(j = 0; j<m;j++){
                int d = arr1[i][j] + arr2[i][j];
                System.out.print(d + " ");
            }
            System.out.print("\n");
        }
    }
}
