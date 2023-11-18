package SWEA;

// 7분 소요

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2001_파리_퇴치 {
    static int N,M;
    static int[][] arr;
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int count =1;

        while(count<=T){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            max = 0;

            arr = new int[N][N];
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=0; i<N-M+1; i++){
                for(int j=0; j<N-M+1; j++){
                    hit(i,j);
                }
            }
            System.out.printf("#%d %d",count,max);
            System.out.println();
            count++;
        }
    }
    static void hit(int x, int y){
        int sum = 0;
        for(int i=x; i<x+M; i++){
            for(int j=y; j<y+M; j++){
                sum+= arr[i][j];
            }
        }
        max = Math.max(max,sum);
    }
}
