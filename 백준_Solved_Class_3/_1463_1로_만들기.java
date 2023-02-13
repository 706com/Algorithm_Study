package 백준_Solved_Class_3;
//[백준]1463 : 1로 만들기 - JAVA(자바)

//<새로 알게된 것>
//dp 알고리즘
//경우의 수 생각하기

//<궁금한 것>
//
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1463_1로_만들기 {
    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //1 <=N<= 10^6

        dp = new Integer[N+1];
        dp[0] = dp[1] = 0;

        int result = makeOne(N);
        System.out.println(result);
    }

    //알고리즘 (최솟값 산출)
    // 1) 2로 나눠질때 : 2로 나눴을 때 or 1을 먼저 빼봤을 때 비교
    // 2) 3으로 나눠질때 : 3으로 나눴을때 or 1을 먼저 빼봤을 때 비교
    // 3) 6으로 나눠질때 : 2로 나눴을 때 or 3으로 나눴을 때 or 1을 먼저 빼봤을 때 비교
    public static int makeOne(Integer N){
        if(dp[N] == null){
            if(N % 6 == 0){ //6으로 나누어 떨어질 때 3가지를 비교.
                dp[N] = Math.min(makeOne(N-1), Math.min(makeOne(N/2), makeOne(N/3))) + 1 ;
            }
            else if(N % 2 == 0){
                dp[N] = Math.min(makeOne(N/2), makeOne(N-1)) + 1;   //2로 나눠질 때, dp에 사전에 저장된 값들 +1
            }
            else if(N % 3 == 0){
                dp[N] = Math.min(makeOne(N/3), makeOne(N-1)) + 1;
            }
            else{
                dp[N] = makeOne(N-1) +1;
            }
        }
        return dp[N];
    }
}
