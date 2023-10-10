package 백준.Gold;

// < 알고리즘 유형 >
// 그리디

// < 풀이 접근 >
// *. 깡구현.... (이게 되네)
// 1. 양수(내림차순) , 음수+0(오름차순) 으로 우선순위큐를 구현한다.

// 2. 양수 keyPoint :
// -> size >= 2 일 때 :
//      -> 뽑은수(first)가 1 이 아닐 때: second 확인
//          -> 두번째(second) 뽑은 수가 1이 아닐때 : first * second
//          -> 두번째(second) 뽑은 수가 1일 때 : first + second

//      -> 뽑은수(first)가 1일 때 : 더한다.
// -> size == 1 일 때 : 무조건 더한다

// 3. 음수 keyPoint :
// -> size() >= 2 : 두 수를 무조건 곱한다. (음수 상쇄)
// -> size() == 1 : 무조건 더한다

// 4. 둘 다 비어있으면 탈출한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.PriorityQueue;
import java.util.Collections;

public class _1744_수_묶기 {
    public static void main(String[] args) throws IOException {
        // 1. 양수(내림차순) , 음수+0(오름차순) 으로 우선순위큐를 구현한다.
        PriorityQueue<Integer> upHeap = new PriorityQueue<>();  //음수
        PriorityQueue<Integer> downHeap = new PriorityQueue<>(Collections.reverseOrder());  //양수

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            if(num<=0){
                upHeap.offer(num);
            } else{
                downHeap.offer(num);
            }
        }

        int result = 0;

        while(true){
            // 2. < 양수 >
            // -> size >= 2 일 때 :
            if(downHeap.size() >= 2) {
                // -> 뽑은수(first)가 1 이 아닐 때: second 확인
                if(downHeap.peek() != 1) {
                    int temp = downHeap.poll();
                    // -> 두번째(second) 뽑은 수가 1이 아닐때 : first * second
                    if(downHeap.peek() != 1){
                        result += temp * downHeap.poll();
                    }
                    else{ // -> 두번째(second) 뽑은 수가 1일 때 : first + second
                        result += temp;
                        result += downHeap.poll();
                    }
                }
                // -> 뽑은수(first)가 1일 때 : 더한다.
                else{
                    result += downHeap.poll();
                }
            }
            // -> size == 1 일 때 : 무조건 더한다
            else if(downHeap.size() == 1){
                result += downHeap.poll();
            }

            // 3. < 음수 > (0 포함)
            // -> size() >= 2 : 두 수를 무조건 곱한다. (음수 상쇄)
            if(upHeap.size() >= 2){
                result += upHeap.poll() * upHeap.poll();
            }

            // -> size() == 1 : 무조건 더한다
            else if(upHeap.size() == 1){
                result += upHeap.poll();
            }

            // 4. 둘 다 비어있으면 탈출한다.
            if(downHeap.isEmpty() && upHeap.isEmpty()){
                break;
            }
        }

        System.out.println(result);
    }
}
