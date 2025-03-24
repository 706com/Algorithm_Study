package BOJ._3_Gold;

//[250325] 🔍

import java.util.*;
import java.io.*;

public class _1715_카드_정렬하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Long> pq = new PriorityQueue<>();

        for(int i=0; i<N; i++){
            pq.offer(Long.parseLong(br.readLine()));
        }

        long result = 0;
        while(pq.size()>=2){
            long num1= pq.poll();
            long num2 = pq.poll();

            result += (num1+num2);
            pq.offer(num1+num2);
        }
        System.out.println(result);
    }
}
