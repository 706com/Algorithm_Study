package BOJ._2_Silver;

//소요시간 : 15분

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _5014_스타트링크 {
    static int F,S,G;
    static int[] arr;
    static int[] dist;
    static int[] dx;
    static boolean possible = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());   // 총 길이
        S = Integer.parseInt(st.nextToken());   // 강호
        G = Integer.parseInt(st.nextToken());   // 목표
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        dx = new int[]{U,-D};
        arr = new int[F+1];
        dist = new int[F+1];

        //위치 같을 때 예외처리
        if(S==G){
            System.out.println("0");
            return;
        }
        bfs(S);
        if(!possible){
            System.out.println("use the stairs");
        }
    }
    static void bfs(int x){
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        dist[x] = 1;

        while(!q.isEmpty()){
            int a = q.poll();
            for(int i=0; i<2; i++){
                int nx = a + dx[i];

                if(nx == G){
                    System.out.println(dist[a]);
                    possible = true;
                    return;
                }
                if(nx<=0 || nx>F){
                    continue;
                }
                if(dist[nx] != 0){
                    continue;
                }
                q.offer(nx);
                dist[nx] = dist[a] + 1;
            }
        }
    }
}
