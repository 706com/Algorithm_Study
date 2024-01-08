package BOJ._3_Gold;

//소요시간 : 25분

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _5427_불 {
    static int M,N;
    static char[][] arr;
    static int[][] distSG, distF;
    static Queue<Node> sg;
    static Queue<Node> fire;
    static boolean possible;

    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            arr = new char[N][M];
            distSG = new int[N][M];
            distF = new int[N][M];
            possible = false;
            
            sg = new LinkedList<>();
            fire = new LinkedList<>();

            //입력 및 상근/불의 위치를 미리 q에 담아놓기
            for(int i=0; i<N; i++){
                String str = br.readLine();
                for(int j=0; j<M; j++){
                    arr[i][j] = str.charAt(j);
                    if(arr[i][j] == '@'){
                        sg.offer(new Node(i,j));
                        distSG[i][j] = 1;
                    }
                    if(arr[i][j] == '*'){
                        fire.offer(new Node(i,j));
                        distF[i][j] = 1;
                    }
                }
            }
            bfs();
            if(!possible){
                System.out.println("IMPOSSIBLE");
            }
        }
    }
    static void bfs(){
        //불 먼저 dist 구해놓기 (전파되는 시간 입력)
        while(!fire.isEmpty()){
            Node node = fire.poll();
            for(int i=0; i<4; i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx<0 || nx>=N || ny<0 || ny>=M){
                    continue;
                }
                //벽이거나 이미 불
                if(arr[nx][ny] == '#' || arr[nx][ny] =='*'){
                    continue;
                }
                //이미 방문
                if(distF[nx][ny] != 0){
                    continue;
                }
                fire.offer(new Node(nx,ny));
                distF[nx][ny] = distF[node.x][node.y] + 1;
            }
        }

        //상근이 이동 dist 구하기 (불보다 빨리 도착해야함 -> 동시 도착도 안됨)
        while(!sg.isEmpty()){
            Node node = sg.poll();
            for(int i=0; i<4; i++){
                int nx = node.x+ dx[i];
                int ny = node.y + dy[i];

                //탈출성공
                if(nx<0 || nx>=N || ny<0 || ny>=M){
                    possible = true;
                    System.out.println(distSG[node.x][node.y]);
                    return;
                }
                // . 이 아닌 공간은 이동 불가
                if(arr[nx][ny] != '.'){
                    continue;
                }
                // 이동하려는 곳에 이미 불이 도착해 있을경우 : dist가 클때 못감
                // 예외처리 : 불이 도착도 못하는 곳도 염두해야함
                if(distF[nx][ny] != 0 && (distSG[node.x][node.y] +1 >= distF[nx][ny])){
                    continue;
                }
                //이미 방문한 곳
                if(distSG[nx][ny] != 0){
                    continue;
                }
                sg.offer(new Node(nx,ny));
                distSG[nx][ny] = distSG[node.x][node.y] +1;
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
