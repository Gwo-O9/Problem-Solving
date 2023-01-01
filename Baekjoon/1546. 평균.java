import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        float[] score = new float[n];
        float MAX = 0;
        for(int i = 0;i<n;i++){
            score[i] = scan.nextFloat();
            if(MAX <= score[i]) MAX = score[i];
        }
        float sum = 0;
        for(int i = 0; i<n;i++){
            score[i] = score[i]/MAX*100;
            sum += score[i];
        }
        System.out.println((float) sum/n);
    }
}
