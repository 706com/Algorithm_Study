package 백준;

//2751 : 수 정렬하기 2

//<새로 알게된 것>
//ArrayList 선언법
//list.sort(comparator.~~());
//+ collection과 list.sort 차이점
//+StringBuilder 사용법

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class _2751_수_정렬하기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> arr = new ArrayList<Integer>();

        for(int i=0; i<N; i++){
            arr.add(Integer.parseInt(br.readLine()));
        }

        //Comparator.naturalOrder() : 오름차순
        //Comparator.reverseOrder() : 내림차순
        //arr.sort(Comparator.naturalOrder());
        Collections.sort(arr);

        for(int i=0; i<N; i++){
            sb.append(arr.get(i)).append('\n');
        }
        System.out.println(sb);

    }
}

//실패2 사유 -> 시간초과
//package 백준;
//
////2751 : 수 정렬하기 2
//
////<새로 알게된 것>
////ArrayList 선언법
////list.sort(comparator.~~());
////+ collection과 list.sort 차이점
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
//
//public class _2751_수_정렬하기2 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//
//        ArrayList<Integer> arr = new ArrayList<Integer>();
//
//        for(int i=0; i<N; i++){
//            arr.add(Integer.parseInt(br.readLine()));
//        }
//
//        //Comparator.naturalOrder() : 오름차순
//        //Comparator.reverseOrder() : 내림차순
//        //arr.sort(Comparator.naturalOrder());
//        Collections.sort(arr);
//
//        for(int i=0; i<N; i++){
//            System.out.println(arr.get(i));
//        }
//
//    }
//}


//실패1 : 사유 -> 시간초과
//package 백준;
//
////2751 : 수 정렬하기 2
//
////<새로 알게된 것>
////ArrayList 선언법
////list.sort(comparator.~~());
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Comparator;
//
//public class _2751_수_정렬하기2 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//
//        ArrayList<Integer> arr = new ArrayList<Integer>();
//
//        for(int i=0; i<N; i++){
//            arr.add(Integer.parseInt(br.readLine()));
//        }
//
//        //Comparator.naturalOrder() : 오름차순
//        //Comparator.reverseOrder() : 내림차순
//        arr.sort(Comparator.naturalOrder());
//
//        for(int i=0; i<N; i++){
//            System.out.println(arr.get(i));
//        }
//
//    }
//}
