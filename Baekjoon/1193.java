import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        int index = 0;
        int numerator = 0;
        int denominator = 0;
        if(n == 1) System.out.println("1/1");
        else{
            while(sum < n){
                index++;
                sum = (index*(index+1))/2;
            }
            int a = n - (index*(index-1))/2;
            if(index%2 == 0){
                numerator = a;
                denominator = index - a + 1;
            }
            else{
                numerator = index - a +1;
                denominator = a;
            }
            System.out.println(numerator + "/" + denominator);
        }
    }
}
