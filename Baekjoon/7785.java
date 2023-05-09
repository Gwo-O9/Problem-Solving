import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String human = st.nextToken();
            String cmd = st.nextToken();
            if(cmd.equals("enter")) set.add(human);
            else set.remove(human);
        }
        for (String s : set) {
            list.add(s);
        }
        Collections.sort(list, Collections.reverseOrder());
        for(String str: list){
            sb.append(str + "\n");
        }
        System.out.println(sb.toString());
    }
}
