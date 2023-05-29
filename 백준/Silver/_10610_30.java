package 백준.Silver;
//[백준]10610 : 30 - JAVA(자바)

//< 알고리즘 유형 >
// 그리디 , 문자열, 수학

//< 알고리즘 풀이 >
// 30배수 조건 1 : 모든 수의 합이 3의 배수 이어야 한다.
// 30배수 조건 2 : 0이 한개 이상 있어야한다.

//< 새로 알게된 것 >

//< 궁금한 것 >

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10610_30 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        boolean zero = false;
        long sum =0;

        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(c=='0'){
                zero = true;
            }


        }
    }
}
