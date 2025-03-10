package 프로그래머스.Lv3;

//[250310] 30분 : 시간초과 🔍
//[250310] 15분

import java.util.*;

public class 징검다리_건너기 {
    public int solution(int[] stones, int k) {
        int answer = 0;

        int[] arr = stones.clone();

        Arrays.sort(arr);
        // System.out.println(Arrays.toString(arr));

        int left = 0;
        int right = arr.length-1;

        while(left<=right){

            int mid = (left + right) / 2;
            int num = arr[mid];

            int[] stone = stones.clone();
            int cnt = 0;
            boolean flag = false;

            for(int i=0; i<stones.length; i++){
                if(stone[i]-num < 0){
                    cnt++;
                } else{
                    cnt = 0;
                }
                if(cnt >= k){
                    // System.out.println("연속 "+k+"번 으로 인한 종료");
                    flag = true;
                    break;
                }
            }

            // flag 이다 -> 연속 되어서 인원이 너무 크다
            if(flag){
                right = mid - 1;
            }
            // flag가 아니다 -> 좀만 인원을 더 늘려도 된다
            else{
                left = mid +1;
                answer = num;
            }
        }

        return answer;
    }
}
