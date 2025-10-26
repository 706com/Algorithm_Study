package BOJ._2_Silver;
//[백준]1158 : 요세푸스 문제 - JAVA(자바)

//소요시간 : 8분
//[251026] : 10분

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1158_요세푸스_문제 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        //입력
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=1; i<=N; i++){
            q.offer(i);
        }

        // 순열 돌리기
        int cnt = 0;
        while(!q.isEmpty()){
            cnt++;
            if(cnt == K){
                sb.append(q.poll()+", ");
                cnt = 0;
            } else{
                q.offer(q.poll());
            }
        }
        sb.delete(sb.length()-2,sb.length());
        sb.append(">");

        System.out.println(sb);
    }
}
