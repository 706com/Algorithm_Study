package SWEA;

// < 알고리즘 유형 >
// 분할정복

// < 풀이 접근 >
// 1. 행 9개에 문제가 없는지 탐색한다.
// 2. 열 9개에 문제가 없는지 탐색한다.
// 3. 1/3 을 한 분할부분이 문제가 없는지 탐색한다.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class _1974_스도쿠_검증 {

    static int N = 9;
    static int test = 1;
    static int[][] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while(T--> 0){
            boolean check = true;
            arr = new int[N][N];
            visited = new boolean[N+1];

            for(int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    int n = Integer.parseInt(st.nextToken());
                    arr[i][j] = n;
                }
            }

            // 행 체크
            for(int i=0; i<N; i++){
                if(!check(arr[i])){
                    check = false;
                }
                visited = new boolean[N+1];

            }

            // 열 체크
            for(int i=0; i<N; i++){
                int[] colArr = new int[N];

                for(int j=0; j<N; j++) {
                    colArr[j] = arr[j][i];
                }
                if(!check(colArr)){
                    check = false;
                }
                visited = new boolean[N+1];

            }

            int[] boxArr = new int[N];
            //분할 체크
            int row = 0;
            int col = 0;
            for(int i=0; i<3;i++){
                for(int j=0; j<3; j++) {
                    for (int a = col; a < col + 3; a++) {
                        int k = 0;
                        for (int b = row; b < row + 3; b++) {
                            if(a%3==0) {
                                boxArr[k] = arr[a][b];
                            }
                            else if(a%3==1) {
                                boxArr[k + 3] = arr[a][b];
                            }
                            else if(a%3==2) {
                                boxArr[k + 6] = arr[a][b];
                            }
                            k++;
                        }
                    }
//                    for(int x : boxArr){
//                        System.out.print(x+" ");
//                    }
//                    System.out.println();
                    row = (row + 3) % 9;
                    if(!check(boxArr)){
                        check = false;
                    }
                    visited = new boolean[N+1];
                }
                col = (col+3) % 9;
            }

            if(check){
                System.out.printf("#%d 1",test);
            }
            else{
                System.out.printf("#%d 0",test);
            }
            test++;
            System.out.println();
        }
    }
    static boolean check(int[] num){
        for(int x : num){
            if(!visited[x]){
                visited[x] = true;
            }
            else{
                return false;
            }
        }
        return true;
    }
}
