import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        for(int i = 0;i<n;i++){
            String temp = in.nextLine();
            int len = temp.length();
            int count = 1;
            int sum = 0;
            for(int j = 0; j<len;j++){
                if(temp.charAt(j) == 'O'){
                    sum += count;
                    count++;
                }
                else count = 1;
            }
            System.out.println(sum);
        }
    }
}
