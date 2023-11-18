package SWEA;

// 9분 소요

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1285_아름이의_돌_던지기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int count = 1;
        while(count<=T){
            int N = Integer.parseInt(br.readLine());
            int min = Integer.MAX_VALUE;
            int[] arr = new int[N];
            int num = 0;

            // 배열에 담기
            // 최솟값 도출 : 0에서 뺀값(멀어진 값)이 최솟값
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                num = Integer.parseInt(st.nextToken());
                arr[i] = num;
                min = Math.min(min,Math.abs(0-num));
            }
            int people = 0;

            //최솟값과 절댓값이 일치한 사람 수 세기.
            for(int i=0; i<N; i++){
                if(min == Math.abs(arr[i])){
                    people++;
                }
            }

            System.out.printf("#%d %d %d",count,min,people);
            System.out.println();
            count++;
        }
    }
}
