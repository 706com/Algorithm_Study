package BOJ._3_Gold;

//소요시간 : 45분

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2573_빙산 {

    static int N,M;
    static int[][] arr;
    static boolean[][] visited;
    static int[][] temp;

    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];


        int count = 0;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int year = 0;
        while(true) {
            count = 0;
            temp = new int[N][M];
            visited = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j] != 0 && !visited[i][j]) {
                        bfs(i, j);
                        count++;
                    }
                }
            }
//            System.out.println("count : " + count);
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    arr[i][j] = arr[i][j] + temp[i][j];
                    if(arr[i][j] < 0){
                        arr[i][j] = 0;
                    }
                }
            }
            // 빙산 덩어리가 1개 이하면 내년
            if(count<=1){
                year++;
            }
            
            //덩어리가 쪼개지는 순간의 년수 출력
            if(count>=2){
                System.out.println(year);
                return;
            }
            // 빙산이 모두 녹았는지 확인 (모두가 0)
            boolean check = false;
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(arr[i][j] > 0){
                        check = true;
                        break;
                    }
                }
                if(check){
                    break;
                }
            }
            // 빙산이 모두 녹았으면 0 출력 (덩어리가 1개에서 안쪼개짐)
            if(!check){
                System.out.println("0");
                return;
            }
        }
    }
    static void bfs(int x, int y){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x,y));
        visited[x][y] = true;

        while(!q.isEmpty()){
            Node node = q.poll();
            for(int i=0; i<4; i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx<0 || nx>=N || ny<0 || ny>= M){
                    continue;
                }
                if(visited[nx][ny]){
                    continue;
                }
                // 인근이 0(물)이면 temp에 몇개 맞닿아있는지 저장
                if(arr[nx][ny]<=0){
                    temp[node.x][node.y]--;
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
