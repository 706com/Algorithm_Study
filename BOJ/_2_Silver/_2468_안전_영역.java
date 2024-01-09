package BOJ._2_Silver;

//소요시간 : 15분

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2468_안전_영역 {

    static int N;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N][N];

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j]<min){
                    min = arr[i][j];
                }
                if(arr[i][j]>max){
                    max = arr[i][j];
                }
            }
        }

        // 잠기기 시작하는 최소 강수량부터 최대 강수량 까지 구해서 결과 도출
        int result = 0;
        for(int i=min-1; i<=max; i++){
            visited = new boolean[N][N];
            int count = 0;
            for(int j=0; j<N; j++){
                for(int k=0; k<N; k++){
                    if(arr[j][k]>i && !visited[j][k]){
                        bfs(j,k,i);
                        count++;
                    }
                }
            }
            result = Math.max(result,count);
        }
        System.out.println(result);
    }
    static void bfs(int x,int y,int rain){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x,y));
        visited[x][y] = true;

        while(!q.isEmpty()){
            Node node = q.poll();
            for(int i=0; i<4; i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx<0 || nx>=N || ny<0 || ny>=N){
                    continue;
                }
                //해당위치가 잠긴곳 또는 방문한곳
                if(arr[nx][ny]<=rain || visited[nx][ny]){
                    continue;
                }
                q.offer(new Node(nx,ny));
                visited[nx][ny] = true;
            }
        }
    }
    static class Node{
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
