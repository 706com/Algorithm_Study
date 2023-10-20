package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class _1216_회문2 {

    static int N;
    static char[][] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = 10;
        while(T-->0) {
            int count = Integer.parseInt(br.readLine());
            N = 100;
            arr = new char[N][N];

            for(int i=0; i<N; i++){
                String str = br.readLine();
                for(int j=0; j<N; j++){
                    char c = str.charAt(j);
                    arr[i][j] = c;
                }
            }

            // 가로 회문 판별
            int max = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++) {
                    int temp = solveRow(i,j);
                    if(max<temp){
                        max = temp;
                    }
                }
            }

            //세로 회문 판별
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++) {
                    int temp = solveCol(i,j);
                    if(max<temp){
                        max = temp;
                    }
                }
            }
            System.out.printf("#%d %d",count,max);
            System.out.println();
            count++;
        }
    }

    //가로를 판별하는 함수
    public static int solveRow(int l,int a){
        int max =0;

        for (int i = a; i < N; i++) {
            int k = i;
            int count = 0;
            for (int j = a; j <= i; j++) {
//                System.out.println(j + " " + k);
                count++;
                if (j <= k) {
                    if (arr[l][j] != arr[l][k]) {
                        count = 0;
                        break;
                    }
                }
                k--;
            }
            if (max < count) {
                max = count;
            }
//            System.out.println("max = " + l +"번째 "+max);
        }
        return max;
    }

    //세로를 판별하는 함수
    public static int solveCol(int l,int a){
        int max =0;

        for (int i = a; i < N; i++) {
            int k = i;
            int count = 0;
            for (int j = a; j <= i; j++) {
//                System.out.println(j + " " + k);
                count++;
                if (j <= k) {
                    if (arr[j][l] != arr[k][l]) {
                        count = 0;
                        break;
                    }
                }
                k--;
            }
            if (max < count) {
                max = count;
            }
//            System.out.println("max = " + l +"번째 "+max);
        }
        return max;
    }
}
