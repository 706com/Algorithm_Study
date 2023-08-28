package 백준.Silver;

//[백준]10816 : 숫자카드2 - JAVA(자바)

//<새로 알게된 것>
//이분탐색 lower_bound 그리고 upper_bound

// +Hash 로 풀기

//<궁금한 것>
//이분탐색 과정을 완벽히 머릿속으로 이해하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class _10816_숫자카드2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer,Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");


        for(int i=0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());
            map.put(num , map.getOrDefault(num,0) +1);
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<M; i++){
            int result = Integer.parseInt(st.nextToken());
            if(map.containsKey(result))
                sb.append(map.get(result)).append(" ");
            else{
                sb.append("0").append(" ");
            }
        }

        System.out.println(sb);
    }
}


//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//
//        //첫 번째 N배열 입력받기
//        int N = Integer.parseInt(br.readLine());
//        int[] arrN = new int[N];
//
//        StringTokenizer st = new StringTokenizer(br.readLine()," ");
//        for(int i=0; i<N; i++){
//            arrN[i] = Integer.parseInt(st.nextToken());
//        }
//
//        //두 번째 M배열 입력받기
//        int M = Integer.parseInt(br.readLine());
//        int[] keyM = new int[M];
//
//        st = new StringTokenizer(br.readLine()," ");
//        for(int i=0; i<M; i++){
//            keyM[i] = Integer.parseInt(st.nextToken());
//        }
//
//        //배열 정렬 (이분탐색을 하기 위해)
//        Arrays.sort(arrN);
//        int[] result = new int[keyM.length];
//
//        for(int i=0; i<keyM.length; i++) {
//            int key = keyM[i];
//            int lower = lowerBound(arrN, key);
//            int upper = upperBound(arrN, key);
//
//            sb.append(upper - lower).append(" ");
//        }
//        System.out.println(sb);
//
//    }
//    //lowerBound = 찾고자 하는 값의 '이상'의 값 처음으로 나타나는 위치
//    //이해 팁 : low 에 = 이 포함되면 안됨 (속해있지 않아야 다음 인덱스가 범위에 속함)
//    public static int lowerBound(int arr[],int key){
//        int low = 0;
//        int high = arr.length;
//
//        while(low < high){
//            int mid = (low + high) / 2;
//
//            if(key <= arr[mid]){
//                high = mid;
//            }
//            //else 로 처리 가능하지만 이해하기 위해서
//            else if(key > arr[mid]){
//                low = mid + 1;
//            }
//        }
//        return low;
//    }
//
//    //upperBound = 찾고자 하는 값을 처음으로 '초과'한 값
//    //이해 팁 : low 에 = 이 포함해야함 (속해있어야 다음의 인덱스가 범위를 초과함)
//    public static int upperBound(int arr[],int key){
//        int low = 0;
//        int high = arr.length;
//
//        while(low < high){
//            int mid = (low + high) / 2;
//
//            if(key < arr[mid]){
//                high = mid;
//            }
//            //else 로 처리 가능하지만 이해하기 위해서
//            else if(key >= arr[mid]){
//                low = mid + 1;
//            }
//        }
//        return low;
//    }
