package BOJ._2_Silver;

// [241104] list 정렬 -> 시간초과
/*
질문의 코드들에서 결정적으로 시간 차이를 내는 것은
primitive type인 int[]를 사용했느냐와 Integer와 ArrayList라는 Object를 사용했느냐입니다.
primitive type에 비해 Object는 비교할 수 없을 정도로 무거운 녀석입니다.
배열에 접근할 때에도 int[]에 대해 arr[i]로 접근하는 것과 arr.get(i)로 접근하는 것에는 영겁의 시간 차이가 있습니다.
정렬을 할 때에도 이 때문에 평균적으로는 ArrayList<Integer>를 정렬하는 시간이 훨씬 깁니다.
* */
// [241104] primitive 타입 사용 -> 4분

import java.io.*;
import java.util.*;

public class _15688_수_정렬하기_5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        for(int x : arr){
            sb.append(x).append("\n");
        }
        System.out.println(sb);
    }
}
