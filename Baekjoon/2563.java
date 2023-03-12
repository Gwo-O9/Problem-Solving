import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[][] arr = new int[100][100];
        int i,j,k;
        for(i = 0; i<T;i++){
            int left = sc.nextInt();
            int down = sc.nextInt();
            for(j = 0;j<10;j++){
                for(k = 0; k<10;k++){
                    arr[left+j-1][100-down-k] = 1;
                }
            }
        }
        int cnt = 0;
        for(i = 0; i<100;i++){
            for(j = 0; j<100;j++){
                if(arr[i][j] == 1) cnt++;
            }
        }
        System.out.println(cnt);
    }
}
