package 백준_Solved_Class_3;
//[백준]7662 : 이중 우선순위 큐 - JAVA(자바)

//< 나의 알고리즘 >
// 우선순위 큐 이므로 PriorityQueue 로 접근
// 막힘 : Deque 와 우선순위 큐를 어떻게 합쳐서 사용할지 모르겠음.

//< 답안 알고리즘 >

//< 새로 알게된 것 >
// PriorityQueue<Integer> Q = new PriorityQueue<>() 오름차순
// PriorityQueue<Integer> Q = new PriorityQueue<>(Collections.reverseOrder()) 내림차순

//< 궁금한 것 >


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _7662_이중_우선순위_큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());    //테스트 데이터

        while(T-- > 0){
            int k = Integer.parseInt(br.readLine());    //적용할 연산의 개수  (k ≤ 1,000,000)
            PriorityQueue<Integer> Q = new PriorityQueue<>();

            for(int i=0; i<k; i++){
                StringTokenizer st = new StringTokenizer(br.readLine()," ");
                String command  = st.nextToken();
                int value = Integer.parseInt(st.nextToken());

                if(command.equals("I")) {
                    Q.offer(value);
                } else if(command.equals("D")){
                    if(value == 1){
                        Q.poll();
                    } else if (value == -1){
                        //Q.poll();
                    }
                }
            }

        }

    }
}
