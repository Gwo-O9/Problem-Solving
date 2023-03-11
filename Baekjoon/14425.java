import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        in.nextLine();
        HashSet<String> set = new HashSet<String>();
        int i = 0;
        int cnt = 0;
        for(i = 0; i<a;i++){
            set.add(in.nextLine());
        }
        for(i = 0; i<b;i++){
            if(set.contains(in.nextLine())) cnt++;
        }
        System.out.println(cnt);
    }
}
