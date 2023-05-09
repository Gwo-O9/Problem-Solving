import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nA = Integer.parseInt(st.nextToken());
        int nB = Integer.parseInt(st.nextToken());
        HashSet<Integer> setA = new HashSet<Integer>();
        HashSet<Integer> setB = new HashSet<Integer>();
        StringTokenizer stA = new StringTokenizer(br.readLine());
        StringTokenizer stB = new StringTokenizer(br.readLine());
        int[] arrA = new int[nA];
        int[] arrB = new int[nB];
        int cnt = 0;
        for(int i = 0; i<nA;i++){
            int a = Integer.parseInt(stA.nextToken());
            setA.add(a);
            arrA[i] = a;
        }
        for(int i = 0; i<nB;i++){
            int b = Integer.parseInt(stB.nextToken());
            setB.add(b);
            arrB[i] = b;
        }
        for(int i = 0; i<nA;i++){
            if(!setB.contains(arrA[i])) cnt++;
        }
        for(int i = 0; i<nB;i++){
            if(!setA.contains(arrB[i])) cnt++;
        }
        System.out.println(cnt);
    }
}
