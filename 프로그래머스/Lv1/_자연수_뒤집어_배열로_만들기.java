package 프로그래머스.Lv1;

import java.util.*;

public class _자연수_뒤집어_배열로_만들기 {
    //방법1 : 시간 0.05ms
    // char[] 배열로 변환 후 대입
    class Solution {
        public int[] solution(long n) {

            char[] arr = String.valueOf(n).toCharArray();
            int [] answer = new int[arr.length];

            int index = 0;
            for(int i=arr.length-1; i>=0; i--){
                answer[index] = arr[i]-'0';
                index++;
            }

            return answer;
        }
    }

    //방법2 : 시간 : 0.22ms
    //StringBuilder.reverse() 활용 후 대입
    class Solution2 {
        public int[] solution(long n) {
            StringBuilder sb = new StringBuilder();
            sb.append(n).reverse();
            String str = sb.toString();
            System.out.println(str);
            int[] answer = new int[str.length()];

            for(int i=0; i<sb.length(); i++){
                answer[i] = str.charAt(i) -'0';
            }
            return answer;
        }
    }
}
