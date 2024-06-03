package 프로그래머스.Lv3;

// 소요시간
// [240602] : 🔍
// [240604] : 30분

// 1. 배열순서대로 Queue에 삽입한다.
// 2. 현재 다리의 하중 무게를 더한다.
//// 3. 시간을 1초 보낸다.

// - 트럭을 다리에 넣을 수 있을 떄 +1 후 pass

// - 트럭을 다리에 넣을 수 없을 때
// -> 무게가 초과돼서
//   -> 0 넣기
// -> 다리에 가득차서
//   -> poll() 시켜주기

import java.util.*;

public class 다리를_지나는_트럭 {
    class Solution {
        public int solution(int bridge_length, int weight, int[] truck_weights) {
            int answer = 0;

            Queue<Integer> q = new LinkedList<>();

            int time = 0;
            int nowWeight = 0;
            for(int i=0; i<truck_weights.length; i++){
                int x = truck_weights[i];
                //다리가 비어 있을 때
                if(q.isEmpty()){
                    q.offer(x);
                    time++;
                    nowWeight += x;
                    continue;
                }
                //다리에 올라갈 수 있을 때
                //-> 가득차지 않음
                //-> 무게가 가능함
                else if(q.size() != bridge_length && nowWeight + x <= weight){
                    q.offer(x);
                    nowWeight += x;
                    time++;
                    continue;
                }
                //다리에 가득 찼을 때
                // -> 이때 새로운 트럭 들어올 수 있는지 확인
                if(q.size() == bridge_length){
                    int outTruck = q.poll();
                    time++;
                    nowWeight -= outTruck;
                    if(nowWeight + x <= weight){
                        q.offer(x);
                        nowWeight += x;
                    } else{
                        q.offer(0);
                        // time++;
                        i--;
                    }
                    continue;
                }

                //다리에 못 들어 올 때
                if(nowWeight + x > weight){
                    q.offer(0);
                    i--;
                    time++;
                }
            }
            //마지막 트럭까지 보내기
            return time + bridge_length;
        }
    }
}
