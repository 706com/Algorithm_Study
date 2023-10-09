package SWEA;

// < 알고리즘 유형 >
// 우선순위큐

// < 풀이 접근 >
// 1. 0 또는 양의정수를 담는 오름차순 우선순위큐를 선언한다.
// 2. 음수를 담는 내림차순 우선순위큐를 선언한다.
// 3. 값을 담아내는 과정속, (절댓값)최솟값을 도출해낸다.
// 4. while문을 순회하며, 가장 최솟값이 일치할 경우에 num을 증가시킨다.
// 5. 둘 다 비어있거나, 둘 다 빼내는 값이 최솟값과 다를 때 탈출시킨다.


import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.Collections;

public class _1285_아름이의_돌_던지기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int count = 1;

        while(count <= T){
            // 1. 0 또는 양의정수를 담는 오름차순 우선순위큐를 선언한다.
            PriorityQueue<Integer> upHeap = new PriorityQueue<>();  //양수
            // 2. 음수를 담는 내림차순 우선순위큐를 선언한다.
            PriorityQueue<Integer> downHeap = new PriorityQueue<>(Collections.reverseOrder());  //음수

            int N = Integer.parseInt(br.readLine());
            int dist = Integer.MAX_VALUE;
            int num = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            // 3. 값을 담아내는 과정속, (절댓값)최솟값을 도출해낸다.
            for(int i=0; i<N; i++){
                int val = Integer.parseInt(st.nextToken());
                if(val<0){
                    downHeap.offer(val);
                }
                else{
                    upHeap.offer(val);
                }
                dist = Math.min(dist,Math.abs(val));
            }

            boolean breakPoint1 = false;
            boolean breakPoint2 = false;

            while(true){
                // 4. while문을 순회하며, 최솟값이 일치할 경우에 num을 증가시킨다.
                if(!downHeap.isEmpty()) {
                    if(dist == Math.abs(downHeap.poll())){
                        num++;
                    } else{
                        breakPoint1 = true;
                    }
                }
                else if(!upHeap.isEmpty()){
                    if(dist == upHeap.poll()){
                        num++;
                    } else{
                        breakPoint2 = true;
                    }
                }

                // 5. 둘 다 비어있거나, 둘 다 빼내는 값이 최솟값과 다를 때 탈출시킨다.
                if(breakPoint1 && breakPoint2){
                    break;
                }
                if(downHeap.isEmpty() && upHeap.isEmpty()){
                    break;
                }

            }
            System.out.printf("#%d %d %d\n",count,dist,num);
            count++;
        }
    }
}
