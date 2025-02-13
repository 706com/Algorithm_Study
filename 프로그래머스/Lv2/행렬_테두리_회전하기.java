package 프로그래머스.Lv2;

//[250213] 30분

// 10000 , 10000 * 10000 * 4 (가능)

import java.util.*;

public class 행렬_테두리_회전하기 {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = {};

        int[][] arr = new int[rows+1][columns+1];
        List<Integer> list = new ArrayList<>();

        int count = 1;
        for(int i=1; i<=rows; i++){
            for(int j=1; j<=columns; j++){
                arr[i][j] = count;
                count++;
            }
        }
        // printArr(arr);

        for(int[] query : queries){
            int x1 = query[0];
            int y1 = query[1];
            int x2 = query[2];
            int y2 = query[3];

            int temp = arr[x1][y1];
            int minNum = temp;
            for(int i=x1; i<x2; i++){
                arr[i][y1] = arr[i+1][y1];
                minNum = Math.min(minNum,arr[i][y1]);
            }
            // printArr(arr);

            for(int i=y1; i<y2; i++){
                arr[x2][i] = arr[x2][i+1];
                minNum = Math.min(minNum,arr[x2][i]);
            }
            // printArr(arr);

            for(int i=x2; i>x1; i--){
                arr[i][y2] = arr[i-1][y2];
                minNum = Math.min(minNum,arr[i][y2]);
            }
            // printArr(arr);

            for(int i=y2; i>y1; i--){
                arr[x1][i] = arr[x1][i-1];
                minNum = Math.min(minNum,arr[x1][i]);
            }
            arr[x1][y1+1] = temp;
            // printArr(arr);

            // System.out.println("다음");
            // System.out.println(minNum);
            list.add(minNum);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
    public void printArr(int[][] arr){
        for(int i=1; i<arr.length; i++){
            for(int j=1; j<arr[0].length; j++){
                System.out.print(arr[i][j] +" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
