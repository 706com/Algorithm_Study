package 프로그래머스.Lv1;
//[프로그래머스] 같은 숫자는 싫어 - JAVA(자바)

//< 알고리즘 유형 >
// queue

//< 알고리즘 풀이 >
// Deque 로 접근하여 풀이

//< 새로 알게된 것 >
// 배열 초기화 필수!

//< 궁금한 것 >

import java.util.Deque;
import java.util.LinkedList;

public class 같은_숫자는_싫어 {
    public int[] solution(int []arr) {
        Deque<Integer> deq = new LinkedList<>();

        int[] answer = {};

        for(int i=0; i<arr.length; i++){
            if(deq.isEmpty()){
                deq.addFirst(arr[i]);
                continue;
            }
            if(deq.peekLast() != arr[i]){
                deq.add(arr[i]);
            }
        }

        int size = deq.size();
        answer = new int[size];     //초기화 중요!

        for(int i=0; i<size; i++){
            answer[i] =  deq.pollFirst();
        }

        return answer;
    }
    public static void main(String[] args) {
        int[] arr = {1,1,3,3,0,1,1};

        같은_숫자는_싫어 sol = new 같은_숫자는_싫어();
        System.out.println(sol.solution(arr));
    }
}
