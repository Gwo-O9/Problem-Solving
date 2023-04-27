import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> min = new PriorityQueue<>();
            PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String cmd = st.nextToken();
                int value = Integer.parseInt(st.nextToken());
                if (cmd.equals("I")) {
                    min.add(value);
                    max.add(value);
                    map.put(value, map.getOrDefault(value, 0) + 1);
                } else {
                    if (map.isEmpty()) continue;
                    else if (value == 1) {
                        while (!max.isEmpty() && map.get(max.peek()) == 0) {
                            max.poll();
                        }
                        if (!max.isEmpty()) {
                            int a = max.poll();
                            map.put(a, map.get(a) - 1);
                        }
                    } else if (value == -1) {
                        while (!min.isEmpty() && map.get(min.peek()) == 0) {
                            min.poll();
                        }
                        if (!min.isEmpty()) {
                            int b = min.poll();
                            map.put(b, map.get(b) - 1);
                        }
                    }
                }
            }
            if (map.isEmpty()) sb.append("EMPTY\n");
            else {
                while (!max.isEmpty() && map.get(max.peek()) == 0) {
                    max.poll();
                }
                while (!min.isEmpty() && map.get(min.peek()) == 0) {
                    min.poll();
                }
                if (!max.isEmpty() && !min.isEmpty()) {
                    sb.append(max.peek()).append(" ").append(min.peek()).append("\n");
                } else {
                    sb.append("EMPTY\n");
                }
            }
        }
        System.out.println(sb.toString());
    }
}
