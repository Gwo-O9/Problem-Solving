import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(true){
            boolean isp = true;
            int n = in.nextInt();
            if(n == 0) return;
            String temp = Integer.toString(n);
            for(int i = 0;i<temp.length()/2;i++){
                if(temp.charAt(i) != temp.charAt(temp.length()-1-i)){
                    isp = false;
                    break;
                }
            }
            if(isp == true) System.out.println("yes");
            else System.out.println("no");
        }
    }
}
