package 백준.Gold;

// < 알고리즘 유형 >
// 백트래킹

// < 풀이 접근 >
// 1. nQueen을 구현한다. (백트래킹)
//  -> arr 의 역할 : 해당 행(인덱스) 안의 열을 의미한다.
//  -> 만일 check() 함수를 '통과하면' nQueen의 depth(row) 를 증가시킨다.
// 2. check() 를 구현한다.
//  -> 성립불가조건 1) 같은 열 , 행
//  -> 성립불가조건 2) 대각선
// 3. 체스판이 모두 채워졌다면 ( depth(row) 가 N 에 도달)
//  -> count ++
// 4. 값을 출력시킨다.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class _9663_N_Queen {

    static int N ;
    static int[] arr;
    static int count = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        // 1. nQueen()을 구현한다. (백트래킹)
        nQueen(0);

        // 4. 값을 출력시킨다.
        System.out.println(count);
    }

    static void nQueen(int depth){

        // 3. 체스판이 모두 채워졌다면 ( depth(row) 가 N 에 도달)
        //  -> count ++
        if(depth == N){
            count++;
            return;
        }

        for(int i=0; i<N; i++){
             //  -> arr 의 역할 : 해당 행(인덱스) 안의 열(값)을 의미한다.
             arr[depth] = i;

             //  -> 만일 check() 함수를 '통과하면' nQueen의 depth(row) 를 증가시킨다.
             if(check(depth)){
                 nQueen(depth+1);
             }
        }
    }

    // 2. check() 를 구현한다.
    static boolean check(int row){

        for(int i=0; i<row; i++){
            //  -> 성립불가조건 1) 같은 열 , 행
            if(arr[row] == arr[i]){
                return false;
            }
            //  -> 성립불가조건 2) 대각선
            else if(Math.abs(row-i) == Math.abs(arr[row]-arr[i])){
                return false;
            }
        }
        return true;
    }

}
