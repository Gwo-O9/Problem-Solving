import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long hash = 0;
        String temp = in.next();
        long h = 1;
        for(int i = 0; i<n;i++){
            char a = temp.charAt(i);
            hash += ((long)(a-96)* h);
            h *= 31;
            h %= 1234567891;
        }
        hash %= 1234567891;
        System.out.println(hash);
    }
}
