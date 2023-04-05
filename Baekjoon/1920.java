import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = 0; i<N;i++){
            set.add(sc.nextInt());
        }
        int M = sc.nextInt();
        for(int i = 0;i<M;i++){
            if(set.contains(sc.nextInt())){
                System.out.println(1);
            }
            else System.out.println(0);
        }
    }
}
