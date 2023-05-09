import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 2;
        for(int i = 1; i<=n;i++) cnt += cnt-1;
        cnt = (int)Math.pow(cnt,2);
        System.out.println(cnt);
    }
}
