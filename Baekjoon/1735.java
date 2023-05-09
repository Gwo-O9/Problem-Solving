//1735.java

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken()); // a/b -- 1st fraction
        st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken()); 
        int d = Integer.parseInt(st.nextToken()); // c/d -- 2nd fraction
        int numerator = a*d + b*c;
        int denominator = b*d;
        int g = gcd(numerator, denominator);
        System.out.println(numerator/g + " " + denominator/g);
        }

    private static int gcd(int a, int b){
        int c;
        while(b!=0){
            c = a%b;
            a = b;
            b = c;
        }
        return a;
    }

    private static int lcd(int a, int b){
        return a*b/gcd(a,b);
    }
}
