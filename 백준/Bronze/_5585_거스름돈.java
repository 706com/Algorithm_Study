package 백준.Bronze;
//[백준]5585 : 거스름돈 - JAVA(자바)

//< 알고리즘 유형 >
// 그리디

//< 알고리즘 풀이 >
// 1,5 간의 규칙성이 보이므로 그리디.

//< 새로 알게된 것 >

//< 궁금한 것 >

import java.io.*;

public class _5585_거스름돈 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = {1,5,10,50,100,500,1000};

        int point = arr.length-1;

        int remain = 1000 - N;
        int result = 0;

        while(remain>0){
            result += remain / arr[point];
            remain %= arr[point];
            point--;
        }

        System.out.println(result);
    }
}
