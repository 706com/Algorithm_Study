package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class _11315_오목_판정 {

    static int N;
    static char[][] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int count = 1;

        while(count<=T){
            boolean result  = false;
            String message ="";
            N = Integer.parseInt(br.readLine());
            arr = new char[N][N];

            //입력
            for(int i=0; i<N; i++){
                String str = br.readLine();
                for(int j=0; j<N; j++){
                    char c = str.charAt(j);
                    arr[i][j] = c;
                }
            }

            // 검증
//            for(int i=0; i<N; i++){
//                for(int j=0; j<N; j++){
//                    System.out.print(arr[i][j]+" ");
//                }
//                System.out.println();
//            }

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(arr[i][j] == 'o') {
                        result = check(i, j);
                    }
                    if(result){
                        message = "YES";
                        break;
                    }
                }
                if(result){
                    message = "YES";
                    break;
                }
            }
            if(!result){
                message = "NO";
            }

            System.out.printf("#%d %s",count ,message);
            System.out.println();
            count++;
        }
    }

    public static boolean check(int x,int y){

        //상 하 좌 우 좌상 우상 좌하 우하
        int[] dx = {0,0,-1,1,-1,1,-1,1};
        int[] dy = {-1,1,0,0,-1,-1,1,1};

        for(int i=0; i<8; i++){
            int count = 1;
            int nx = x;
            int ny = y;

            while(true) {
                nx = nx + dx[i];
                ny = ny + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N || arr[nx][ny] != 'o') {
                    break;
                }
                if (arr[nx][ny] == 'o') {
                    count++;
                }
            }
            if(count>=5){
                return true;
            }
        }
        return false;
    }
}
