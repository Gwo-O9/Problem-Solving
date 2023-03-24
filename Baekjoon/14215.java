import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] tri = new int[3];
        for(int i = 0; i<3;i++){
            tri[i] = in.nextInt();
        }
        Arrays.sort(tri);
        if(tri[0] + tri[1] > tri[2] || (tri[0] == tri[1] && tri[0] == tri[2] && tri[1] == tri[2])){
            System.out.println(tri[0] + tri[1] + tri[2]);
        }
        else{
            System.out.println(tri[0] + tri[1] + tri[0] + tri[1] - 1);
        }
    }
}
