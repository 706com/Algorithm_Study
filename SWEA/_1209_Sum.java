package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;


// < 풀이 접근 >
// 1. 배열을 입력한다.
// 2. 배열을 행, 열 ,대각선 순으로 잘라낸다.
// 3. 잘라낸 배열을 한줄씩 읽어 더하고 저장한다.
// 4. 저장한 크기중 최댓값을 도출한다.

public class _1209_Sum {

    static int LEN = 100;
    static int[] sumRow;
    static int[] sumCol;
    static int[] sumLineX;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = 10;

        while(T-->0){
            int count = Integer.parseInt(br.readLine());
            int[][] arr = new int[LEN][LEN];
            sumRow = new int[LEN];
            sumCol = new int[LEN];
            sumLineX = new int[2];
            int max = Integer.MIN_VALUE;

            // 1. 배열을 입력한다.
            StringTokenizer st;
            for(int i=0; i<LEN; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<LEN; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 2. 배열을 행, 열 ,대각선 순으로 잘라낸다.
            // 3. 잘라낸 배열을 한줄씩 읽어 더하고 저장한다.
            cutAndSumRow(arr);
            cutAndSumCol(arr);
            cutAndSumLineX(arr);

            // 4. 최댓값 구하기
            for(int i=0; i<LEN; i++){
                max = Math.max(max, Math.max(sumRow[i],sumCol[i]));
            }
            for(int i=0; i<2; i++){
                max = Math.max(max,sumLineX[i]);
            }

            System.out.printf("#%d %d",count,max);
            System.out.println();
        }
    }
    public static void cutAndSumRow(int[][] arr){
        int[] row = new int[LEN];
        for(int i=0; i<LEN; i++){
            for(int j=0; j<LEN; j++) {
                row[j] = arr[i][j];
            }
            // 3. 잘라낸 배열을 한줄씩 읽어 더하고 저장한다.
            int result = sum(row);
            sumRow[i] = result;
        }
    }

    public static void cutAndSumCol(int[][] arr){
        int[] col = new int[LEN];
        for(int i=0; i<LEN; i++){
            for(int j=0; j<LEN; j++) {
                col[j] = arr[j][i];
            }
            // 3. 잘라낸 배열을 한줄씩 읽어 더하고 저장한다.
            int result = sum(col);
            sumCol[i] = result;
        }
    }

    public static void cutAndSumLineX(int[][] arr){
        int[] lineX = new int[LEN];
        //왼쪽->오른쪽 대각선
        for(int i=0; i<LEN; i++){
            lineX[i] = arr[i][i];
        }

        int result = sum(lineX);
        sumLineX[0] = result;

        //오른쪽->왼쪽 대각선
        for(int i=0; i<LEN; i++){
            lineX[i] = arr[i][LEN-1-i];
        }
        // 3. 잘라낸 배열을 한줄씩 읽어 더하고 저장한다.
        result = sum(lineX);
        sumLineX[1] = result;

    }
    public static int sum(int[] arr){
        int sum = 0;
        for(int i=0; i<LEN; i++){
            sum+= arr[i];
        }
        return sum;
    }
}
