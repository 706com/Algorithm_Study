package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _4613_러시아_국기_같은_깃발 {
    static int N,M;
    static char[][] arr;
    static int white,blue,red;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int count = 1;
        while(count<=T){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            arr= new char[N][M];

            for(int i=0; i<N; i++){
                String str = br.readLine();
                for(int j=0; j<M; j++){
                    arr[i][j] = str.charAt(j);
                }
            }

            int min =Integer.MAX_VALUE;
            for(int i=0; i<N-2; i++){
                for(int j=i+1; j<N-1; j++){
                    for(int k=j+1; k<N; k++){
                        white = 0;
                        blue = 0;
                        red = 0;

                        white(0,i);
                        blue(i+1,j);
                        red(j+1,N-1);
//                        System.out.println(white+" "+blue+" "+red);
                        min = Math.min(min,white+blue+red);
                    }
                }
            }
            System.out.printf("#%d %d\n",count,min);
            count++;
        }
    }
    static void white(int start, int end){
        for(int i=start; i<=end; i++){
            for(int j=0; j<M; j++){
                if(arr[i][j] != 'W'){
                    white++;
                }
            }
        }
    }
    static void blue(int start, int end){
        for(int i=start; i<=end; i++){
            for(int j=0; j<M; j++){
                if(arr[i][j] != 'B'){
                    blue++;
                }
            }
        }
    }
    static void red(int start, int end){
        for(int i=start; i<=end; i++){
            for(int j=0; j<M; j++){
                if(arr[i][j] != 'R'){
                    red++;
                }
            }
        }
    }
}
