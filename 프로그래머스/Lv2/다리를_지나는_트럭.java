package 프로그래머스.Lv2;
//[프로그래머스] 다리를 지나는 트럭 - JAVA(자바)

//< 알고리즘 유형 >
// 스택/큐

//< 알고리즘 풀이 >

//< 새로 알게된 것 >

//< 궁금한 것 >

import java.util.LinkedList;
import java.util.Queue;

public class 다리를_지나는_트럭 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> remain = new LinkedList<>();
        Queue<Integer> now  = new LinkedList<>();

        int answer = bridge_length;

        for(int i=0; i<truck_weights.length; i++){
            remain.offer(truck_weights[i]);
        }
        if(remain.size()==1){
            answer++;
            return answer;
        }

        while(!remain.isEmpty()){
            int remains = remain.poll();
            now.offer(remains);
            answer++;

            if(remains + now.peek() <= weight){
                now.poll();
                now.offer(remain.poll());
                answer++;
            }
            else{
                now.poll();
                answer++;
            }
        }
//        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7,4,5,6};

        int bridge_length2 = 100;
        int weight2 = 100;
        int[] truck_weights2 = {10};

        int bridge_length3 = 100;
        int weight3 = 100;
        int[] truck_weights3 = {10,10,10,10,10,10,10,10,10,10};

        다리를_지나는_트럭 sol = new 다리를_지나는_트럭();
        sol.solution(bridge_length,weight,truck_weights);
        sol.solution(bridge_length2,weight2,truck_weights2);
        sol.solution(bridge_length3,weight3,truck_weights3);
    }
}
