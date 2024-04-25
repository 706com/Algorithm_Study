package 프로그래머스.etc;

//p236

// 소요시간
// [240425] : 정답 참고


// <문제>
// n개의 양의 정수로 이루어진 배열 arr와 정수 target이 주어졌을 때 이 중에서 합이 target인 두 수가 arr에 있는지 찾고,
// 있으면 true, 없으면 false를 반환하는 solution을 작성하세요.

// <제약조건>
// n은 2 이상 10,000 이하 자연수
// arr의 각 원소는 1 이상 10,000이하의 자연수
// arr의 원소 중 중복되는 원소는 없음
// target은 1 이상 20,000 이하의 자연수

// < 입출력 예시>
// arr          target      return
// [1,2,3,4,5]  6           true
// [2,3,5,9]    10          false

import java.util.*;

public class 두_개의_수로_특정값_만들기 {

    public static boolean solution(int[] arr, int target){
        // 해시맵을 만들어서 배열의 요소들을 담는다.
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int x : arr){
            hm.put(x,1);
        }
        // 타겟에서 배열의 요소의 하나를 뺀 값이 해시맵 안에 있는지 확인한다. (해시맵 탐색속도는 굉장히 빠르다.)
        for(int x : arr){
            if(target-x == x){
                //같은원소 2개는 없는것 예외처리
                continue;
            }
            // -> 있으면 true 반환
            if(hm.containsKey(target-x)){
                System.out.println(x+" " + (target-x));
                return true;
            }
        }
        // -> 끝까지 못찾았다면, false 반환
        return false;
    }
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,8};
        int target1 = 6;
        System.out.println(solution(arr1, target1)); //true

        int[] arr2 = {2,3,5,9};
        int target2 = 10;
        System.out.println(solution(arr2,target2)); //false
    }
}
