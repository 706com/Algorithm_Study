package BOJ._2_Silver;

import java.util.*;
import java.io.*;

//[250827] : 반례 아직 못찾아서 실패

public class _2910_빈도_정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int max = Integer.parseInt(st.nextToken());

        Map<Integer,Integer> map = new HashMap<>();
        Deque<Integer> deq = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        boolean[] isVisited = new boolean[max+1];
        //map 에 담기
        //갯수 용도
        st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<N; i++){
            int num = Integer.parseInt(st.nextToken());
            map.put(num, map.getOrDefault(num,0)+1);
            deq.offerLast(num);
        }

//        while(!deq.isEmpty()){
//            System.out.println(deq.poll());
//        }
        //max 값 내림차순
        for (Integer x : map.keySet()) {
            pq.add(map.get(x));
        }

        StringBuilder sb = new StringBuilder();
        while(!deq.isEmpty()){
            int num = deq.pollFirst();
//            System.out.println("num = " + num);
            if(isVisited[num]){
                continue;
            }

            if(!pq.isEmpty() && map.get(num)>=pq.peek()){
                for(int i=0; i<map.get(num); i++) {
                    sb.append(num + " ");
                }
                pq.poll();
                isVisited[num] = true;
            } else{
                deq.add(num);
            }

        }

        System.out.println(sb);

    }
}
