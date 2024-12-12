package BOJ._2_Silver;

//[241212] 10분

import java.io.*;
import java.util.*;

public class _1417_국회의원_선거 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ds = Integer.parseInt(br.readLine());
        int result = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<N-1; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }
        while(!pq.isEmpty()){
            if(ds>pq.peek()){
                break;
            }
            ds+=1;
            result++;
            pq.add(pq.poll()-1);
        }
        System.out.println(result);
    }
}
