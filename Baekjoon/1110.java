import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int first = n;
        n = ((n%10)*10) + ((n%10+n/10)%10);
        int count = 1;
        
        while(first != n){
            n = ((n%10)*10) + ((n%10+n/10)%10);
            count++;
        }
        System.out.println(count);
    }
}
