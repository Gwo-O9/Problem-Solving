import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] arr = new char[5][15];
        int i;
        int j;
        for(i = 0; i<5;i++){
            Arrays.fill(arr[i],'-');
            String temp = sc.nextLine();
            for(j = 0; j<temp.length();j++){
                arr[i][j] = temp.charAt(j);
            }
        }
        for(i = 0;i<15;i++){
            for(j = 0;j<5;j++){
                if(arr[j][i] == '-') continue;
                else System.out.print(arr[j][i]);
            }
        }
    }
}
