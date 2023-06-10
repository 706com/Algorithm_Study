package 프로그래머스.Lv2;
//[프로그래머스] 다리를 지나는 트럭 - JAVA(자바)

//< 알고리즘 유형 >
// 스택/큐

//< 알고리즘 풀이 >
// ?

//< 새로 알게된 것 >

//< 궁금한 것 >

import java.util.LinkedList;
import java.util.Queue;

public class 다리를_지나는_트럭 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> q = new LinkedList<>();

        int answer = bridge_length;
        int time = 0;
        int weightSum = 0;

        for(int i=0; i<truck_weights.length; i++){

            while(true) {
                // 1) q가 비어있을 때 : 다리가 텅텅 비었을 때
                // -> 트럭 삽입.
                if (q.isEmpty()) {
                    q.offer(truck_weights[i]);
                    weightSum += truck_weights[i];
                    time++;
                    break;
                }

                // 2) q가 비어있지 않을 때 : 다리에 트럭이 있을 때
                else {


                    // 2-1) 큐 사이즈가 다리의 길이랑 같을 때 : 다리에 트럭이 가득 찼을 때
                    //
                    if (q.size() == bridge_length) {
                        weightSum -= q.poll();
                    }

                    // 2-2) 다리에 트럭이 있지만, 지나갈 트럭이 무게를 초과할 때
                    // -> 0을 넣어줌으로서 다리를 지나가게 생각.
                    else if (weightSum + truck_weights[i] > weight) {
                        q.offer(0);
                        time++;
                    }


                    // 2-2) 다리에 트럭이 있고 , 지나갈 트럭도 무게 초과를 안할 때
                    // -> 또 넣어주기. + sum 도 무게만큼 더해주기
                    else{
                        q.offer(truck_weights[i]);
                        time ++;
                        weightSum += truck_weights[i];
                        break;
                    }
                }
            }
        }

        answer += time;
        System.out.println(answer);
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

        int[] asd = {4,4,4,2,2,1,1,1,1};
        다리를_지나는_트럭 sol2 = new 다리를_지나는_트럭();
        sol.solution(10, 12, asd);
    }
}
