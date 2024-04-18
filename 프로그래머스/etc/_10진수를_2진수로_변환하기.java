package 프로그래머스.etc;

//10진수를 입력받아 2진수로 변환해 반환하는 solution()함수를 구현하라.

//제약조건 : demical은 1이상 10억 미만의 자연수

//입출력 예

import java.util.Stack;

/**
 * demical  |   return
 * 10           1010
 * 27           11011
 * 12345        11000000111001
 */

public class _10진수를_2진수로_변환하기 {

    /**
     * Stack 풀이법
     * 시간복잡도 : O(logN)
     */
    public static String solution(int demical){
        String answer = "";
        Stack<String> stk = new Stack<>();
        StringBuilder sb = new StringBuilder();

        while(demical != 0){
            //1. 10진수의 나머지 연산을 진행한다.
            int remain = demical % 2;
            //2. 나머지를 스택에 담는다.
            stk.push(String.valueOf(remain));
            //3. 10진수를 2로 나눈다.
            demical /= 2;
        }

        while(!stk.isEmpty()){
            sb.append(stk.pop());
        }
        answer = sb.toString();
        return answer;
    }

    /**
     * Integer.toBinaryString() 풀이법
     */
    public static String solution_(int demical){
        String answer = "";

        answer = Integer.toBinaryString(demical);

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(10));
        System.out.println(solution(27));
        System.out.println(solution(12345));
    }
}
