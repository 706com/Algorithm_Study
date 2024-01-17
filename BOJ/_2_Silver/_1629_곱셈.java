package BOJ._2_Silver;

// 소요시간 : 5분 (실패 : 시간초과)
// 소요시간 : 20분 (넘 어렵다)

// 지수법칙, 모듈러 성질

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1629_곱셈 {
    static long C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        System.out.println(pow(A,B));
    }
    static long pow(long a, long b){
        //지수가 1일경우 A그대로 리턴
        if(b == 1){
            return a % C;
        }

        //임시로 절반 쪼개서 절반에 해당하는 값을 구한다.
        long temp = pow(a, b/2);

        //만일 지수가 홀수였다면, A를 한번 더 곱해주는 작업이 필요했다.
        /* 모듈러 성질 공식 유도
        *  (temp * temp * A) % C = ((temp * temp % C) * (A % C)) % C
		*			             = (((temp * temp % C) % C) * (A % C)) % C 	// (temp * temp % C) = (temp * temp % C) % C
		*			             = ((temp * temp % C) * A) % C
        * */
        if(b % 2 == 1){
            return (temp * temp % C) * a % C;
        }
        //짝수라면 temp * temp 작업으로 반환
        return temp * temp % C;
    }
}
