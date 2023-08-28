package 프로그래머스.Lv2;
//[프로그래머스] 가장 큰 수 - JAVA(자바)

//< 알고리즘 유형 >
// 정렬

//< 알고리즘 풀이 >
// 맨 앞자리 기준으로 정렬 시키면 가장 큰 수가 될 것 같다. -> 시간초과 + 비효율
// -> comparator 로 (b+a).compareTo(a+b) 처럼 문자열을 비교하여 정렬시킨다. 610 > 106

//< 새로 알게된 것 >

//< 궁금한 것 >

import java.util.*;

public class 가장_큰_수 {
    public String solution(int[] numbers) {
        String answer ="";
        String[] arr = new String[numbers.length];

        // int to String
        for(int i=0; i<numbers.length; i++){
            arr[i] = String.valueOf(numbers[i]);
        }

        // 문자열 기준으로 내림차순 정렬
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });

        if(arr[0].equals("0")){
            return "0";
        }

        for(String x : arr){
            answer += x;
        }

//        System.out.println(answer);

        return answer;
    }

    public static void main(String[] args) {
//        int[] numbers= {6, 10, 2};
        int[] numbers= {3, 30, 34, 5, 9};

        가장_큰_수 sol = new 가장_큰_수();
        sol.solution(numbers);
    }
}
