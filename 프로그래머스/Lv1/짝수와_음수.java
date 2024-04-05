package 프로그래머스.Lv1;

//음수 고려해서 전처리 필요..! or == -1

public class 짝수와_음수 {
    class Solution {
        public String solution(int num) {
            num = Math.abs(num);
            if(num % 2 == 1){
                return "Odd";
            }
            else{
                return "Even";
            }
        }
    }
}
