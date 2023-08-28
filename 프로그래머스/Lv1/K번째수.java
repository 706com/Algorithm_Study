package 프로그래머스.Lv1;
//[프로그래머스] K번째수 - JAVA(자바)

//< 알고리즘 유형 >
// 정렬

//< 알고리즘 풀이 >
// 조건에 맞게 배열을 복사 및 쪼갠 후 답안 출력

//< 새로 알게된 것 >
// Arrays.copyOfRange : split 과 같이 배열을 복사 후 인덱스대로 쪼갤 수 있다.

//< 궁금한 것 >

import java.util.Arrays;

public class K번째수 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        answer = new int[commands.length];


        for(int a=0; a< commands.length; a++){
            int[] temp;
            int i = commands[a][0];
            int j = commands[a][1];
            int k = commands[a][2];

            temp = Arrays.copyOfRange(array, i-1,j);

            Arrays.sort(temp);
            answer[a] = temp[k-1];
        }

        for(int a=0; a< commands.length; a++){
            System.out.print(answer[a]+" ");
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4,4,1}, {1,7,3}};
        K번째수 sol = new K번째수();
        sol.solution(array,commands);
    }
}
