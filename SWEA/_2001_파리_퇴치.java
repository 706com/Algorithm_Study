package SWEA;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class _2001_파리_퇴치 {


    static int N,M;
    static int[][] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int count = 1;

        while(count<=T){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            int sum = 0;
            int max = 0;

            arr = new int[N][N];

            for(int i=0; i<N; i++){
                st= new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=0; i<=N-M; i++) {
                for(int j=0; j<=N-M; j++) {
                    sum = cutAndSum(i,j);
                    if(max<sum){
                        max = sum;
                    }
                }
            }

            System.out.printf("#%d %d",count, max);
            System.out.println();
            count++;
        }
    }

    public static int cutAndSum(int x ,int y){
        int sum = 0;
        for(int i=0; i<M; i++){
            for(int j=0; j<M; j++){
                sum += arr[x+i][y+j];
            }
        }
//        System.out.println("sum " + sum);
        return sum;
    }

}
