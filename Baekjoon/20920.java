import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int minlen = Integer.parseInt(st.nextToken());
        HashSet<String> set = new HashSet<String>();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(int i = 0; i<n;i++){
            String word = br.readLine();

            //Check whether word's length is longer than minimum length
            if(word.length() < minlen) continue; 

            //Check whther the word is already checked
            if(set.contains(word)) {
                map.put(word, map.get(word)+1);
                continue;
            }

            set.add(word);
            map.put(word, 1);
        }

        List<String> words = map.keySet().stream().collect(Collectors.toList());
        words.sort((a, b) -> {
            if(map.get(a) == map.get(b)) {
                if(a.length() == b.length()){
                    return a.compareTo(b);
                }
                return b.length() - a.length();
            }
            return map.get(b) - map.get(a);
        });

        for(String tmp : words) bw.write(tmp + "\n");

        bw.flush();
        bw.close();
    }
}
