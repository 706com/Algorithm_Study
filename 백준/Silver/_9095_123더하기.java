package 백준.Silver;
//[백준]9095 : 1, 2, 3 더하기 - JAVA(자바)

//< 나의 알고리즘 >
// dp 같다고 생각하긴 하였으나.. 실패

//< 답안 알고리즘 >
// dp 알고리즘
// 규칙부터 찾는게 우선.

//< 새로 알게된 것 >
// count 호출과정에서 n-3 n-2 n-1 실수! dp[n-3] 등을 불러내면 안됨
// Integer 로 하는것이 null값 처리가 용이함!

//< 궁금한 것 >

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9095_123더하기 {
    static Integer[] dp = new Integer[11];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());// 테스트 케이스의 개수 T

        //dp 1,2,3 초기화
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        while(T-- > 0){
            int n = Integer.parseInt(br.readLine());    //정수 n.  n은 양수이며 11보다 작다.
            int result = count(n);
            System.out.println(result);
        }
    }
    static int count(int n){
        if(dp[n] == null) {
            dp[n] = count(n - 3) + count(n - 2) + count(n - 1);
        }

        return dp[n];
    }
}
