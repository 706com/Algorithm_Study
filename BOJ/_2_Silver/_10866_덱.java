package BOJ._2_Silver;
//[백준]10866 : 덱 - JAVA(자바)

//덱 : 앞 뒤 어디서든지 삽입과 삭제가 가능한 양방향 자료구조

//소요시간 : 7분

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _10866_덱 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> deq = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());
        int num;

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch(command){
                case "push_front":
                    num = Integer.parseInt(st.nextToken());
                    deq.offerFirst(num);
                    break;
                case "push_back":
                    num = Integer.parseInt(st.nextToken());
                    deq.offerLast(num);
                    break;
                case "pop_front":
                    if(deq.isEmpty()){
                        sb.append("-1").append('\n');
                        break;
                    }
                    sb.append(deq.pollFirst()).append('\n');
                    break;
                case "pop_back":
                    if(deq.isEmpty()){
                        sb.append("-1").append('\n');
                        break;
                    }
                    sb.append(deq.pollLast()).append('\n');
                    break;
                case "size":
                    sb.append(deq.size()).append('\n');
                    break;
                case "empty":
                    if(deq.isEmpty()){
                        sb.append("1").append('\n');
                        break;
                    }
                    sb.append("0").append('\n');
                    break;
                case "front":
                    if(deq.isEmpty()){
                        sb.append("-1").append('\n');
                        break;
                    }
                    sb.append(deq.peekFirst()).append('\n');
                    break;
                case "back":
                    if(deq.isEmpty()){
                        sb.append("-1").append('\n');
                        break;
                    }
                    sb.append(deq.peekLast()).append('\n');
                    break;
            }
        }
        System.out.println(sb);
    }
}
