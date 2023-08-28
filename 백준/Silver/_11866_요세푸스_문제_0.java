package 백준.Silver;
//[백준]11651 : 요세푸스 문제 0 - JAVA(자바)

//< 알고리즘 유형 >
// 큐 , 연결리스트

//< 알고리즘 풀이 >
// 1) StringBuilder 를 활용하여 문자열 처리.
// 2) K값에 따른 삽입,삭제

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _11866_요세푸스_문제_0 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new LinkedList<>();

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

        // 마지막 두글자 삭제 ", "
        sb.deleteCharAt(sb.length()-1).deleteCharAt(sb.length()-1).append('>');
        System.out.println(sb);
    }
}
