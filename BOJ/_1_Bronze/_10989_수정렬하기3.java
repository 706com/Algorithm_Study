package BOJ._1_Bronze;
//[백준]10989 : 수 정렬하기 3 - JAVA(자바)

//<새로 알게된 것>
//ArrayList 로 할 경우, 메모리 초과 발생.

//<궁금한 것>

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class _10989_수정렬하기3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        for(int i=0; i<N; i++){
            sb.append(arr[i]).append("\n");
        }
        System.out.println(sb);
    }
}
