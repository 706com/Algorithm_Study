package BOJ.fail;

//소요시간 : 25분(실패 : 구현실패) -> N크기 만큼의 비숍인 줄 알았는데.. 7개 ㄱ-

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1799_비숍 {
    static int N;
    static int[][] arr;
    static int[] position;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        position = new int[7];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bishop(0);
        System.out.println(count);
    }
    static void bishop(int depth){
        if(depth == N){
            System.out.println(Arrays.toString(position));
            count++;
            return;
        }
        for(int i=0; i<N; i++){
            // 놓지 못하는 곳이면 pass
            if(arr[i][depth] == 0){
                continue;
            }
            position[depth] = i;

            if(check(depth)){
                bishop(depth+1);
            }
        }
    }
    static boolean check(int depth){
        for(int i=0; i<depth; i++){
//            if(position[i] == position[depth]){
//                return false;
//            }
            //대각선상에 위치
            if(Math.abs(position[i]-position[depth]) == Math.abs(i-depth)){
                return false;
            }
        }
        return true;
    }
}
