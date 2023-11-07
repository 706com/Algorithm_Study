package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// < 풀이 접근 >
// 1. 배열을 입력한다.
// 2. 배열을 행, 열 ,대각선 순으로 잘라낸다.
// 3. 잘라낸 배열을 한줄씩 읽어 더하고 저장한다.
// 4. 저장한 크기중 최댓값을 도출한다.

public class _1209_Sum {
    static int max;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T  = 10;
        int count = 1;

        while(count<T){
            count= Integer.parseInt(br.readLine());
            N = 100;
            max = 0;
            int[][] arr = new int[N][N];

            StringTokenizer st;
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=0; i<N; i++){
                search(arr[i]);
            }

            for(int i=0; i<N; i++){
                int[] newArr = new int[N];
                for(int j=0; j<N; j++){
                    newArr[j] = arr[j][i];
                }
                search(newArr);
            }

            int[] newArr = new int[N];
            for(int i=0; i<N; i++){
                newArr[i] = arr[i][i];
            }
            search(newArr);

            int temp = 99;
            for(int i=0; i<N; i++){
                newArr[i] = arr[i][temp];
                temp--;
            }
            search(newArr);

            System.out.printf("#%d %d\n",count,max);
        }
    }
    public static void search(int[] arr){
        int sum = 0;
        for(int i=0; i<N; i++){
            sum += arr[i];
        }
        max = Math.max(max,sum);
    }
}
