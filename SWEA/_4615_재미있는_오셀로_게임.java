package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

// <문제유형>
// dfs?

// < 풀이 접근 >
// *. 상 하 좌 우 좌상 우상 좌하 우하 로 좌표를 설정해놓고 0 또는 자신의 컬러의 돌을 만날때까지 나아간다.
// 1. 초기 바둑판을 설정한다.
// 2. 흑 일때, 백일 때 각각 나눠서 함수를 구현한다. ( 매커니즘은 같음)
// 3. 함수구현
// ->

public class _4615_재미있는_오셀로_게임 {

    static int[][] arr;
    static int N,M;
    static int[] dx = {0,0,-1,1,-1,1,-1,1};
    static int[] dy = {-1,1,0,0,-1,-1,1,1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int count = 1;

        while(count<=T){
            int blackCnt = 0;
            int whiteCnt= 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            arr = new int[N+1][N+1];

            arr[N/2][N/2] = arr[N/2+1][N/2+1] = 2;  // 초기 백(2)
            arr[N/2][N/2+1] = arr[N/2+1][N/2] = 1;  // 초기 흑(1)

            // 검증
//            for(int i=1; i<=N; i++){
//                for(int j=1; j<=N; j++){
//                    System.out.print(arr[i][j]+" ");
//                }
//                System.out.println();
//            }

            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int color = Integer.parseInt(st.nextToken());

                // 흑 차례
                if(color == 1){
                   black(x,y);
                }
                // 백 차례
                else if(color == 2){
                    white(x,y);
                }
                // 돌을 둘 때마다 검증
//                for(int o=1; o<=N; o++){
//                    for(int j=1; j<=N; j++){
//                        System.out.print(arr[o][j]+" ");
//                    }
//                    System.out.println();
//                }
//                System.out.println();
            }

            //최종 흑돌 백돌 갯수 세기
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    if(arr[i][j] == 1){
                        blackCnt++;
                    }
                    else if(arr[i][j] == 2){
                        whiteCnt++;
                    }
                }
            }
            System.out.printf("#%d %d %d",count,blackCnt,whiteCnt);
            System.out.println();
            count++;

        }
    }
    public static void black(int x, int y){
        Queue<Node> q = new LinkedList<>();
        //해당자리 검은돌 놓기
        arr[x][y] = 1;

        //상 하 좌 우 좌상 우상 좌하 우하
//        static int[] dx = {0,0,-1,1,-1,1,-1,1};
//        static int[] dy = {-1,1,0,0,-1,-1,1,1};

        for(int i=0; i<8; i++){
            boolean meetBlack = false;
            int nx = x;
            int ny = y;
            while(true){
                nx = nx + dx[i];
                ny = ny + dy[i];

                //범위초과 , 빈공간(0) 만남
                if(nx<=0 || ny<=0 || nx>N || ny>N || arr[nx][ny] == 0){
                    break;
                }
                //흑돌(같은컬러) 만남
                if(arr[nx][ny] == 1){
                    meetBlack = true;
                    break;
                }
                //백돌(다른컬러) 만날때마다 해당 좌표 저장
                else{
                    q.offer(new Node(nx,ny));
                }
            }
            // 반복문이 끝나고 블랙을 만났으면 w자리 다 블랙으로 변경
            while(!q.isEmpty()) {
                // 흑돌을 만났으면 해당자리 변경하면서 제거
                if (meetBlack) {
                    Node node = q.poll();
                    arr[node.x][node.y] = 1;
                }
                // 흑돌 안만났으면 없었던 일
                else{
                    q.poll();
                }
            }
        }
    }

    public static void white(int x, int y){
        Queue<Node> q = new LinkedList<>();
        //해당자리 백돌 놓기
        arr[x][y] = 2;

        //상 하 좌 우 좌상 우상 좌하 우하
//        static int[] dx = {0,0,-1,1,-1,1,-1,1};
//        static int[] dy = {-1,1,0,0,-1,-1,1,1};

        for(int i=0; i<8; i++){
            int nx = x;
            int ny = y;
            boolean meetWhite = false;
            while(true){
                nx = nx + dx[i];
                ny = ny + dy[i];

                //범위초과
                if(nx<=0 || ny<=0 || nx>N || ny>N || arr[nx][ny] == 0){
                    break;
                }
                //백돌(같은컬러) 만남
                if(arr[nx][ny] == 2){
                    meetWhite = true;
                    break;
                }
                //흑돌 만날때마다 해당 좌표 저장
                else{
                    q.offer(new Node(nx,ny));
                }
            }

            // 반복문이 끝나고 백돌을 만났으면 지나친 자리 다 백돌로 변경
            while(!q.isEmpty()) {
                //만났으면 해당자리 변경하면서 제거
                if (meetWhite) {
                    Node node = q.poll();
                    arr[node.x][node.y] = 2;
                }
                // 백돌 안만났으면 없었던 일
                else{
                    q.poll();
                }
            }
        }
    }

    public static class Node{
        int x;
        int y;
        Node(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
}
