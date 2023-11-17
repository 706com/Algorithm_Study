package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

//9분

// < 알고리즘 유형 >
// 백트래킹

// < 풀이 접근 >
// *) arr : 해당인덱스 = 행  / 인덱스 값 = 열 을 의미한다.
// 1) 퀸을 하나씩 박아가면서 이전에 퀸이 있는지 확인한다. (=공격범위에 들어오는지 확인한다)
// -> 공격범위 조건 1 ) 이전에 놓여진 퀸과 같은 행, 같은 열에 있으면 안된다.
// -> 공격범위 조건 2 ) 이전에 놓여진 퀸과 대각선에 있으면 안된다.


public class _2806_N_Queen {

    static int N, result;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int count = 1;

        while(count <= T){
            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            result = 0;

            nQueen(0);

            System.out.printf("#%d %d\n",count, result);
            count++;
        }
    }

    public static void nQueen(int depth){
        if(depth == N){
            result++;
            return;
        }

        for(int i=0; i<N; i++){
            arr[depth] = i;     // 퀸 박아두기.

            if(check(depth)){   // 이전 줄에 퀸이 있는지 확인
                nQueen(depth+1);
            }
        }

    }

    public static boolean check(int now){
        for(int before=0; before<now; before++){
            // 같은 행에 있는지 확인 ( 근데 1차원 배열이니까 같은 행 , 같은 열에 있는지까지 확인하는 셈)
            if(arr[now] == arr[before])
                return false;

            // 대각선에 있는지 확인
            else if(Math.abs(now-before) == Math.abs(arr[now]- arr[before]))
                return false;
        }
        return true;
    }
}
