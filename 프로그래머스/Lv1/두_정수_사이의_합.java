package 프로그래머스.Lv1;

public class 두_정수_사이의_합 {
    class Solution {
        public long solution(int a, int b) {
            long answer = 0;
            if(a >= b){
                int temp = b;
                b = a;
                a = temp;
            }

            for(int i=a; i<=b; i++){
                answer += i;
            }

            return answer;
        }
    }
}
