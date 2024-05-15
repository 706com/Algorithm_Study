package 프로그래머스.Lv2;

//소요시간
//[240515] : 12분

public class 멀리_뛰기 {
    public long solution(int n) {

        long[] dp = new long[n+1];

        if(n>=1){
            dp[1] = 1;
        }
        if(n>=2){
            dp[2] = 2;
        }
        for(int i=3; i<=n; i++){
            dp[i] = (dp[i-2] + dp[i-1]) % 1234567;
        }
        return dp[n];
    }
}
