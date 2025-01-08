package BOJ._2_Silver;
//[백준]10815 : 숫자 카드 - JAVA(자바)

//[250108] 해시 5분 -> memory : 137304 , time : 864ms
//[250108] 이분탐색 : 10분 -> memory : 104824 , time : 1192ms

import java.io.*;
import java.util.*;

public class _10815_숫자_카드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Map<Integer,Integer> map = new HashMap<>();

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());
            map.put(num,1);
        }

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            int num = Integer.parseInt(st.nextToken());
            if(map.containsKey(num)){
                sb.append(1).append(" ");
            } else{
                sb.append(0).append(" ");
            }
        }
        System.out.println(sb);
    }
}

// 이분탐색
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//
//        int N = Integer.parseInt(br.readLine());
//        int[] arr= new int[N];
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        for(int i=0; i<N; i++){
//            arr[i] = Integer.parseInt(st.nextToken());
//        }
//        Arrays.sort(arr);
//
//        int M = Integer.parseInt(br.readLine());
//
//        st = new StringTokenizer(br.readLine());
//        for(int i=0; i<M; i++){
//            int num = Integer.parseInt(st.nextToken());
//
//            int left = 0;
//            int right = N-1;
//            boolean flag = false;
//
//            while(left<=right){
//                int mid = (left + right) / 2;
//
//                if(arr[mid] == num){
//                    flag = true;
//                    break;
//                }
//                else if(arr[mid] < num){
//                    left = mid+1;
//                } else{
//                    right = mid-1;
//                }
//            }
//            if(flag){
//                sb.append(1).append(' ');
//            } else{
//                sb.append(0).append(' ');
//            }
//        }
//        System.out.println(sb);
//    }