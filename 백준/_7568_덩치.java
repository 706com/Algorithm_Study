package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _7568_덩치 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][2];

        //입력받기
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<2; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] result = new int[N];
        int rank = 1;

        for(int i=0; i<N; i++){

            for(int j=i+1; j<N; j++)
                if(arr[i][0] < arr[j][0]){
                    if(arr[i][1] < arr[j+1][1]){
                        rank++;
                    }
                }
            result[i] = rank;
        }

        for(int i=0; i<N; i++) {
            System.out.print(result[i] + " ");
        }






    }
}
