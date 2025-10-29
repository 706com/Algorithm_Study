package BOJ._2_Silver;

//[251030] : 6분

import java.util.*;
import java.io.*;

public class _2161_카드1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> q = new ArrayDeque<>();
        for(int i=1; i<=N; i++){
            q.offer(i);
        }

        while(!q.isEmpty()){
            sb.append(q.poll()+" ");
            if(q.isEmpty()){
                break;
            }
            q.offer(q.poll());
        }

        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }
}
