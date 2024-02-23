package 프로그래머스.Lv2;

//소요시간 : 14분

import java.util.Queue;
import java.util.LinkedList;

class 게임_맵_최단거리 {
    static int N,M;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int[][] dist;

    public int solution(int[][] maps) {
        int answer = 0;
        N = maps.length;
        M = maps[0].length;
        dist= new int[N][M];

        bfs(0,0,maps);

        if(dist[N-1][M-1] == 0){
            answer = -1;
        }
        else{
            answer = dist[N-1][M-1];
        }

        return answer;
    }
    public void bfs(int x, int y,int[][] maps){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x,y));
        dist[x][y] = 1;

        while(!q.isEmpty()){
            Node node = q.poll();
            for(int i=0; i<4; i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx<0 || nx>=N || ny<0 || ny>=M){
                    continue;
                }
                if(maps[nx][ny] == 0 || dist[nx][ny] != 0){
                    continue;
                }
                q.offer(new Node(nx,ny));
                dist[nx][ny] = dist[node.x][node.y] +1 ;
                if(nx==N-1 && ny==M-1){
                    return;
                }
            }
        }
    }
    class Node{
        int x;
        int y;
        Node(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
}