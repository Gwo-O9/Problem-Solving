import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = new String(br.readLine());
        int n = str.length();
        int sum = 0;
        boolean afterminus = false;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<n;i++){

            if(str.charAt(i) != '-' && str.charAt(i) != '+') {
                sb.append(str.charAt(i));
            }
            else{
                if(!afterminus) sum += Integer.parseInt(sb.toString());
                else sum -= Integer.parseInt(sb.toString());
                sb.delete(0, sb.length());
            }

            if(str.charAt(i) == '-') afterminus = true;
        }
        if(afterminus) sum -= Integer.parseInt(sb.toString());
        else sum += Integer.parseInt(sb.toString());
        System.out.println(sum);
    }
}
