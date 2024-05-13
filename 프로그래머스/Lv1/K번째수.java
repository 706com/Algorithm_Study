package 프로그래머스.Lv1;
//[프로그래머스] K번째수 - JAVA(자바)

// 소요시간
// [240513] : 20분

//< 새로 알게된 것 >
// Arrays.copyOfRange : split 과 같이 배열을 복사 후 인덱스대로 쪼갤 수 있다.


import java.util.*;

public class K번째수 {

    /**
     * 시간적 측면은 나아졌으나.. 너무 복잡한 듯!
     */
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        int tc = commands.length;
        int count = 0;
        List<Integer> list = new ArrayList<>();
        while(tc-->0){
            int size = commands[count][1] - commands[count][0] + 1;
            int index = commands[count][2] - 1;
            Integer[] newArr = new Integer[size];

            for(int i=commands[count][0]-1; i<=commands[count][1]-1; i++){

                newArr[i-commands[count][0]+1] = array[i];
            }
            // newArr = Arrays.copyOfRange(array,commands[count][0],commands[count][1]);

            Arrays.sort(newArr);

            // System.out.println(Arrays.toString(newArr));

            list.add(newArr[index]);

            count++;
        }
        // return answer;
        return list.stream().mapToInt(Integer::intValue).toArray();
    }


    public int[] solution2(int[] array, int[][] commands) {
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
