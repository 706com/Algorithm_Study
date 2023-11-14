package BOJ._2_Silver;
//[백준]18528 : 큐2 - JAVA(자바)

//< 나의 알고리즘 >
// 양방향 출력을 해야하니 Dequeue 로 구현

//< 답안 알고리즘 >

//< 새로 알게된 것 >

//< 궁금한 것 >

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _18528_큐2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        Deque<Integer> deq = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine()," ");
            String command = st.nextToken();

            switch (command){
                case "push":
                    int num = Integer.parseInt(st.nextToken());
                    deq.offer(num);
                    break;
                case "pop":
                    if(deq.isEmpty()){
                        sb.append("-1").append('\n');
                        break;
                    }
                    sb.append(deq.poll()).append('\n');
                    break;
                case "size":
                    sb.append(deq.size()).append('\n');
                    break;
                case "empty":
                    if(deq.isEmpty()){
                        sb.append("1").append('\n');
                    }
                    else{
                        sb.append("0").append('\n');
                    }
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
