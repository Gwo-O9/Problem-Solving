import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            int n = sc.nextInt();
            if(n == -1) break;
            StringBuilder sb = new StringBuilder();
            sb.append(n);
            sb.append(" = 1");
            int sum = 1;
            for(int i = 2;i<n;i++){
                if(n%i == 0) {
                    sb.append(" + ");
                    sb.append(i);
                    sum += i;
                }
            }
            if(sum == n) System.out.print(sb.toString().trim()+"\n");
            else{
                System.out.print(n + " is NOT perfect.\n");
            }
        }
    }
}
