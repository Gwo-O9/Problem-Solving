import java.util.*;
import java.io.*;
import java.math.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<String>();
        int cnt = 0;
        for(int i = 0;i<n;i++){
            String ID = br.readLine();
            if(ID.equals("ENTER")) set.clear();
            else{
                if(set.contains(ID)) continue;
                else{
                    set.add(ID);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
