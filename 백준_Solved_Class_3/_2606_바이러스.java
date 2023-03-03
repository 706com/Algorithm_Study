package 백준_Solved_Class_3;
//[백준]2606 : 바이러스 - JAVA(자바)

//< 나의 알고리즘 >
// bfs 혹은 dfs 문제. 노드-간선 문제처럼 풀면 될 것 같다.

//< 답안 알고리즘 >

//< 새로 알게된 것 >

//< 궁금한 것 >


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2606_바이러스 {
    static int N;
    static int line;
    static int[][] board;
    static boolean[] visited;
    static Queue<Integer> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        line = Integer.parseInt(br.readLine());

        board = new int[N+1][N+1];
        visited = new boolean[N+1];

        //노드 - 간선 연결
        for(int i=0; i<line; i++){
            StringTokenizer st= new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            board[a][b] = board[b][a] = 1;
        }

//        //board 출력
//        for(int i=1; i<=N; i++){
//            for(int j=1; j<=N; j++) {
//                System.out.print(board[i][j]+" ");
//            }
//            System.out.println();
//        }

        int result = bfs(1);    //1번 컴퓨터

//        System.out.println("<visited>");
//        for(int i=1; i<=N; i++){
//            System.out.print(visited[i]+" ");
//        }
//        System.out.println();


        System.out.println(result);
    }
    static int bfs(int first){

        q = new LinkedList();
        q.offer(first);
        visited[first] = true;

        int count = 0;
        while(!q.isEmpty()){
            int num = q.poll();
            for(int i=1; i<=N; i++){
                if(board[num][i] == 0 || visited[i] == true){
                    continue;
                }
                q.offer(i);
                visited[i] = true;
                count++;
            }
        }
        return count;
    }
}
