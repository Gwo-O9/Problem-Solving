import java.util.Scanner;
import java.io.FileInputStream;
import java.lang.Math.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int max = -1;
            for(int i = 0; i< 10;i++){
                int num = sc.nextInt();
                max = Math.max(max,num);
            }
           	System.out.printf("#%d %d\n", test_case, max);
		}
	}
}
