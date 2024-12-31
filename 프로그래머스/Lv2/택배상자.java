package 프로그래머스.Lv2;

//[241231] 30분

import java.util.*;

public class 택배상자 {
    public int solution(int[] order) {
        int answer = 0;

        Stack<Integer> stk = new Stack<>();

        int nowNum = 1;
        for(int i=0; i<order.length; i++){
            // System.out.println(order[i] +" 번째 ");

            // 1) 비어있거나 보조 컨테이너에 담긴 값이 작으면 해당 수 까지 넣기
            if(stk.isEmpty() || stk.peek()<order[i]){
                while(true){
                    stk.push(nowNum);
                    nowNum++;
                    if(stk.peek() == order[i]){
                        break;
                    }
                }
            }
            // 2) 만일 보조 컨테이너 수가 크면 더이상 뺄 수 없음
            else if(stk.peek() > order[i]){
                break;
            }

            // 3) 같으면 보조에서 빼기
            if(stk.peek() == order[i]){
                answer++;
                stk.pop();
            }

        }
        return answer;
    }
}
