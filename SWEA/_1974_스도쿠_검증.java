package SWEA;

// < 알고리즘 유형 >
// 분할정복

// < 풀이 접근 >
// 1. 행 9개에 문제가 없는지 탐색한다.
// 2. 열 9개에 문제가 없는지 탐색한다.
// 3. 1/3 을 한 분할부분이 문제가 없는지 탐색한다.

//28분 소요

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1974_스도쿠_검증 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int T  =Integer.parseInt(br.readLine());
        int count = 1;
        while(count<=T){
            N = 9;
            int result = 0;

            int[][] arr = new int[N][N];
            for(int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            //가로탐색
            boolean check = true;
            for(int i=0; i<N; i++){
                check = search(arr[i]);
                if(!check){
                    break;
                }
            }
            //세로탐색
            for(int i=0; i<N; i++){
                //이전에 스도쿠가 아닌게 있으면 탐색 의미 없음
                if(!check){
                    break;
                }
                int[] newArr = new int[N];
                for(int j=0; j<N; j++){
                    newArr[j] = arr[j][i];
                }
                check = search(newArr);
            }
            //3*3 탐색
            int start= 0;
            for(int i=0; i<N; i++){
                if(!check){
                    break;
                }
                check = search2(arr,start);
                if(i!=0 && i%3==0){
                    start+=3;
                }
            }
            if(check){
                result = 1;
            }
            else{
                result = 0;
            }
            System.out.printf("#%d %d",count,result);
            System.out.println();
            count++;
        }
    }
    static boolean search(int[] arr){
        int[] num = new int[10];
        //탐색 후 1~9 숫자세기
        for(int i=0; i<N; i++){
            num[arr[i]]++;
        }
        // 하나라도 0이 있다 -> 어딘가에 겹치는 숫자가 있다
        for(int i=1; i<=N; i++){
            if(num[i] == 0){
                return false;
            }
        }
        return true;
    }

    static boolean search2(int[][] arr,int start){
        int[] num = new int[10];
        for(int i=start; i<start+3; i++){
            for(int j=start; j<start+3; j++){
                num[arr[i][j]]++;
            }
        }
        for(int i=1; i<=N; i++){
            if(num[i] == 0){
                return false;
            }
        }
        return true;
    }
}
