package 프로그래머스.Lv2;

//소요시간
//[240523] 실패
//[240524] 30분
//[241129] 20분

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

        Stack<Integer> stk = new Stack<>();
        int N = numbers.length-1;

        int[] result = new int[N+1];

        for(int i=N; i>=0; i--){
            int number = numbers[i];
            if(stk.isEmpty()){
                result[i] = -1;
                stk.push(number);
            } else{
                if(stk.peek() > number){
                    result[i] = stk.peek();
                    stk.push(number);
                } else{
                    while(!stk.isEmpty()){
                        stk.pop();
                        if(stk.isEmpty()){
                            result[i] = -1;
                            break;
                        }
                        if(stk.peek() > number){
                            result[i] = stk.peek();
                            break;
                        }
                    }
                    stk.push(number);
                }
            }
        }
        return result;
    }
}
