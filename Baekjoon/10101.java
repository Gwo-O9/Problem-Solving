import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] tri = new int[3];
        for(int i = 0; i<3;i++){
            tri[i] = in.nextInt();
        }
        if(tri[0] + tri[1] + tri[2] != 180) System.out.println("Error");
        else if(tri[0] == 60 && tri[1] == 60 && tri[2] == 60) System.out.println("Equilateral");
        else if(tri[0] == tri[1] || tri[0] == tri[2] || tri[1] == tri[2]) System.out.println("Isosceles");
        else System.out.println("Scalene");
        in.close();
    }
}
