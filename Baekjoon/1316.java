import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        int cnt = 0;
        for(int i = 0; i<n;i++){
            boolean isgroup = true;
            HashSet<Character> set = new HashSet<Character>();
            String str = in.nextLine();
            for(int j = 1; j<str.length();j++){
                if(set.contains(str.charAt(j))){
                    isgroup = false;
                    break;
                } 
                if(str.charAt(j) != str.charAt(j-1)) set.add(str.charAt(j-1));
            }
            if(isgroup == true) cnt++;
            set.clear();
        }
        System.out.println(cnt);
    }
}
