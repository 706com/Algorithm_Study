package BOJ._2_Silver;

//유형 : 이분탐색

//+ hashmap 으로 풀 수 있음

import java.io.*;
import java.util.*;

public class _1920_수_찾기 {
    /**
     * 이분탐색 풀이법 (라이브러리 함수 사용)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer stt = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(stt.nextToken());
        }
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        stt = new StringTokenizer(br.readLine());

        for(int i=0; i<M; i++){
            int target = Integer.parseInt(stt.nextToken());

            int result = Arrays.binarySearch(arr,target);
//            System.out.println(result);
            if(result >= 0){
                sb.append(1).append('\n');
            } else{
                sb.append(0).append('\n');
            }
        }
        System.out.println(sb);
    }

    /**
     * HashMap 풀이
     */
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//        int N = Integer.parseInt(br.readLine());
//        Map<Integer, Integer> map = new HashMap<>();
//
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//        for (int i = 0; i < N; i++) {
//            int value = Integer.parseInt(st.nextToken());
//            map.put(value, map.getOrDefault(value, 0) + 1);
//        }
//
//        int M = Integer.parseInt(br.readLine());
//        st = new StringTokenizer(br.readLine(), " ");
//        for (int i = 0; i < M; i++) {
//            int result = Integer.parseInt(st.nextToken());
//
//            if (map.containsKey(result)) {
//                sb.append("1").append('\n');
//            } else {
//                sb.append('0').append('\n');
//            }
//        }
//        System.out.println(sb);
//    }
}
