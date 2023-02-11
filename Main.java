import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class src{
    static int N,M;
    static int[][] board;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N+1][N+1];
        visit = new boolean[N+1];
        //관계맺기
        for(int i=1; i<=M; i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            board[a][b] = board[b][a] = 1;
        }

        //bfs돌리기

        for(int i=1; i<=N; i++){
            bfs(i);
        }
    }
    public static int bfs(int num){
        visit[num] = true;
        return 0;
    }
    static class Node{
        int number;
        int count;
        Node(int number, int count){

        }
    }
}