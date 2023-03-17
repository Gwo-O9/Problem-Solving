import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int[] arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = i+1;
        }
        for(int i=0;i<M;i++){
            int start = in.nextInt()-1;
            int end = in.nextInt()-1;
            int mid = in.nextInt()-1;
            int[] temp = new int[end-start+1];
            for(int j=0;j<temp.length;j++){
                temp[j] = arr[start+j];
            }
            int index = 0;
            for(int j=0;j<temp.length;j++){
                if(j<end-mid+1){
                    arr[start+j] = temp[mid-start+j];
                }
                else{
                    arr[start+j] = temp[index++];
                }
            }
        }
        for(int i=0;i<N;i++){
            System.out.print(arr[i] + " ");
        }
    }
}
