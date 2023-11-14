package BOJ._3_Gold;

// < 알고리즘 유형 >
// 자료구조, 우선순위 큐

// < 풀이 접근 >
// *. 고민 : 처음에 Deque 를 생각했으나, 가운데에 끼워넣는 과정도 있으므로 불가능 (x).
// *. 어떻게 하면 가운데값을 실시간으로 파악하면서 출력시킬 수 있을까?
// *. -> priority Queue 를 2개 구현하여,가운데값을 실시간으로 파악한다.
// 1. priority queue 를 2개 생성한다. (한 개는 최대힙, 한 개는 최소힙)
// 2. 최대힙에 먼저 넣고 그 다음 최소힙에 넣는다.
//  -> 넣는 순서 : 최대힙 -> 최소힙 -> 최대힙 -> 최소힙 순
// 3. 이때 최소힙에 넣는 값이 최대힙안에 있는 값보다 작으면, swap 을 해준다.
// 4. 출력값은 모두 최대힙의 peek 값을 한다면, 늘 중간값을 출력 가능하다.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.PriorityQueue;
import java.util.Collections;

public class _1655_가운데를_말해요 {
    public static void main(String[] args) throws IOException{
        // 1. priority queue 를 2개 생성한다. (한 개는 최대힙, 한 개는 최소힙)
        PriorityQueue<Integer> pqMax = new PriorityQueue<>(Collections.reverseOrder()); // 최대힙
        PriorityQueue<Integer> pqMin = new PriorityQueue<>();   //최소힙

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());

            // 2. 최대힙에 먼저 넣고 그 다음 최소힙에 넣는다.
            //  -> 넣는 순서 : 최대힙 -> 최소힙 -> 최대힙 -> 최소힙 순
            if(pqMax.size() <= pqMin.size()){
                pqMax.offer(num);
            } else{
                pqMin.offer(num);
            }

            //  3. 이때 최소힙에 넣는 값이 최대힙안에 있는 값보다 작으면, swap 을 해준다.
            if(pqMax.size()>0 && pqMin.size()>0 && pqMax.peek() > pqMin.peek()){
                int temp = pqMin.poll();
                pqMin.offer(pqMax.poll());
                pqMax.offer(temp);
            }

            // 4. 출력값은 모두 최대힙의 peek 값을 한다면, 늘 중간값을 출력 가능하다.
            sb.append(pqMax.peek()).append('\n');
        }

        System.out.println(sb);
    }
}
