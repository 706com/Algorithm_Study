package 백준.Silver;
//[백준]9375 : 패션왕 신해빈 - JAVA(자바)

//< 나의 알고리즘 >
// 그리디 알고리즘 .
// 동전간의 배수관계가 성립하기에 적용가능.
// dp 로도 접근이 가능하다고 하나 , 잘 모르겠슴.. 해도 시간초과 난다고 함.

//< 답안 알고리즘 >

//< 새로 알게된 것 >

//< 궁금한 것 >

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11047_동전0 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());   // 동전의 종류갯수
        int K = Integer.parseInt(st.nextToken());   // 가치의 합
        int[] coin = new int[K];

        //동전 넣기
        for(int i=0; i<N; i++){
            coin[i] = Integer.parseInt(br.readLine());
        }

        int result = 0;


        for(int i=N-1; i>=0; i--){
            if(K==0){
                break;
            }
            result += (K / coin[i]);
            K %= coin[i];
        }

        System.out.println(result);
    }
}
