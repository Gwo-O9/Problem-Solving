import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int[] array = new int[10];
		int[] modarr = new int[10];
		int[] count = new int[10];
		int cnt = 0;

		for(int i = 0;i<10;i++){
		    array[i] = scan.nextInt();
		    modarr[i] = array[i]%42;
		    count[i] = 0;
		}
		for(int k = 0;k<10;k++){
		    for(int j = k+1;j<10;j++){
			if(modarr[k] == modarr[j]) count[k]++;
		    }
		}
		for(int e = 0;e<10;e++){
		    if(count[e] == 0){
			cnt++;
		    }
		}
		System.out.println(cnt);
	}
}
