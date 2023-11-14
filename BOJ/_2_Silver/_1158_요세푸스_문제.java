package BOJ._2_Silver;
//[백준]1158 : 요세푸스 문제 - JAVA(자바)

//< 나의 알고리즘 >
// Queue를 이용한다.

//< 답안 알고리즘 >

//< 새로 알게된 것 >

//< 궁금한 것 >

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1158_요세푸스_문제 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        Queue<Integer> q = new LinkedList<>();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for(int i=1; i<=N; i++){
            q.offer(i);
        }
        sb.append('<');

        while(!q.isEmpty()){
            for(int i=0; i<K-1; i++){
                q.offer(q.poll());
            }
            sb.append(q.poll()).append(", ");
        }

        // 마지막 ', ' 삭제
        sb.deleteCharAt(sb.length()-1).deleteCharAt(sb.length()-1);
        sb.append('>');
        System.out.println(sb);
    }
}
