package BOJ._2_Silver;
//[백준]5525 : IOIOI - JAVA(자바)

//< 나의 알고리즘 >
//contains() indexof() 메소드로 문제를 해결해보려 했으나 실패..

//< 답안 알고리즘 >
// 배열안에 규칙을 이용해서 해결!

//< 새로 알게된 것 >
//char[] S = br.readLine().toCharArray() : 배열에 한번에 넣는법

//< 궁금한 것 >

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _5525_IOIOI {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    //N=1: IOI , N=2 : IOIOI , 1 ≤ N ≤ 1,000,000
        int M = Integer.parseInt(br.readLine());    //문자열S의 길이 M , 2N+1 ≤ M ≤ 1,000,000

        char[] S = br.readLine().toCharArray();   //문자열 S , S는 I와 O로만 이루어져 있다.

//        //Pn 뭔지 알아보기
//        //N의 크기만큼 Pn 생성
//        String ioi = "I";
//        for(int i=0; i<N; i++){
//            ioi += "OI";
//        }
//        System.out.println(ioi);

        int count =0;   // count = IOI 갯수,
        int result = 0; // result = Pn 의 개수

        for(int i=1; i<M-1; i++){
            //IOI 일때 i+2씩 해서 규칙 확인
            if(S[i-1] == 'I' && S[i]=='O' && S[i+1] == 'I'){
                count++;
                if(count == N){
                    count--;
                    result++;
                }
                i++;
                continue;
            }
            count = 0;
        }
        System.out.println(result);
    }
}
