package BOJ.fail;

//[241219] 실패

import java.util.*;
import java.io.*;

public class _17140_이차원_배열과_연산 {

    static int r,c,k;
    static int[][] arr;
    static int lenX = 3;
    static int lenY = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());   //행
        c = Integer.parseInt(st.nextToken());   //열
        k = Integer.parseInt(st.nextToken());   //k값이 되기

        arr = new int[101][101];

        for(int i=1; i<=3; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=3; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        // A[r][c]에 들어있는 값이 k가 되기 위한 최소 시간을 구하기
        for(int i=0; i<=100; i++){
            if(arr[r][c] == k){
                break;
            }
            operate();
            time++;
        }
        System.out.println(time);
    }
    static void operate(){
        //R 연산: 배열 A의 모든 행에 대해서 정렬을 수행한다. 행의 개수 ≥ 열의 개수인 경우에 적용된다.
        if(lenX >= lenY){
            for(int i= 1; i<= lenX; i++){
                operateR(i);
            }
        }
        //C 연산: 배열 A의 모든 열에 대해서 정렬을 수행한다. 행의 개수 < 열의 개수인 경우에 적용된다.
        else{
            for(int i=1; i<=lenY; i++){
                operateC(i);
            }
        }
    }
    // 한 행 또는 열에 있는 수를 정렬하려면, 각각의 수가 몇 번 나왔는지 알아야 한다.
    // 그 다음, 수의 등장 횟수가 커지는 순으로, 그러한 것이 여러가지면 수가 커지는 순으로 정렬한다.
    // 그 다음에는 배열 A에 정렬된 결과를 다시 넣어야 한다.
    // 정렬된 결과를 배열에 넣을 때는, 수와 등장 횟수를 모두 넣으며, 순서는 수가 먼저이다.

    // 정렬된 결과를 배열에 다시 넣으면 행 또는 열의 크기가 달라질 수 있다.
    // -> R 연산이 적용된 경우에는 가장 큰 행을 기준으로 모든 행의 크기가 변하고
    // -> C 연산이 적용된 경우에는 가장 큰 열을 기준으로 모든 열의 크기가 변한다.
    // 행 또는 열의 크기가 커진 곳에는 0이 채워진다
    // 수를 정렬할 때 0은 무시해야 한다.
    // ->예를 들어, [3, 2, 0, 0]을 정렬한 결과는 [3, 2]를 정렬한 결과와 같다.
    static void operateR(int key){

    }
    static void operateC(int key){

    }
}
