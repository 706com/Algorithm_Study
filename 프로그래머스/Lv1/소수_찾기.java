package 프로그래머스.Lv1;

// 소요시간 : 17분

import java.util.*;

class 소수_찾기 {
    public int solution(int n) {
        int answer = 0;
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime,true);
        isPrime[0] = false;
        isPrime[1] = false;
        isPrime[2] = true;

        for(int i=2; i<Math.sqrt(n); i++){
            for(int j=i*i; j<=n; j+=i){
                isPrime[j] = false;
            }
        }

        for(int i=2; i<=n; i++){
            if(isPrime[i]){
                // System.out.println(i);
                answer++;
            }
        }
        return answer;
    }
}