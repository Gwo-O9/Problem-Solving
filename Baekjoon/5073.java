import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(true){
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            int[] tri = {a,b,c};
            Arrays.sort(tri);
            if(a == 0 && b == 0 && c == 0) return;
            else if(tri[2] >= tri[0] + tri[1]) System.out.println("Invalid");
            else if(a == b && b == c && c == a) System.out.println("Equilateral");
            else if(a == b || b == c || c == a) System.out.println("Isosceles");
            else System.out.println("Scalene");
        }
    }
}
