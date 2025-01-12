package 프로그래머스.Lv3;

//[250112] : 🔍

// 현 시점에서 문제를 풀 수 있는가
// 시간적으로 그냥 스스로 높이는것이 나은가, 문제를 푸는것이 나은가

// 어떤 문제를 푸는게 제일 최적인가

// dp 같은데.. 해당 초(시간) 기준에서 가장 최적인 것?

import java.util.*;

public class 코딩_테스트_공부 {
    public int solution(int alp, int cop, int[][] problems) {

        //모든 문제를 풀기위한 필요 alp ,cop 구하기
        int maxAlp=alp, maxCop =cop;
        for(int i=0; i<problems.length; i++){
            maxAlp = Math.max(maxAlp,problems[i][0]);
            maxCop = Math.max(maxCop,problems[i][1]);
        }

        // int[][] dp = new int[maxAlp+1][maxCop+1]; // 해당 알고력 / 코딩력 기준에서 가장 최소의 시간
        int[][] dp = new int[maxAlp+2][maxCop+2];
        for(int i=0; i<dp.length; i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }

        // 이미 다 풀 수 있음
        if(maxAlp == alp && maxCop == cop){
            return 0;
        }

        dp[alp][cop] = 0;
        for(int i=alp; i<=maxAlp; i++){
            for(int j=cop; j<=maxCop; j++){
                // 단순 공부하기
                dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j]+1);
                dp[i][j+1] = Math.min(dp[i][j+1], dp[i][j]+1);

                // 문제를 풀 수 있을 때,
                // 각 문제와 단순 시간 증가와 비교
                for(int p=0; p<problems.length; p++){
                    if(i>=problems[p][0] && j>=problems[p][1]){
                        //풀 수 있는 문제 하나를 골라서 풀기
                        //dp[목표알고치][목표코딩치]를 반환해야하는데, 넘기면 cost가 증가해버린다.
                        //그렇다면 우리가 해줘야할것은 알고력이 목표알고력을 넘엇을때, 교정작업 (알고력 23= 목표알고력 20) 을 해야한다.
                        int nextAlp = Math.min(i + problems[p][2], maxAlp);
                        int nextCop = Math.min(j + problems[p][3], maxCop);

                        dp[nextAlp][nextCop] = Math.min(dp[nextAlp][nextCop], dp[i][j] + problems[p][4]);
                    }
                }
            }
        }
        return dp[maxAlp][maxCop];
    }
}
