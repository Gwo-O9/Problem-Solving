import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = 8;
        boolean asc = false;
        boolean desc = false;
        int[] arr = new int[8];
        for(int i =0; i<8;i++){
            arr[i] = in.nextInt();
            if(i == 0) continue;
            if(arr[i-1] < arr[i]) asc = true;
            else desc = true;
        }
        if(asc == true && desc == true) System.out.println("mixed");
        else if(asc == true) System.out.println("ascending");
        else System.out.println("descending");
        in.close();
    }
}
