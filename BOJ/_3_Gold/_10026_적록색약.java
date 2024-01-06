package BOJ._3_Gold;

//소요시간 : 40분

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class _10026_적록색약 {
    static int N;
    static char[][] arr;
    static boolean[][] visited;
    static boolean[][] visited2;

    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        visited = new boolean[N][N];
        visited2 = new boolean[N][N];

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<N; j++){
                arr[i][j] = str.charAt(j);
            }
        }

        int count1 = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j]){
                    bfs(i,j);
                    count1++;
                }
            }
        }
        int count2 = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited2[i][j]){
                    bfs2(i,j);
                    count2++;
                }
            }
        }
        System.out.println(count1+" "+count2);
    }

    //적록색약 아님
    static void bfs(int x, int y){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x,y,arr[x][y]));
        visited[x][y] = true;

        while(!q.isEmpty()){
            Node node = q.poll();
            for(int i=0; i<4; i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx<0 || nx>=N || ny<0 || ny>=N){
                    continue;
                }
                if(visited[nx][ny] || arr[nx][ny] != node.color){
                    continue;
                }
                q.offer(new Node(nx,ny,arr[nx][ny]));
                visited[nx][ny] = true;
            }
        }
    }
    // 적록색약 ( R == G 라고 판단)
    static void bfs2(int x,int y){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x,y,arr[x][y]));
        visited2[x][y] = true;

        while(!q.isEmpty()){
            Node node = q.poll();
            for(int i=0; i<4; i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx<0 || nx>=N || ny<0 || ny>=N){
                    continue;
                }
                if(visited2[nx][ny] ){
                    continue;

                }
                //색깔이 다르면 continue 해야하지만,
                if(arr[nx][ny] != node.color){
                    //적록색약의 예외 허용
                    if((node.color == 'R' && arr[nx][ny]=='G') || (node.color == 'G' && arr[nx][ny]=='R')){
                        q.offer(new Node(nx,ny,arr[nx][ny]));
                        visited2[nx][ny] = true;
                    }
                    else {
                        continue;
                    }
                }
                q.offer(new Node(nx,ny,arr[nx][ny]));
                visited2[nx][ny] = true;
            }
        }
    }

    static class Node{
        int x;
        int y;
        char color;
        public Node(int x, int y,char color) {
            this.x = x;
            this.y = y;
            this.color = color;
        }
    }
}
