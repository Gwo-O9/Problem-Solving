import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = 20;
        double sum1 = 0;
        double sum = 0;
        for(int i = 0; i<T;i++){
            String str = sc.next();
            double w = sc.nextDouble();
            String a = sc.next();
            sc.nextLine();
            if(a.equals("P")) continue;
            sum1 += w;
            switch (a){
                case "A+" :
                    sum += (4.5)*w;
                    break;
                case "A0" :
                    sum += (4.0)*w;
                    break;
                case "B+" :
                    sum += (3.5)*w;
                    break;
                case "B0" :
                    sum += (3.0)*w;
                    break;
                case "C+" :
                    sum += (2.5)*w;
                    break;
                case "C0" :
                    sum += (2.0)*w;
                    break;
                case "D+" :
                    sum += (1.5)*w;
                    break;
                case "D0" :
                    sum += (1.0)*w;
                    break;
                case "F" :
                    sum += (0.0)*w;
                    break;
            }
        }
        System.out.printf("%.6f", sum/sum1);
    }
}
