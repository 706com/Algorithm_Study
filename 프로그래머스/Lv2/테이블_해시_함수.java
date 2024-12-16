package 프로그래머스.Lv2;

//[241213] 🔍
//[241216] 15분

// XOR : 같으면 0 다르면 1

import java.util.*;

public class 테이블_해시_함수 {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        List<int[]> list = new ArrayList<>();

        for(int i=0; i<data.length; i++){
            list.add(data[i]);
        }

        // col 기준 오름차순, 0번째 기준 내림차순
        Collections.sort(list,new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2){
                if(o1[col-1] == o2[col-1]){
                    return o2[0] - o1[0];
                }
                return o1[col-1]-o2[col-1];
            }
        });

        // for(int[] x : list){
        //     System.out.println(Arrays.toString(x));
        // }

        int sum = 0;

        for(int i=0; i<data[0].length; i++){
            sum += list.get(row_begin-1)[i] % row_begin;
        }

        for(int i=row_begin; i<=row_end; i++){
            sum = 0;
            for(int j=0; j<data[0].length; j++){
                sum += list.get(i-1)[j] % i;
            }
            answer = answer ^ sum;
        }
        // System.out.println(sumA);
        // System.out.println(sumB);

        // answer = sumA;   // XOR 연산 기법
        return answer;
    }
}
