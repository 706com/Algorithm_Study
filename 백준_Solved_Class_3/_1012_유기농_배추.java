package 백준_Solved_Class_3;
//[백준]1012 : 유기농 배추 - JAVA(자바)

//<새로 알게된 것>
// DFS(Depth First Search):깊이우선탐색 , BFS(Breadth First Search):너비우선탐색 문제
// 좌표탐색 dx[] dy[] 활용하기

//<궁금한 것>
//

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1012_유기농_배추 {
    static int M;   //가로
    static int N;   //세로
    static int[][] ground = new int[M][N];             //땅덩어리
    static boolean[][] check = new boolean[M][N];      //탐색한 땅덩어리인지 체크 (default == false)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while(T-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            M = Integer.parseInt(st.nextToken());   //가로
            N = Integer.parseInt(st.nextToken());   //세로
            int K = Integer.parseInt(st.nextToken());   //심을 배추 갯수
            ground = new int[M][N];         //땅덩어리 초기화
            check = new boolean[M][N];      //탐색한 땅덩어리인지 체크 초기화 (default == false)

            //배추 심기(입력)
            for(int i=0; i<K; i++){
                st = new StringTokenizer(br.readLine()," ");
                ground[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
            }

            //본격적인 배추탐색 및 지렁이 갯수 세기
            int count = 0;

            for(int i=0; i<M; i++){
                for(int j=0; j<N; j++){
                    //배추가 심어져있고 (1) , 탐색하지 않은 땅 (false)
                    if(ground[i][j] == 1 && check[i][j] == false){
                        dfs(i,j);
                        count++;
                    }
                }
            }
//            //배열 확인 출력
//            for(int i=0; i<M; i++){
//                for(int j=0; j<N; j++){
//                    System.out.print(ground[i][j]+" ");
//                }
//                System.out.println();
//            }
//            System.out.println();
            sb.append(count).append('\n');
        }
        System.out.println(sb);
    }

    public static void dfs(int startX, int startY){
        check[startX][startY] = true;   //탐색한 곳은 true 처리

        int[] moveX = {0,0,-1,1};       //상하좌우 중, 좌 우
        int[] moveY = {-1,1,0,0};       //상하좌우 중, 상 하

        for(int i=0; i<4; i++){
            int x = startX + moveX[i];
            int y = startY + moveY[i];

            //예외처리(배열벗어남) : x,y 가 0 미만 일 때, x가 M 이상 , y가 N 이상 일 때.
            if(x<0 || x>=M || y<0 || y >= N){
                continue;
            }

            //재귀를 통해 모든 경우의 수 탐색
            if(ground[x][y] == 1 && check[x][y] == false){
                dfs(x,y);
            }
        }
    }
}
