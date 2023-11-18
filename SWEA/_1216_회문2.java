package SWEA;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 16분 소요

public class _1216_회문2 {
    static int N;
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        int count = 1;
        while(count<=T){
            count = Integer.parseInt(br.readLine());
            N = 100;
            max = 0;
            char[][] arr= new char[N][N];

            for(int i=0; i<N; i++){
                String str = br.readLine();
                for(int j=0; j<N; j++){
                    arr[i][j] = str.charAt(j);
                }
            }

            for(int i=0; i<N; i++){
                searchOdd(arr[i]);
                searchEven(arr[i]);
            }

            for(int i=0; i<N; i++){
                char[] newArr = new char[N];
                for(int j=0; j<N; j++){
                    newArr[j] = arr[j][i];
                }
                searchOdd(newArr);
                searchEven(newArr);
            }


            System.out.printf("#%d %d",count,max);
            System.out.println();
            count++;
        }
    }

    //홀수단위 탐색
    static void searchOdd(char[] arr){
        int side = 0;
        for(int i=0; i<N; i++){
            int cnt = -1;
            for(int j=0; j<N; j++){
                if(i-j<0 || i+j>=N){
                    break;
                }
                if(arr[i-j] != arr[i+j]){
                    break;
                }
                cnt+=2;
            }
            max = Math.max(max,cnt);
        }
    }
    //짝수단위 탐색
    static void searchEven(char[] arr){
        for(int i=0; i<N; i++){
            int start = i;
            int end = i+1;
            int cnt = 0;
            for(int j=0; j<N; j++){
                if(start<0 || end>=N){
                    break;
                }
                if(arr[start] != arr[end]){
                    break;
                }
                cnt+=2;
                start--;
                end++;
            }
            max = Math.max(max,cnt);
        }
    }
}
