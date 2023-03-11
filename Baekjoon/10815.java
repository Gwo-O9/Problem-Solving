import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        HashSet<Integer> set = new HashSet<Integer>();
        int i = 0;
        for(i = 0; i<a;i++){
            set.add(in.nextInt());
        }
        int b = in.nextInt();
        int[] ans = new int[b];
        for(i = 0; i<b;i++){
            if(set.contains(in.nextInt())) ans[i] = 1;
        }
        for(i = 0; i<b;i++){
            System.out.print(ans[i] + " ");
        }
    }
}
