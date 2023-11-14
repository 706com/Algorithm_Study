package BOJ._1_Bronze;
//[백준]15829 : Hashing - JAVA(자바)

//<새로 알게된 것>
//ASCII to int = (int) char c
//Math.pow 를 활용하였지만 overflow 50 점으로 실패. 중간중간 mod M 을 활용해야함
//overflow 되는 구간 지속적으로 확인하기

//<궁금한 것>

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _15829_Hashing {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int r = 31;
        int M = 1234567891;
        long sum = 0;   //int(x)
        long pow = 1;

        for(int i=0; i<L; i++){
            char c = str.charAt(i);
            int num = (int)c - 96;  //아스키코드를 통한 a=0,b=1--- 추출, ASCII: a==97
            int cnt = i;
            pow = 1;

            //i 횟수만큼 제곱시키기.
            while(cnt>0){
                pow *= r;
                pow %= M;
                cnt--;
            }

            sum += num * pow % M;

        }
        System.out.println(sum % M);
    }
}
