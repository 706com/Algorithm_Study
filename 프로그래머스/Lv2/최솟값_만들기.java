package 프로그래머스.Lv2;

//Arrays.sort도 정렬가능. *단 Integer형태(Box)여야함

import java.util.*;

class 최솟값_만들기 {
    public int solution(int []A, int []B)
    {
        int answer = 0;

        Integer[] b = new Integer[B.length];
        for(int i=0 ; i<B.length; i++){
            b[i] = B[i];
        }
        Arrays.sort(A);
        Arrays.sort(b,Collections.reverseOrder());

        for(int i=0; i<A.length; i++){
            answer += A[i] * b[i];
        }
        return answer;
    }
}