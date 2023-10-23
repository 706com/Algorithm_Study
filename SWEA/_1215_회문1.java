package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1215_회문1 {
    static int[][] arr;
    static int N,L;
    static int result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = 1;

        while(count<=10) {
            L = Integer.parseInt(br.readLine());
            N = 8;
            result = 0;

            arr = new int[N][N];

            for(int i=0; i<N; i++) {
                String str = br.readLine();
                for(int j=0; j<N; j++) {
                    arr[i][j] = str.charAt(j);
                }
            }

            for(int i=0; i<N; i++) {
                searchRow(i);
                searchCol(i);
            }
            System.out.printf("#%d %d\n",count,result);
            count++;
        }
    }

    static void searchRow(int l) {

        int k;
        for(int i=0; i<=N-L ; i++) {
            boolean check = true;
            k = i+L-1;

            for(int j=i; j<i+4; j++) {
//				System.out.println("i "+i +" j " +j+ " k "+k);
                if(j<k){
                    if(arr[l][j] != arr[l][k]) {
                        check = false;
                    }
                    k--;
                }
            }
            if(check) {
                result++;
            }
        }
//		System.out.println(result);
    }

    static void searchCol(int l) {

        int k;
        for(int i=0; i<=N-L ; i++) {
            boolean check = true;
            k = i+L-1;

            for(int j=i; j<i+4; j++) {
//				System.out.println("i "+i +" j " +j+ " k "+k);
                if(j<k){
                    if(arr[j][l] != arr[k][l]) {
                        check = false;
                    }
                    k--;
                }
            }
            if(check) {
                result++;
            }
        }
//		System.out.println(result);
    }

}
