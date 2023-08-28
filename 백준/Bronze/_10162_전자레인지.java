package 백준.Bronze;
//[백준]10162 : 전자레인지 - JAVA(자바)

//< 알고리즘 유형 >
// 그리디 , 구현 , 수학

//< 알고리즘 풀이 >
// 10 60 300 간의 규칙성이 보이지않아 난항을 겪었다.
// -> 3개라서 상관없는 문제였다
// 2차원 배열로 저장

//< 새로 알게된 것 >

//< 궁금한 것 >

import java.io.*;

public class _10162_전자레인지 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = {
                {300,0},
                {60,0},
                {10,0}};


        for(int i=0; i<3; i++){
            arr[i][1] = N / arr[i][0];
            N %= arr[i][0];
        }

        if(N != 0){
            System.out.println("-1");
            return;
        }

        for(int i=0; i<3; i++){
            System.out.print(arr[i][1]+" ");
        }
    }
}
