package 프로그래머스.Lv1;

//소요시간 : 실패(구현 실패🔍)

// 실패율 : 아직 클리어 못한 플레이어 수 / 스테이지 도달 플레이어 수
// 전체 스테이지 : N
// 플레이어 스테이지 번호 배열 : stages

//예외 1) 실패율이 같다면 작은 번호 스테이지가 먼저
//예외 2) 스테이지 도달 유저가 없을 땐, 실패율은 0

import java.util.*;

public class 실패율 {

    class Solution {
        public int[] solution(int N, int[] stages) {
            int[] answer = {};
            // 1. 스테이지별 도전자 수를 구한다.
            int[] challenger = new int[N+2]; //0탄 없음, N+1은 모두 클리어
            for(int i=0; i<stages.length; i++){
                challenger[stages[i]]++;
            }
            // System.out.println("스테이지별 도전자 수 : " + Arrays.toString(challenger));

            // 2. 스테이지별 실패한 사용자 수를 계산한다.
            HashMap<Integer,Double> fails = new HashMap<>();
            int total = stages.length;

            // 3. 각 스테이지를 순회하며, 실패율을 계산한다.
            for(int i=1; i<=N; i++){
                double perFail;
                // 4. 도전한 사람이 없는 경우, 실패율은 0이다.
                if(challenger[i] == 0){
                    perFail = 0;
                    fails.put(i,perFail);
                } else{ // 5. 실패율 계산
                    perFail = challenger[i] / (double)total ;   //✔double 선언 주의
                    fails.put(i,perFail);
                }
                // 6. 다음 스테이지 실패율을 구하기 위해 현재 스테이지의 인원을 뺀다.
                total -= challenger[i];
            }

            // for(int x : fails.keySet()){
            //     System.out.println(x+" "+fails.get(x));
            // }
            // 7. 실패율이 높은 스테이지부터 내림차순으로 정렬한다.

            return fails.entrySet().stream().sorted((o1,o2)-> Double.compare(o2.getValue(),o1.getValue())).mapToInt(HashMap.Entry::getKey).toArray();
        }
        /*
        List<Map.Entry<Integer, Double>> entryList = new ArrayList<>(fails.entrySet());

        // Sort the list based on values in descending order
        Collections.sort(entryList, (o1, o2) -> Double.compare(o2.getValue(), o1.getValue()));

        // Extract keys from sorted entries
        int[] keysArray = new int[entryList.size()];
        for (int i = 0; i < entryList.size(); i++) {
            keysArray[i] = entryList.get(i).getKey();
        }
        return keysArray;
        */
    }
}
