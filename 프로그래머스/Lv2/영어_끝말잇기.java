package 프로그래머스.Lv2;

//소요시간 : 24분

import java.util.*;

public class 영어_끝말잇기 {
    class Solution {
        public int[] solution(int n, String[] words) {

            Map<String,Integer> map  = new HashMap<>();
            int[] arr = new int[n+2];
            int peopleIndex = 1;

            map.put(words[0],1);
            for(int i=1; i<words.length; i++){
                //사람 순서와 몇번째 단어인지 카운트
                arr[peopleIndex]++;
                peopleIndex++;
                if(peopleIndex == n+1){
                    peopleIndex = 1;
                }
                // System.out.println(Arrays.toString(arr));
                if(map.containsKey(words[i])){
                    //같은단어 반복 : 결과 반환
                    return new int[]{peopleIndex,arr[peopleIndex]+1};
                }
                if(words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0)){
                    //앞뒤 다름 : 결과반환
                    return new int[]{peopleIndex,arr[peopleIndex]+1};
                }
                //해시에 넣어주기
                map.put(words[i],1);
            }
            return new int[]{0,0};
        }
    }
}
