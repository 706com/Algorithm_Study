package SWEA;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _2805_농작물_수확하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int count = 1;
        while(count<=T){
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];
            int result = 0;

            for(int i=0; i<N; i++){
                String str = br.readLine();
                for(int j=0; j<N; j++){
                    arr[i][j] = Character.getNumericValue(str.charAt(j));
                }
            }

            int start =0;
            for(int i=0; i<=N/2; i++){
                for(int j=N/2-start; j<=N/2+start; j++){
                    result += arr[i][j];
                }
                start++;
            }

            start--;
            start--;
            for(int i=N/2+1; i<N; i++){
                for(int j=N/2-start; j<=N/2+start; j++){
                    result += arr[i][j];
                }
                start--;
            }
            System.out.printf("#%d %d\n",count,result);
            count++;
        }
    }
}
