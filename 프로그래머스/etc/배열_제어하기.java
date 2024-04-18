package 프로그래머스.etc;

//p.109

import java.util.Arrays;
import java.util.Collections;

//배열의 중복값을 제거하고 배열 데이터를 내림차순으로 정렬해서 반환
public class 배열_제어하기 {
    public static int[] solution(int[] arr){
        int[] newArr = arr.clone();

        //1. 중복값을 제거한다.
        Integer[] result = Arrays.stream(newArr)
                .boxed()    // 프리미티브형 -> 참조형
                .distinct() //중복제거
                .toArray(Integer[]::new);   //Stream -> Array 형 변환

        //2. 내림차순으로 정렬한다.
        Arrays.sort(result,Collections.reverseOrder());

        //3. 결과값을 반환한다.
        return Arrays.stream(result).mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] a = solution(new int[]{4,2,2,1,3,4});
        int[] b = solution(new int[]{2,1,1,3,2,5,4});

        System.out.println(Arrays.toString(a)); //4,3,2,1
        System.out.println(Arrays.toString(b)); //5,4,3,2,1

    }
}
