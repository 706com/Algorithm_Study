package 프로그래머스.Lv2;

//[241218] 10분

import java.util.*;

public class 귤_고르기 {
    public int solution(int k, int[] tangerine) {
        int answer = 0;

        int[] dp;
        int max = 0;

        for(int i=0; i<tangerine.length; i++){
            max = Math.max(max,tangerine[i]);
        }
        dp = new int[max+1];

        for(int i=0; i<tangerine.length; i++){
            dp[tangerine[i]]++;
        }
        Arrays.sort(dp);

        for(int i=dp.length-1; i>=0; i--){
            k -= dp[i];
            answer++;
            if(k<=0){
                return answer;
            }
        }
        return answer;
    }
}
