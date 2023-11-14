package BOJ._2_Silver;
//[백준]1406 : 에디터 - JAVA(자바)

//< 나의 알고리즘 >
// 잘 떠오르지 않는다.

//< 답안 알고리즘 >
// 1차원 bfs 문제이다. (최단경로 문제)
// 범위를 유의해야만 한다.

//< 새로 알게된 것 >

//< 궁금한 것 >


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1697_숨바꼭질 {
    static int N,K;
    static int[] board;
    static int[] dist;
    static int[] dx = {-1,1,2};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());   // 수빈이 위치
        K = Integer.parseInt(st.nextToken());   // 동생 위치

        board = new int[200000];    //서로간의 사이가 100000이라고 했지 범위는 200000까지 갈 수가 있음.
        dist = new int[200000];

        bfs(N);

//        for(int i=0; i<100; i++){
//            System.out.print(dist[i]+" ");
//        }
        System.out.println(dist[K]-1);
    }
    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        dist[start] += 1;

        while(!q.isEmpty()){
            int x = q.poll();

            for(int i=0; i<3; i++){
                int nx = 0;

                // 0,1 번지는 좌우 한칸
                if(i==0 || i==1){
                    nx = x + dx[i];
                }
                // 2번지는 *2 (순간이동)
                else {
                    nx = x * dx[i];
                }

                //범위를 초과하면
                if(nx<0 || nx>=200000)
                    continue;

                // 이미 방문한 곳이면
                if(dist[nx] != 0)
                    continue;

                q.offer(nx);
                dist[nx] = dist[x] +1;

                if(nx == K){
                    return;
                }
            }
        }
    }
}
