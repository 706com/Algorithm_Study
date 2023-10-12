package SWEA;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class _1979_어디에_단어가_들어갈_수_있을까 {
    static int N,K;
    static int[][] arr;
    static int result;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int count = 1;

        while(count<= T) {
            result = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            arr = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            checkRow();
            checkCol();

            System.out.printf("#%d %d",count,result);
            System.out.println();
            count++;
        }
    }
    public static void checkRow(){
        int[] row = new int[N];

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++) {
                row[j] = arr[i][j];
            }

            int temp = 0;
            for(int j=0; j<N; j++){
                if(row[j] == 1){
                    temp++;
                }
                else{
                    if(temp == K){
                        result++;
                    }
                    temp = 0;
                }
            }
            if(temp == K){
                result++;
            }
        }
    }
    public static void checkCol(){
        int[] col = new int[N];

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++) {
                col[j] = arr[j][i];
            }
            int temp = 0;
            for(int j=0; j<N; j++){
                if(col[j] == 1){
                    temp++;
                }
                else{
                    if(temp == K){
                        result++;
                    }
                    temp = 0;
                }
            }
            if(temp == K){
                result++;
            }
        }
    }
}
