package 백준_Solved_Class_3;
//[백준]2579 : 계단오르기 - JAVA(자바)

//< 나의 알고리즘 >
// 무조건 dp! 탐색할 떄 시간낭비 할 일 없이, 저장시켜놓은걸 활용하는 문제같다.

//< 답안 알고리즘 >

//< 새로 알게된 것 >
// dp 메모이제이션.
// top-down(재귀) / bottom-up(반복문) 방식 활용

//< 궁금한 것 >
//Q) 느낌은 알았는데, 최댓값 저장하는 과정에서 어떻게 이게 연속 2번인지 저장되는걸까?
// -> 좀더 그림으로 연상 시켜보기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _2579_계단오르기 {
    static int N;
    static int[] stairPoint;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());    // 계단의 개수 1 <= N <=300

        stairPoint = new int[N+1];
        dp = new int[N+1];

        // 계단 점수 입력 : 점수<=10,000 자연수
        for (int i = 1; i <= N; i++) {
            stairPoint[i] = Integer.parseInt(br.readLine());
        }

        Arrays.fill(dp,-1); //dp 초기화

        dp[0] = 0;             //0번지 인덱스는 없게 설정했으므로 -1 초기화
        dp[1] = stairPoint[1];  //첫번째 계단 입력

        //입력값이 1 일때 예외처리
        if(N >= 2){
            dp[2] = stairPoint[1]+ stairPoint[2];
        }

        int result = find(N);
        System.out.println(result);
    }

    static int find(int N){

        //탐색이 아직 안된 값(0)이면.
        if(dp[N] == -1){
            //Max 값 비교 :    1) N-2까지의 dp +      현재 계단 (2칸 뛰어넘기) (전 계단은 2칸 뛰어넘은것)
            //                2) N-3까지의 dp + 직전 계단 + 현재계단 (1칸 뛰어넘기 연속 2번)
            // Q) 느낌은 알았는데, 최댓값 저장하는 과정에서 어떻게 이게 연속 2번인지 저장되는걸까?
            dp[N] = Math.max(find(N-2),find(N-3)+stairPoint[N-1])+ stairPoint[N];
        }

        return dp[N];
    }
}
