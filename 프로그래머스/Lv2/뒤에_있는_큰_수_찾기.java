package 프로그래머스.Lv2;

//소요시간
//[240523] 실패
//[240524] 30분

//1. 스택에 담는다.
//2. 만일 스택에 담을 때 비어있으면 -1 출력
//3. 스택에 상단과 비교.
//3-1) 본인이 더 크면 스택에 있는 값 빼기
//3-2) 스택 비어있으면 -1 출력
//3-3) 본인이 더 작으면 스택 상단 출력
//4) 스택에 넣기

import java.util.*;

public class 뒤에_있는_큰_수_찾기 {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stk = new Stack<>();
        for(int i=numbers.length-1; i>=0; i--){
            int num = numbers[i];
            //가장 처음
            if(stk.isEmpty()){
                stk.push(num);
                answer[i] = -1;
            } else{
                if(stk.peek() > num){
                    answer[i] = stk.peek();
                    stk.push(num);
                } else{
                    while(true){
                        if(stk.isEmpty()){
                            answer[i] = -1;
                            stk.push(num);
                            break;
                        }
                        if(stk.peek()>num){
                            answer[i] = stk.peek();
                            stk.push(num);
                            break;
                        }
                        stk.pop();
                    }
                }
            }
        }

        // System.out.println(Arrays.toString(answer));
        return answer;
    }
}
