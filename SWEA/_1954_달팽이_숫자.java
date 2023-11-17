package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class _1954_달팽이_숫자 {
    static int N;
    static int[][] arr;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int count = 1;

        while(count<=T){
            N = Integer.parseInt(br.readLine());

            arr = new int[N][N];
            cnt = 1;

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(arr[i][j] == 0) {
                        dfs(i, j);
                    }
                }
            }
            System.out.printf("#%d\n",count);
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    System.out.print(arr[i][j]+" ");
                }
                System.out.println();
            }
            count++;
        }
    }
    static void dfs(int x, int y){
        int[] dx = {1,0,-1,0};  //우-하-좌-상
        int[] dy = {0,1,0,-1};
        arr[x][y] = cnt;
        cnt++;
        int nx = x;
        int ny= y;

        for(int i=0; i<4; i++){
            while(true){
                nx = nx+dx[i];
                ny = ny+dy[i];

                if(nx<0 || nx>=N || ny<0 || ny>=N){
                    break;
                }
                if(arr[ny][nx]!=0){
                    break;
                }
                arr[ny][nx] = cnt;
                cnt++;
            }
            // 범취초과해서 break 당한채로 저장됐기에, 이전값으로 돌려놓기.
            nx = nx - dx[i];
            ny = ny - dy[i];
        }
    }
}

