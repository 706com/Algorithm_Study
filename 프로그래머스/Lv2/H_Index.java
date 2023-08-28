package 프로그래머스.Lv2;

import java.util.Arrays;

public class H_Index {
    public int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);

        for(int i=0; i<citations.length; i++){
            int h = citations.length - i;   //갯수

            // 인용된 수가 현재 갯수보다 많니?
            // -> 참이 되는 순간 그 갯수가 정답
            if(citations[i] >= h){
                answer = h;
                break;
            }
        }
        System.out.println(answer);
        return answer;

    }
    public static void main(String[] args) {
        int[] citations= {3,0,6,1,5};

        H_Index sol = new H_Index();
        sol.solution(citations);
    }
}
