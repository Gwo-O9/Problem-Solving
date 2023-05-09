import java.util.*;
import java.io.*;

/*
 * 창문이 열려 있다 == 열리고 닫힌 횟수가 홀수이다.
 * 약수가 홀수인 수는 제곱수가 유일.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println((int)Math.sqrt(n));
    }
}
