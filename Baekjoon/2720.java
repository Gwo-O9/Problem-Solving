import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<n;i++){
            int remain = Integer.parseInt(br.readLine());
            sb = new StringBuilder();
            int a = 0;
            int b = 0;
            int c = 0;
            int d = 0;
            while(remain >= 25){
                remain -= 25;
                a++;
            }
            while(remain >= 10){
                remain -= 10;
                b++;
            }
            while(remain >= 5){
                remain -= 5;
                c++;
            }
            while(remain >= 1){
                remain -= 1;
                d++;
            }
            sb.append(a + " " + b + " " + c + " " + d + "\n");
            System.out.print(sb.toString());
        }
    }
}
