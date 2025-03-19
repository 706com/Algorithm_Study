package 프로그래머스.Lv2;

//[241127] : 실패(시간초과)
//[250319] : 20분

//1) 레버 찾는 과정
//2) 목적지 찾는 과정

import java.util.*;

public class 미로_탈출 {

    static int N,M;
    static char[][] arr;
    static int[][] dist;

    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    static boolean isLeverOn = false;

    public int solution(String[] maps) {
        int answer = 0;

        N = maps.length;
        M = maps[0].length();

        arr = new char[N][M];
        dist = new int[N][M];

        int startX =0, startY =0, leverX =0, leverY=0, endX=0, endY=0;
        int distLever =0, distEnd =0;

        for(int i=0; i<N; i++){
            String str = maps[i];
            for(int j=0; j<M; j++){
                arr[i][j] = str.charAt(j);
                if (arr[i][j] == 'S') {
                    startX = i;
                    startY = j;
                } else if (arr[i][j] == 'L') {
                    leverX = i;
                    leverY = j;
                } else if (arr[i][j] == 'E') {
                    endX = i;
                    endY = j;
                }
            }
        }

        // System.out.println(Arrays.deepToString(arr));

        distLever = findTarget(startX,startY, 'L');
        // System.out.println(distLever);
        if(!isLeverOn){
            return -1;
        }

        dist = new int[N][M];
        distEnd = findTarget(leverX,leverY, 'E');

        // System.out.println(distEnd);
        if(distLever == -1 || distEnd == -1){
            return -1;
        }
        return distLever + distEnd;
    }
    public int findTarget(int x, int y, char target){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x,y));
        dist[x][y] = 1;

        while(!q.isEmpty()){
            Node node = q.poll();

            for(int i=0; i<4; i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                // 범위 아웃
                if(nx<0 || ny <0 || nx>=N || ny>=M){
                    continue;
                }
                // 목적지 도달시 종료
                if(arr[nx][ny] == target){
                    isLeverOn = true;
                    return dist[node.x][node.y];
                }
                //벽
                if(arr[nx][ny] == 'X'){
                    continue;
                }
                // 더 빠른 경로가 이미 있으면
                if(dist[nx][ny] != 0 && dist[nx][ny] <= dist[node.x][node.y]+1){
                    continue;
                }
                q.offer(new Node(nx,ny));
                dist[nx][ny] = dist[node.x][node.y] +1;
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


