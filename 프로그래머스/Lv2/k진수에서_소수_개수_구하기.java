package 프로그래머스.Lv2;
//[250117] 🔍

//일단 진법 변환을 하고. (어떻게?)
//결국 0을 기준으로 잘라내고
//해당 잘라낸 수가 소수인지 판별

//Integer.toString(숫자,N진법) -> 숫자를 N진법으로 변환

import java.util.*;

public class k진수에서_소수_개수_구하기 {
    public int solution(int n, int k) {
        int answer = 0;

        String changeN = Integer.toString(n,k); //진법 변환 n을 -> k진수로
        // System.out.println(changeN);

        StringTokenizer st = new StringTokenizer(changeN, "0");
        while(st.hasMoreTokens()){
            long num = Long.parseLong(st.nextToken()); //11111111111111 와 같이 int 범위 주의
            // System.out.println(num);
            if(isPrime(num)){
                answer++;
            }
        }

        return answer;
    }

    //소수 판별
    public boolean isPrime(long num){
        if(num<=1){
            return false;
        }
        for(int i=2; i<=Math.sqrt(num); i++){
            if(num%i ==0){
                return false;
            }
        }
        return true;
    }
}
