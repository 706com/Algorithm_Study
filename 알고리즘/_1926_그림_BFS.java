package 알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1926_그림_BFS {
    static int n,m;
    static int[][] board;
    static boolean[][] visit;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static Queue<Node> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());   //세로
        m = Integer.parseInt(st.nextToken());   //가로
        board = new int[n][m];
        visit = new boolean[n][m];

        //입력받기
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<m; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
//        //출력테스트
//        for(int i=0; i<n; i++){
//            for(int j=0; j<m; j++){
//                System.out.print(board[i][j]+" ");
//            }
//            System.out.println();
//        }

        //bfs 돌리기
        int count= 0;
        int maxArea = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                //색칠이 안되어있거나 (0) 방문기록이 있으면 (true) 넘기기
                if(board[i][j] == 0 || visit[i][j] == true){
                    continue;
                }
                int nowArea = bfs(i,j);
                count++;
                if(maxArea < nowArea){
                    maxArea = nowArea;
                }
            }
        }
        if(count == 0){
            System.out.println(count+"\n"+"0");
            return;
        }
        System.out.print(count+"\n"+maxArea);

    }
    public static int bfs(int x, int y){
        q = new LinkedList<>();
        q.offer(new Node(x,y));
        visit[x][y] = true;
        int area = 0;

        while(!q.isEmpty()){
            area++;
            Node node = q.poll();
            for(int i=0; i<4; i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m)  //board범위 초과
                    continue;
                if(board[nx][ny] == 0 || visit[nx][ny] == true) //방문기록, 색칠안되어있음
                    continue;

                visit[nx][ny] = true;
                q.offer(new Node(nx,ny));
            }
        }
        return area;
    }
}
class Node{
    int x;
    int y;
    public Node(int x,int y){
        super();
        this.x= x;
        this.y =y;
    }
}