import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++) {    
            int sum = 0; // initialize sum for each test case
            for(int i = 0; i < 10; i++) { // read 10 numbers for each test case
                int num = sc.nextInt();
                if(num % 2 == 1) { // if the number is odd, add it to sum
                    sum += num;
                }
            }
            // print the result for this test case
            System.out.printf("#%d %d\n", test_case, sum);
        }
        return;
    }
}
