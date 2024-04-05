package 프로그래머스.Lv2;

//소요시간 : 30분 실패 🔍📌

import java.util.*;

public class 점프와_순간_이동 {
    //충격적인 정답 코드
    //Top-Down 방식으로 했을때 경우의 수 : 홀/짝
    public class Solution {
        public int solution(int n) {
            int ans = 0;
            while(true){
                if(n%2 == 1){   //홀수 : 빼기 1
                    n -= 1;
                    ans++;
                } else{         //짝수 : 나누기 2
                    n/=2;
                }
                //종료지점
                if(n==0){
                    break;
                }
            }
            return ans;
        }
    }
    //실패코드 Bottom-Up (접근 자체가 아예 틀림)
    public class Fail {
        public int solution(int n) {
            int ans = 0;

            int[] dp = new int[n*2];
            dp[n] = Integer.MAX_VALUE;
            boolean[] visited = new boolean[n+1];

            int[] start = {1,3,5,7};
            for(int i=0; i<start.length; i++){
                int x = start[i];
                ans += x;
                dp[x] = ans;

                while(true){
                    x *= 2;
                    if(x > n){
                        x /= 2;
                        break;
                    }
                    if(x==n){
                        dp[n] = ans;
                        break;
                    }
                    dp[x] = ans;
                }
                System.out.println("탈출 x : "+x);
                if(x != n){
                    ans += (n-x);
                    System.out.println("ans : "+ans);
                    dp[n] = Math.min(dp[n],ans);
                }
                ans = 0;
            }

            return dp[n];
        }
    }
}
