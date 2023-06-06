package 프로그래머스.Lv2;
//[프로그래머스] 같은 숫자는 싫어 - JAVA(자바)

//< 알고리즘 유형 >
// queue

//< 알고리즘 풀이 >
// Queue 에 담을 내용 : 수행 완료 일자
// 수행 완료 일자 기준으로 break point 설정하여 answer 에 담기.

//< 새로 알게된 것 >
// Math.ceil -> 반올림 내림 가능

//< 궁금한 것 >

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class 기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Deque<Integer> deq = new LinkedList<>();

        for(int i=0; i<progresses.length; i++){
            int remain = (100 - progresses[i]) / speeds[i];
            if((100 - progresses[i]) % speeds[i] >0){
                remain +=1;
            }
            deq.add(remain);
        }

//        int size = deq.size();
//        for(int i=0; i<size; i++){
//            System.out.print(deq.poll()+" ");
//        }

        ArrayList<Integer> list = new ArrayList<>();

        while(!deq.isEmpty()) {
            int count = 1 ;
            int now = 0;
            now = deq.poll();
            do {
                if(deq.isEmpty()){
                    break;
                }
                if (deq.peek() <= now) {
                    deq.poll();
                    count++;
                }
            } while (!deq.isEmpty() && deq.peek() <= now );
            list.add(count);
        }

//        for(int i=0; i<list.size(); i++){
//            System.out.print(list.get(i)+" ");
//        }

        answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
    public static void main(String[] args) {
        int[] progresses = {93,30,55};
        int[] speeds = {1,30,5};

//        int[] progresses = {95, 90, 99, 99, 80, 99};
//        int[] speeds = {1, 1, 1, 1, 1, 1};

        기능개발 sol = new 기능개발();
        sol.solution(progresses,speeds);

    }
}
