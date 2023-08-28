package 백준.Silver;//1920 : 수찾기
//깨달은 것
//BufferedReader , readLine()
//StringTokenizer , nextToken()
//

//+ hashmap 으로 풀 수 있음

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1920_수찾기 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            int N = Integer.parseInt(br.readLine());
            Map<Integer, Integer> map = new HashMap<>();

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                int value = Integer.parseInt(st.nextToken());
                map.put(value, map.getOrDefault(value, 0) + 1);
            }

            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < M; i++) {
                int result = Integer.parseInt(st.nextToken());

                if (map.containsKey(result)) {
                    sb.append("1").append('\n');
                } else {
                    sb.append('0').append('\n');
                }
            }
            System.out.println(sb);
    }
}



//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int N = Integer.parseInt(br.readLine());
//        int[] A = new int[N];
//
//        //공백단위 토큰화
//        StringTokenizer st = new StringTokenizer(br.readLine()," ");
//
//        for(int i=0; i<A.length; i++){
//            A[i] = Integer.parseInt(st.nextToken());
//        }
//
//        int M = Integer.parseInt(br.readLine());
//        int[] arr2 = new int[M];
//
//        st = new StringTokenizer(br.readLine()," ");
//
//        for(int i=0; i<arr2.length; i++){
//            arr2[i] = Integer.parseInt(st.nextToken());
//        }
//
//        //이분탐색 하기 위해서는 배열이 무조건 정렬 되어 있어야함!
//        Arrays.sort(A);
//
//
//        for(int i=0; i<arr2.length; i++) {
//            //binary 함수에 A배열과 key 값을 전달
//            int key = arr2[i];
//            boolean rst = binary(A, key);
//
//            if(rst){
//                System.out.println("1");
//            }
//            else{
//                System.out.println("0");
//            }
//        }
//    }
//
//    public static boolean binary(int[] A,int key){
//
//        int low = 0;
//        int mid = 0;
//        int high = A.length-1;
//
//        //low 값이 high를 넘어서는 순간까지 반복
//        while(low<=high){
//            mid = (low+high) / 2;
//
//            if(key < A[mid]){
//                high = mid-1;
//            }
//            else if(key > A[mid]){
//                low = mid +1;
//            }
//            else{
//                //찾을 경우 true 반환
//                return true;
//            }
//        }
//        //반복문이 끝날 때 까지 못찾으면 false 반환
//        return false;
//    }