package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

// < Refactor >
// 초기 arr 로 계속 활용하려다 보니까, 함수가 많아지고 코드가 지저분해졌다. (+쓸데없는 시간낭비)
// 계속 같은방향으로 회전 시킨다는걸 이용했다면 하나의 함수로 묶을 수 있다는 것을
// 팀원들 코드 보고 깨달음.... OTL


public class _1961_숫자_배열_회전 {

    static int[][] arr;
    static int N;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T= Integer.parseInt(br.readLine());
        int count = 1;

        while(count<=T){
            N = Integer.parseInt(br.readLine());

            String[][] result = new String[N][3];
            for(int i=0; i<N; i++){
                for(int j=0; j<3; j++){
                    result[i][j] = "";
                }
            }

            arr = new int[N][N];

            for(int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] rotate90 = rotate90();
            int[][] rotate180 = rotate180();
            int[][] rotate270 = rotate270();

            // 결과 배열 붙이기
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    result[i][0] += rotate90[i][j];
                }
            }

            // 결과 배열 붙이기
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    result[i][1] += rotate180[i][j];
                }
            }

            // 결과 배열 붙이기
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    result[i][2] += rotate270[i][j];
                }
            }

            //결과 출력
            System.out.println("#"+count);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(result[i][j]+" ");
                }
                System.out.println();
            }

            count++;
        }
    }

    static int[][] rotate90(){
        int[][] rotate90 = new int[N][N];

        int k=0;
        for (int i = N - 1; i >= 0; i--) {
            for (int j = 0; j < N; j++) {
                rotate90[j][i] = arr[k][j];
            }
            k++;
        }
        return rotate90;
    }
    static int[][] rotate180(){
        int[][] rotate = new int[N][N];

        int l=N-1;
        for (int i=0; i<N; i++) {
            int k=N-1;
            for (int j = 0; j < N; j++) {
                rotate[l][k] = arr[i][j];
                k--;
            }
            l--;
        }

        return rotate;
    }

    static int[][] rotate270(){
        int[][] rotate = new int[N][N];

        for (int i=0; i<N; i++) {
            int k = N-1;
            for (int j = 0; j < N; j++) {
                rotate[k][i] = arr[i][j];
                k--;
            }
        }
        return rotate;
    }
}
