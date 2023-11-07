package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1220_Magnetic {

    static int N;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        int count =1;

        while(count<=T){
            N = Integer.parseInt(br.readLine());
            result = 0;
            int[][] arr = new int[N][N];

            StringTokenizer st;
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 세로로 잘라내기.
            for(int i=0; i<N; i++){
                int[] newArr = new int[N];
                for(int j=0; j<N; j++){
                    newArr[j] = arr[j][i];
                }
                //한줄씩 체크
                scan(newArr);
            }

            System.out.printf("#%d %d\n",count,result);
            count++;
        }
    }

    // 교착 조건 : 빨강색 기준으로 파랑색을 만나면 교착된다.
    static void scan(int[] arr){
        int check = 0;
        for(int i=0; i<N; i++){
            if(arr[i] == 1){
                check= 1;
            }
            if(check == 1 && arr[i] == 2){
                check = 2;
                result++;
            }
        }
    }
}
