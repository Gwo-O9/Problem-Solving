import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String pattern = "^(100+1+|01)+$";
        System.out.println(str.matches(pattern) ? "SUBMARINE" : "NOISE");
    }
}
