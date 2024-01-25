package BOJ._3_Gold;

//  체스 성립불가조건 1) 같은 열 , 행
//  체스 성립불가조건 2) 대각선

//소요시간 : 16분

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9663_N_Queen {
    static int N;
    static int[] arr;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        queen(0);
        System.out.println(count);
    }
    static void queen(int depth){
        if(depth == N){
            count++;
            return;
        }
        for(int i=0; i<N; i++){
            arr[depth] = i;
            if(check(depth)){
                queen(depth+1);
            }
        }
    }
    static boolean check(int now){
        for(int i=0; i<now; i++){
            if(arr[i] == arr[now]){
                return false;
            }
            if(Math.abs(arr[i]-arr[now]) == Math.abs(i-now)){
                return false;
            }
        }
        return true;
    }
}

