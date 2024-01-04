package BOJ._3_Gold;

//소요시간 : 1시간 30분 (실패) -> 반례발견 및 완벽한 구현 실패
//소요시간 : 45분

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _4179_불 {
    static int R,C;
    static char[][] arr;
    static int[][] distF;
    static int[][] distJ;
    static Queue<Node> fire = new LinkedList<>(); 
    static Queue<Node> jh = new LinkedList<>();
    
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static boolean possible = false;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[R][C];
        distF = new int[R][C];
        distJ = new int[R][C];
        
        // 입력
        for(int i=0; i<R; i++){
            String str = br.readLine();
            for(int j=0; j<C; j++){
                arr[i][j] = str.charAt(j);
            }
        }

        //거리 초기화
        for(int i=0; i<R; i++){
            Arrays.fill(distF[i],-1);
            Arrays.fill(distJ[i],-1);
        }
        
        //초기 불의 위치정보 담기
        //초기 지훈이의 위치정보 담기
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(arr[i][j] == 'F'){
                    fire.offer(new Node(i,j));
                    distF[i][j] = 0;
                }
                if(arr[i][j] == 'J'){
                    jh.offer(new Node(i,j));
                    distJ[i][j] = 0;
                }
            }
        }
        bfs();

        if(!possible){
            System.out.println("IMPOSSIBLE");
        }
//        //출력
//        for(int i=0; i<R; i++){
//            for(int j=0; j<C; j++){
//                System.out.print(distF[i][j]+" ");
//            }
//            System.out.println();
//        }
//        System.out.println();
//        for(int i=0; i<R; i++){
//            for(int j=0; j<C; j++){
//                System.out.print(distJ[i][j]+" ");
//            }
//            System.out.println();
//        }
    }
    static void bfs(){
        //불 시간 측정
        while(!fire.isEmpty()){
            Node node = fire.poll();
            for(int i=0; i<4; i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                //불이 위치를 벗어남 ,
                if(nx<0 || nx>=R || ny<0 || ny>=C){
                    continue;
                }
                //불의 위치가 벽이나 이미 불
                if(arr[nx][ny] == '#' || arr[nx][ny] == 'F'){
                    continue;
                }
                //이미 방문한 곳
                if(distF[nx][ny] != -1){
                    continue;
                }
                //불이 번짐을 표현 (시간)
                fire.offer(new Node(nx, ny));
                distF[nx][ny] = distF[node.x][node.y] + 1;
            }
        }
        //지훈 탈출시간 측정
        while(!jh.isEmpty()) {
            Node jihoon = jh.poll();
            for(int i=0; i<4; i++) {
                int jhx = jihoon.x + dx[i];
                int jhy = jihoon.y + dy[i];

                //지훈이가 위치를 벗어남 == 탈출성공
                if (jhx < 0 || jhx >= R || jhy < 0 || jhy >= C) {
//                    System.out.println("성공");
                    possible = true;
                    System.out.println(distJ[jihoon.x][jihoon.y] + 1);
                    return;
                }
                //이동할 수 있는 곳이 아니거나 , 방문한 곳이면
                if(arr[jhx][jhy] !='.' || distJ[jhx][jhy] != -1){
                    continue;
                }
                //지훈이가 이동할 수 있는 곳
                if (arr[jhx][jhy] == '.') {
                    //방문하지 않은 곳 && 불이 아직 안온곳
                    // or ★ 불이 접근도 못하는 곳
                    if((distJ[jhx][jhy] == -1 && distF[jhx][jhy] > distJ[jihoon.x][jihoon.y]+1) || distF[jhx][jhy]== -1) {
                        jh.offer(new Node(jhx, jhy));
                        distJ[jhx][jhy] = distJ[jihoon.x][jihoon.y] + 1;
                    }
                }
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
