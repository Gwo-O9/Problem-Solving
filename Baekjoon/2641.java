import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        sc.nextLine();
        String target = sc.nextLine().replaceAll(" ", "");
        String reversetarget = "";
        for(int i = 0; i<len;i++){
            if(target.charAt(i) == '1') reversetarget += '3';
            else if(target.charAt(i) == '2') reversetarget += '4';
            else if(target.charAt(i) == '3') reversetarget += '1';
            else if(target.charAt(i) == '4') reversetarget += '2';
        }
        reversetarget = reverseString(reversetarget);
        int n = sc.nextInt();
        sc.nextLine();
        String[] xy = new String[n];
        int[] check = new int[n];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            String temp = sc.nextLine().replaceAll(" ", "");
            xy[i] = temp;
            for (int j = 0; j < len; j++) {
                if (temp.equals(target) || temp.equals(reversetarget)) {
                    check[i] = 1;
                    cnt++;
                    break;
                } else {
                    temp = rotateString(temp);
                }
            }
        }
        System.out.println(cnt);
        for (int i = 0; i < n; i++) {
            if (check[i] == 1) {
                for (int j = 0; j < len; j++) {
                    System.out.print(xy[i].charAt(j) + " ");
                }
                System.out.print("\n");
            }
        }
    }

    private static String reverseString(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }

    private static String rotateString(String str) {
        return str.substring(1) + str.charAt(0);
    }
}
