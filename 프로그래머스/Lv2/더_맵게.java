package 프로그래머스.Lv2;
//[프로그래머스] 다리를 지나는 트럭 - JAVA(자바)

//< 알고리즘 유형 >
// 힙

//< 알고리즘 풀이 >
// priority Queue 로 진행

//< 새로 알게된 것 >
// 주의!! : 테스트케이스가 1개여서 안주하지 말고, 예외 늘 생각하기 (특히 범위)

//< 궁금한 것 >

import java.util.PriorityQueue;

public class 더_맵게 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Q에 음식 넣기
        for(int x : scoville){
            pq.offer(x);
        }

        int min = pq.peek();
        int count = 0;

        // 최소 스코빌지수 찾기
        while(min<K && pq.size()>=2){
            int first = pq.poll();
            int second = pq.poll();

            // 새로운 음식 만들어서 넣기
            int newFood = first + second*2;
            pq.offer(newFood);

            min = pq.peek();
            count++;
        }
        if(min<K){
            answer = -1;
            System.out.println(answer);
            return answer;
        }
        answer = count;
        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        int[] scoville = {7};
        int K = 7;

        더_맵게 sol = new 더_맵게();
        sol.solution(scoville,K);
    }
}
