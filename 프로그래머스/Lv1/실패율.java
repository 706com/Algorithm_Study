package 프로그래머스.Lv1;

//소요시간 : 실패(구현 실패🔍)
//[251012] : 1시간 30분

import java.util.*;

public class 실패율 {
    public int[] solution(int N, int[] stages) {
        // 배열 정렬
        Arrays.sort(stages);

        List<Node> failureList = new ArrayList<>(); //실패율 배열

        // 스테이지 1부터 순회
        int currentStage = 1;
        Double remainPeople = Double.valueOf(stages.length);
        Double currentStagePeople = 0.0;

        for(int i=0; i<stages.length; i++){
            // 현재 스테이지보다 만난 스테이지가 크다면, Node 에 기록 후 스테이지 증가
            if(currentStage < stages[i]){
                // 실패율 = 스테이지에 머무르는 인원 / 남은 인원
                Double failure = currentStagePeople / remainPeople;

                // 노드에 넣기
                Node node = new Node(currentStage,failure);
                failureList.add(node);

                // 남은 인원 책정
                remainPeople -= currentStagePeople;

                // 현재 인원 초기화
                currentStagePeople = 0.0;

                // 스테이지 증가
                currentStage++;

                //현재 멈춰있는 인덱스에서, 다음 스테이지 비교를 위한 인덱스 감소
                i--;
                continue;
            }

            //현재 스테이지와 같으면 인원 책정 시작
            if(currentStage == stages[i]){
                currentStagePeople++;
                // System.out.println("도착");
            }
        }

        //마지막 인덱스 , 남은 스테이지 처리
        while(currentStage <= N){
            failureList.add(new Node(currentStage,currentStagePeople / remainPeople));

            currentStage++;
            currentStagePeople = 0.0;
        }
        if(currentStage <= N){
            failureList.add(new Node(currentStage,currentStagePeople / remainPeople));
        }

        // 실패율 정렬하기
        Collections.sort(failureList, Collections.reverseOrder((o1,o2)->{
            //같으면 인덱스 오름차순
            if(o1.failure == o2.failure){
                return o1.idx - o2.idx;
            }
            //실패율 내림차순
            return Double.compare(o1.failure, o2.failure);
        }));

        // 답안 출력
        int[] answer = new int[N];
        for(int i=0; i<failureList.size(); i++){
            answer[i] = failureList.get(i).idx;
        }
        return answer;
    }

    class Node{
        int idx;
        Double failure;
        Node(int idx, Double failure){
            this.idx = idx;
            this.failure = failure;
        }

        @Override
        public String toString(){
            // System.out.println(this.idx +" : "+ this.failure);
            return this.idx + " : " + this.failure ;
        }
    }

}


//class Solution {
//    public int[] solution(int N, int[] stages) {
//        int[] answer = {};
//        // 1. 스테이지별 도전자 수를 구한다.
//        int[] challenger = new int[N+2]; //0탄 없음, N+1은 모두 클리어
//        for(int i=0; i<stages.length; i++){
//            challenger[stages[i]]++;
//        }
//        // System.out.println("스테이지별 도전자 수 : " + Arrays.toString(challenger));
//
//        // 2. 스테이지별 실패한 사용자 수를 계산한다.
//        HashMap<Integer,Double> fails = new HashMap<>();
//        int total = stages.length;
//
//        // 3. 각 스테이지를 순회하며, 실패율을 계산한다.
//        for(int i=1; i<=N; i++){
//            double perFail;
//            // 4. 도전한 사람이 없는 경우, 실패율은 0이다.
//            if(challenger[i] == 0){
//                perFail = 0;
//                fails.put(i,perFail);
//            } else{ // 5. 실패율 계산
//                perFail = challenger[i] / (double)total ;   //✔double 선언 주의
//                fails.put(i,perFail);
//            }
//            // 6. 다음 스테이지 실패율을 구하기 위해 현재 스테이지의 인원을 뺀다.
//            total -= challenger[i];
//        }
//
//        // 7. 실패율이 높은 스테이지부터 내림차순으로 정렬한다.
//        return fails.entrySet().stream().sorted((o1,o2)-> Double.compare(o2.getValue(),o1.getValue())).mapToInt(HashMap.Entry::getKey).toArray();
//    }
//}
