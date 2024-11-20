package 프로그래머스.Lv2;

//[241120] 소요시간 : 40분

import java.util.*;

public class 리코쳇_로봇 {

    static int N,M;
    static int[][] dist;
    static char[][] boards;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    public int solution(String[] board) {
        int answer = 0;

        N = board.length;
        M = board[0].length();
        dist = new int[N][M];
        boards = new char[N][M];


        // 2차원 배열로 재생성
        for(int i=0; i<N; i++){
            String str = board[i];
            // System.out.println(str);
            for(int j=0; j<M; j++){
                boards[i][j] = str.charAt(j);
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(boards[i][j] == 'R'){
                    answer = bfs(i,j);
                }
            }
        }
        return answer;
    }
    public int bfs(int x, int y){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x,y));

        while(!q.isEmpty()){
            Node node = q.poll();
            for(int i=0; i<4; i++){

                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                //범위 밖으로 나가거나 , 벽에 부딪히면 종료
                while(true){
                    if(nx<0 || nx>=N || ny<0 || ny>=M){
                        nx -= dx[i];
                        ny -= dy[i];
                        break;
                    }
                    if(boards[nx][ny] == 'D'){
                        nx -= dx[i];
                        ny -= dy[i];
                        break;
                    }
                    nx += dx[i];
                    ny += dy[i];
                }

                // System.out.println(nx+" "+ny);
                // continue;

                // dist 지점이 0이 아닌데, 현재 도착한 횟수가 더 크면 패스
                if(dist[nx][ny] != 0 && dist[nx][ny] <= dist[node.x][node.y] + 1){
                    continue;
                }
                if(boards[nx][ny] == 'R'){
                    continue;
                }
                if(boards[nx][ny] == 'G' ){
                    return dist[node.x][node.y] + 1;
                }

                dist[nx][ny] = dist[node.x][node.y] + 1;
                q.offer(new Node(nx,ny));
            }
        }
        return -1;
    }
    class Node{
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
