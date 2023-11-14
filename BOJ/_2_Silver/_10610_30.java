package BOJ._2_Silver;
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
import java.util.Arrays;

public class _10610_30 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int[] arr = new int[str.length()];
        long sum = 0;

        //배열에 값 넣기
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            arr[i] = Character.getNumericValue(c);
        }

        //오름차순 정렬
        Arrays.sort(arr);

        //모든 값 더하기
        for(int i=0; i<str.length(); i++){
            sum += arr[i];
        }

        //조건 1,2 중 한개라도 부합하지 않으면 -1 출력 후 리턴
        if(!str.contains("0") || sum % 3 != 0){
            System.out.println("-1");
            return;
        }


        //반대로 돌면서 뒤부터 builder에 넣기
        StringBuilder sb = new StringBuilder();
        for(int i=arr.length-1; i>=0; i--){
            sb.append(arr[i]);
        }

        System.out.println(sb);


    }
}
