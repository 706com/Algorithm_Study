package 프로그래머스.Lv3;

//[250122] 🔍

// 골목길 같은곳에 들어가면, 들어갔다 나오지 않고, 바로 일직선 직진하는 경우 발생
// 배열 늘리기
//  빈도화지 0 테두리 1 안쪽 2

import java.util.*;

public class 아이템_줍기 {
    static int[][] arr;
    static int[][] dist;

    static int startX;
    static int startY;
    static int endX;
    static int endY;

    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        arr  = new int[101][101];
        dist = new int[101][101];
        startX = characterX*2;
        startY = characterY*2;
        endX = itemX*2;
        endY = itemY*2;

        // 배열 2배 늘리기
        for(int i=0; i<rectangle.length; i++){
            int x1 = rectangle[i][0] *2;
            int x2 = rectangle[i][2] *2;
            int y1 = rectangle[i][1] *2;
            int y2 = rectangle[i][3] *2;

            for(int x = x1; x<=x2; x++){
                for(int y = y1; y<= y2; y++){
                    //테두리 처리
                    if(x == x1 || x== x2 || y==y1 || y==y2){
                        // 사각형 내부는 테두리 처리 X
                        if(arr[x][y]==2){
                            continue;
                        }
                        arr[x][y] = 1;
                    }else{
                        //내부 처리
                        arr[x][y] = 2;
                    }
                }
            }
        }

        // for(int i=0; i<arr.length; i++){
        //     for(int j=0; j<arr[0].length; j++){
        //         System.out.print(arr[i][j]+" ");
        //     }
        //     System.out.println();
        // }

        bfs();

        return dist[endX][endY] /2;
    }
    public void bfs(){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(startX,startY));
        dist[endX][endY] = Integer.MAX_VALUE;

        while(!q.isEmpty()){
            Node node = q.poll();

            for(int i=0; i<4; i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx == endX && ny == endY){
                    dist[nx][ny] = Math.min(dist[nx][ny],dist[node.x][node.y]+1);
                    break;
                }
                if(nx<=0 || ny<=0 || nx>100 || ny>100){
                    continue;
                }
                if(arr[nx][ny] != 1){
                    continue;
                }
                if(dist[nx][ny] != 0){
                    continue;
                }

                q.offer(new Node(nx,ny));
                dist[nx][ny] = dist[node.x][node.y] + 1;
            }
        }
    }
    public class Node{
        int x;
        int y;
        Node(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
}
