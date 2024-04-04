package 프로그래머스.Lv2;

//소요시간 : 3분

public class 파보나치_수 {
    class Solution {
        public int solution(int n) {
            int answer = 0;
            int[] fibo = new int[100001];
            fibo[0] = 0;
            fibo[1] = 1;

            for(int i=2; i<=n; i++){
                fibo[i] = (fibo[i-1] + fibo[i-2]) % 1234567;
            }
            answer = fibo[n];
            return answer;
        }
    }
}
