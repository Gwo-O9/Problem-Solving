import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String str = br.readLine();
        LinkedList<Character> ans = new LinkedList<>();

        for(int i = 0; i<str.length();i++){
            ans.add(str.charAt(i));
        }

        int n = Integer.parseInt(br.readLine());

        ListIterator<Character> itr = ans.listIterator();
        while(itr.hasNext()){
            itr.next();
        }

        for(int i = 0; i<n;i++){
            String cmd = br.readLine();
            char c = cmd.charAt(0);

            switch(c){
                case 'L':
                    if(itr.hasPrevious()) itr.previous();
                    break;
                case 'D':
                    if(itr.hasNext()) itr.next();
                    break;
                case 'B':
                    if(itr.hasPrevious()) {
                        itr.previous();
                        itr.remove();
                    }
                    break;
                case 'P':
                    itr.add(cmd.charAt(2));
                    break;
                default:
                    break;
            }
        }
        for(char a : ans) bw.write(a);
        bw.flush();
        bw.close();
    }
}
