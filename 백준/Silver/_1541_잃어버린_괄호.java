package 백준.Silver;
//[백준]1541 : 잃어버린 괄호 - JAVA(자바)

//< 알고리즘 유형 >
// 그리디

//< 알고리즘 풀이 >
// split 혹은 StringTokenizer 활용
// + 와 - 를 각각 분리하여 , 구분자 기준으로 잘라내어 계산.
// 초깃값 설정 중요!

//< 새로 알게된 것 >
// st.hasMoreTokens();

//< 궁금한 것 >

import java.io.*;
import java.util.StringTokenizer;

public class _1541_잃어버린_괄호 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sub = new StringTokenizer(br.readLine(),"-");   // '-' 로 토큰 분리

        int result = Integer.MAX_VALUE;

        while(sub.hasMoreTokens()){
            int temp = 0;
            StringTokenizer add = new StringTokenizer(sub.nextToken(),"+");

            while(add.hasMoreTokens()){
                temp += Integer.parseInt(add.nextToken());
            }

            if(result == Integer.MAX_VALUE){
                result = temp;
            }
            else {
                result -= temp;
            }
        }

        System.out.println(result);
    }
}
