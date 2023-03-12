import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        int m = 0;
        int max = -1;
        for(int i = 0; i<9;i++){
            for(int j = 0;j<9;j++){
                int d = sc.nextInt();
                if(d>max){
                    max = d;
                    n = i+1;
                    m = j+1;
                }
            }
        }
        System.out.println(max + "\n" + n + " " + m);
    }
}
