package 프로그래머스.Lv2;
// 소요 시간 : 12분

import java.util.*;

public class 숫자의_표현 {
    class Solution {
        public int solution(int n) {
            int answer = 0;
            int[] dp = new int[n+1];
            for(int i=1; i<=n; i++){
                dp[i] = i;
            }

            for(int i=1; i<=n; i++){
                int sum = 0;
                for(int j=i; j<=n; j++){
                    sum += j;
                    if(sum == n){
                        answer++;
                        break;
                    }
                    else if(sum >n){
                        break;
                    }
                }
            }

            return answer;
        }
    }
}
