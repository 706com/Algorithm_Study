package 백준.Silver;
//[백준]1026 : 보물 - JAVA(자바)

//< 나의 알고리즘 >
// 그리디 알고리즘
// A B 둘다 오름차순, 내림차순 정렬 후 값 구하기
// B 재배열 금지라고 써있지만 함정같아 보인다. (값에는 영향x)

//< 답안 알고리즘 >

//< 새로 알게된 것 >

//< 궁금한 것 >

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class _1026_보물 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Integer[] arr1 = new Integer[N];
        Integer[] arr2 = new Integer[N];

        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<N; i++){
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<N; i++){
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr1,Collections.reverseOrder());   //내림차순
        Arrays.sort(arr2);  //오름차순

        int result = 0;
        for(int i=0; i<N; i++){
            result += arr1[i] * arr2[i];
        }

        System.out.println(result);
    }
}
