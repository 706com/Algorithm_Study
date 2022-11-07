package 백준;
//1436 : 영화감독 숌
//새로 알게된 것
//부르트포스란 ? : brute force(무식한 힘) : 완전탐색
//String.value(int) : String 으로 변환
//contains("?") : 이 문자열을 포함하는가?

//Integer 와 int 의 차이점
//Obj.toString() 과 String.valueOf() 의 차이점

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1436_영화감독숌 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();


        int cnt = 1;
        int result=666; //result 값으로 값 찾기

        //while문의 조건 : cnt 의 값이 처음 입력한 순서일 때 까지
        while (cnt != Integer.parseInt(N)) {
            result++;
            if (String.valueOf(result).contains("666")) {   //String으로 변환한 result 값이 666을 포함하는가?
                cnt++;  //포함하면 cnt 증가
            }
        }
        System.out.println(result);
    }
}

