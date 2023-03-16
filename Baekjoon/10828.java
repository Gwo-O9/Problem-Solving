import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int i = -1;
        int[] s = new int[10001];
        for (int j = 0; j < T; j++) {
            String[] input = br.readLine().split(" ");
            String cmd = input[0];
            if (cmd.equals("push")) {
                i++;
                s[i] = Integer.parseInt(input[1]);
            } else if (cmd.equals("pop")) {
                if (i == -1) System.out.println(-1);
                else {
                    System.out.println(s[i]);
                    s[i] = 0;
                    i--;
                }
            } else if (cmd.equals("size")) System.out.println(i + 1);
            else if (cmd.equals("empty")) {
                if (i == -1) System.out.println(1);
                else System.out.println(0);
            } else if (cmd.equals("top")) {
                if (i == -1) System.out.println(-1);
                else System.out.println(s[i]);
            }
        }
    }
}
