package 백준.Silver;
//[백준]1927 : 최소 힙 - JAVA(자바)

//< 나의 알고리즘 >
// linkedlist 를 이용하여 값을 입력받을 때 마다 최솟값 최댓값을 기억해주어 양방향으로 넣다뻈다 하기
// 결국 중간중간 탐색을 해주어야해서 , 시간초과

//< 답안 알고리즘 >
// 우선순위큐 (priority Queue)
// 일반적인 큐(Queue)는 First in-First Out 구조로,
// 어떤 부가적인 조건 없이 먼저 들어온 데이터가 먼저 나가는 구조였습니다.
// 하지만 우선순위 큐(Priority Queue)는 들어간 순서에 상관없이
// '우선순위가 높은 데이터'가 먼저 나오는 것 것을 말합니다.

//< 새로 알게된 것 >
// 낮은 숫자가 우선 순위(오름차순) : new PriorityQueue<>();
// 높은 숫자가 우선 순위(내림차순) : new PriorityQueue<>(Collections.reverseOrder);

//< 궁금한 것 >
//

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class _1927_최소_힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            if(num == 0){
                if(pq.isEmpty()){
                    System.out.println("0");
                }
                else{
                    System.out.println(pq.poll());
                }

            }
            else{
                pq.offer(num);
            }
        }
    }
}


//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//        int N = Integer.parseInt(br.readLine()); // (1 ≤ N ≤ 100,000)
//
//        PriorityQueue<Integer> q = new PriorityQueue<>();
//
//        for(int i=0; i<N; i++){
//            int input = Integer.parseInt(br.readLine());
//            if(input != 0) {
//                q.offer(input);
//                continue;
//            }
//            else{
//                if(q.isEmpty()){
//                    sb.append("0").append("\n");
//                }
//                else{
//                    sb.append(q.poll()).append("\n");
//                }
//            }
//        }
//
//        System.out.println(sb);
//    }