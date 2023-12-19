package BOJ._2_Silver;
//[백준]1158 : 요세푸스 문제 - JAVA(자바)

//소요시간 : 8분

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1158_요세푸스_문제 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        Queue<Integer> q = new LinkedList<>();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for(int i=1; i<=N; i++){
            q.offer(i);
        }

        sb.append('<');

        int count = 1;
        while(!q.isEmpty()){
            if(count == K){
                sb.append(q.poll()).append(", ");
                count = 0;
            }
            else{
                q.offer(q.poll());
            }
            count++;
        }
        sb.delete(sb.length()-2,sb.length());
        sb.append('>');
        System.out.println(sb);
    }
}
