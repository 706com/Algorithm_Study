package BOJ._3_Gold;

//소요시간 : 24분

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _6593_상범_빌딩 {

    static int L,N,M;
    static boolean possible;
    static Queue<Node> q;
    static Node end;

    static char[][][] arr;
    static int[][][] dist;
    static int[] dx = {0,0,-1,1,0,0};   //동서
    static int[] dy = {-1,1,0,0,0,0};   //남북
    static int[] dz = {0,0,0,0,-1,1};   //상하

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());   // == R
            M = Integer.parseInt(st.nextToken());   // == C
            q = new LinkedList<>(); // 📌 큐 비워주는거 명심
            possible = false;

            // 입력의 끝은 L, R, C가 모두 0으로 표현된다
            if(L==0 && N==0 && M==0){
                return;
            }

            arr = new char[L][N][M];
            dist = new int[L][N][M];

            //입력
            for(int i=0; i<L; i++){
                for(int j=0; j<N; j++){
                    String str = br.readLine();
                    for(int k=0; k<M; k++){
                        arr[i][j][k] = str.charAt(k);
                        // 시작지점 담기
                        if(arr[i][j][k] == 'S'){
                            q.offer(new Node(i,j,k));
                            dist[i][j][k] = 1;
                        }
                        // 도착지점 담기
                        if(arr[i][j][k] == 'E'){
                            end = new Node(i,j,k);
                        }
                    }
                }
                br.readLine();
            }

            bfs();
            if(!possible){
                System.out.println("Trapped!");
            }
//            // 입력 잘 됐는지 출력 확인
//            for(int i=0; i<L; i++){
//                for(int j=0; j<N; j++){
//                    for(int k=0; k<M; k++){
//                        System.out.print(arr[i][j][k]+" ");
//                    }
//                    System.out.println();
//                }
//                System.out.println();
//            }
        }
    }
    static void bfs(){
        while(!q.isEmpty()){
            Node node = q.poll();
            for(int i=0; i<6; i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                int nz = node.z + dz[i];

                if(nx == end.x && ny == end.y && nz == end.z){
                    possible = true;
                    System.out.println("Escaped in "+ dist[node.x][node.y][node.z] +" minute(s).");
                    return;
                }
                if(nx<0 || nx>=L || ny<0 || ny>=N || nz<0 || nz>=M){
                    continue;
                }
                if(arr[nx][ny][nz] != '.' || dist[nx][ny][nz] != 0){
                    continue;
                }
                q.offer(new Node(nx,ny,nz));
                dist[nx][ny][nz] = dist[node.x][node.y][node.z] +1 ;
            }
        }
    }

    static class Node{
        int x;
        int y;
        int z;
        public Node(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
