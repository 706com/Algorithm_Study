package 프로그래머스.Lv1;

//소요시간 : 15분 (너무 깡 구현 느낌..?) + 스트림 리턴🔍
//[240614] : 25분
//[251009] : 32분

import java.util.*;

public class 모의고사 {
    public int[] solution(int[] answers) {

        //문제 순회하기
        //각 수포자의 정답 횟수 카운트
        List<Integer> a = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        List<Integer> b = new ArrayList<>(Arrays.asList(2,1,2,3,2,4,2,5));
        List<Integer> c = new ArrayList<>(Arrays.asList(3,3,1,1,2,2,4,4,5,5));

        Tester A = new Tester(1,a);
        Tester B = new Tester(2,b);
        Tester C = new Tester(3,c);

        int max = 0;
        for(int i=0; i<answers.length; i++){

            //A 순회
            if(answers[i] == A.list.get(i%A.list.size())){
                A.answer++;
            }
            //B 순회
            if(answers[i] == B.list.get(i%B.list.size())){
                B.answer++;
            }
            //C 순회
            if(answers[i] == C.list.get(i%C.list.size())){
                C.answer++;
            }
            max = Math.max(C.answer,Math.max(A.answer,B.answer));
        }

        // 정렬을 위한 리스트 생성
        List<Tester> testers = new ArrayList<>();
        testers.add(A);
        testers.add(B);
        testers.add(C);

        Collections.sort(testers,(o1,o2)-> {
            // 같으면 오름차순
            if(o1.answer == o2.answer){
                return o1.answer - o2.answer;
            }
            //기본은 내림차순
            return o2.answer - o1.answer;
        });

        //최종 답안 도출
        List<Integer> answer = new ArrayList<>();

        for(Tester x : testers){
            if(max == x.answer){
                answer.add(x.idx);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    class Tester{
        int idx;
        List<Integer> list;
        int answer;
        Tester(int idx, List<Integer> list){
            this.idx = idx;
            this.list = new ArrayList<>(list);
            this.answer = 0;
        }
    }
}
