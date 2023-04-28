import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> ppq = new PriorityQueue<>();
        PriorityQueue<Integer> npq = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<n;i++){
            int num = Integer.parseInt(br.readLine());
            if(num == 0){
                Integer pn = ppq.poll();
                Integer nn = npq.poll();
                if(pn == null && nn == null){
                    sb.append("0\n");
                    continue;
                } else{
                    if(pn == null) {
                        sb.append(nn + "\n");
                    } else if(nn == null){
                        sb.append(pn + "\n");
                    } else{
                        if(Math.abs(nn) <= pn){
                            sb.append(nn + "\n");
                            ppq.add(pn);
                        } else{
                            sb.append(pn + "\n");
                            npq.add(nn);
                        }
                    }
                }
            } else{
                if(num > 0){
                    ppq.add(num);
                } else{
                    npq.add(num);
                }
            }
        }
        System.out.println(sb.toString());
    }
}
