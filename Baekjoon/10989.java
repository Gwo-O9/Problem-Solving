import java.util.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        int[] count = new int[10001];
        int i;
        int j;
        for(i = 0;i<n;i++){
            count[Integer.parseInt(bf.readLine())]++;
        }
        for(i = 0;i<10001;i++){
            for(j = 0;j<count[i];j++){
                sb.append(i);
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
