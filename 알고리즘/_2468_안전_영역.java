package 알고리즘;
//[백준]2469 : 안전 영역 - JAVA(자바)

//< 나의 알고리즘 >
// bfs로 풀면 될 것 같다. 근데 갯수를 어떻게 새야하지?

//< 답안 알고리즘 >

//< 새로 알게된 것 >
// Arrays.fill 은 1차원 배열에서만 가능

//< 궁금한 것 >

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2468_안전_영역 {
    static int N;
    static int[][] board;
    static boolean[][] visited;
    static Queue<Node> q;
    static int[] dx = {0,0,-1,1};
    static int[] dy= {-1,1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());    //행과 열의 개수를 나타내는 수 .  N은 2 이상 100 이하의 정수
        board =  new int[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<N; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

//        for(int i=0; i<N; i++){
//            for(int j=0; j<N; j++){
//                System.out.print(board[i][j]+" ");
//            }
//            System.out.println();
//        }

        //높이는 1이상 100 이하의 정수
        int height = 0;
        int result = Integer.MIN_VALUE;
        while(height <=100 ){

            //boolean 초기화
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    visited[i][j] = false;
                }
            }


            //침수된 곳 미리 true처리 (방문처리)
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(board[i][j] <= height){
                        visited[i][j] = true;
                    }
                }
            }

            //모두 침수되면 height 종료
            boolean alldrawn = true;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    //하나라도 false 만나면 alldrawn이 아님
                    if(visited[i][j] == false){
                        alldrawn = false;
                    }
                }
            }
            if(alldrawn){
                break;
            }

//            //visited 확인
//            System.out.println("height: "+ height);
//            for(int i=0; i<N; i++){
//                for(int j=0; j<N; j++){
//                    System.out.print(visited[i][j]+" ");
//                }
//            System.out.println();
//            }

            int count = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    //방문 안된 곳 : 침수 안된 곳
                    if(visited[i][j] == false){
                        bfs(i,j);
                        count++;
                    }
                }
            }
            height++;

            if(result < count){
                result = count;
            }
        }
        System.out.println(result);

    }
    static void bfs(int x, int y){
        q = new LinkedList<>();
        q.offer(new Node(x,y));
        visited[x][y] = true;

        while(!q.isEmpty()){
            Node node = q.poll();
            for(int i=0; i<4; i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                //범위 초과
                if(nx<0 || nx>=N || ny<0 || ny>=N){
                    continue;
                }

                // 이미 방문한 곳
                if(visited[nx][ny] == true){
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
        Node(int x, int y){
            this.x = x;
            this.y =y;
        }

    }
}
