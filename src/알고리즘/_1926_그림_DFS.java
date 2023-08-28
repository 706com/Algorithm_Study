package 알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class _1926_그림_DFS {
    static int N,M;
    static int[][] board;
    static boolean[][] visit;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int Rdfsarea = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());   //세로
        M = Integer.parseInt(st.nextToken());   //가로
        board = new int[N][M];
        visit = new boolean[N][M];

        //입력
        for(int i=0; i<N; i++){
            st= new StringTokenizer(br.readLine()," ");
            for(int j=0; j<M; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //DFS
        int count = 0;
        int max = Integer.MIN_VALUE;

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(board[i][j] == 0 || visit[i][j] == true){
                    continue;
                }
                Rdfs(i,j);
                count++;

                if(max<Rdfsarea){
                    max = Rdfsarea;
                }
                Rdfsarea = 0;
            }
        }
        System.out.println(count);
        System.out.println(max);

    }
    public static int dfs(int x, int y){
        visit[x][y] = true;
        Stack<Node> stack = new Stack<>();
        stack.push(new Node(x,y));
        int area = 0;

        while(!stack.isEmpty()) {
            area++;
            Node node = stack.pop();
            for (int i=0; i<4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M){
                    continue;
                }
                if(board[nx][ny] == 0 || visit[nx][ny] == true){
                    continue;
                }

                visit[nx][ny] = true;
                stack.push(new Node(nx,ny));

            }
        }
        return area;
    }
    public static void Rdfs(int x, int y){
        visit[x][y] = true;
        Rdfsarea++;

        for (int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >= N || ny < 0 || ny >= M){
                continue;
            }
            if(board[nx][ny] == 0 || visit[nx][ny] == true){
                continue;
            }
            Rdfs(nx,ny);
        }
    }
    static class Node{
        int x;
        int y;
        public Node(int x,int y){
            super();
            this.x = x;
            this.y = y;
        }
    }
}
