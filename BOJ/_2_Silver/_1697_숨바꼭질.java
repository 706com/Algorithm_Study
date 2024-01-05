package BOJ._2_Silver;

//소요시간 : 20분

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1697_숨바꼭질 {
    static int N,K;
    static int[] dx = {-1,1,2};
    static int[] arr;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[100001];      //범위를 200001으로 해야 할 수도 있음! (*2 의 범위까지)
        dist = new int[100001];

        //위치가 같을 때는 바로 예외처리
        if(N==K){
            System.out.println("0");
            return;
        }
        bfs(N);
    }

    static void bfs(int x){
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        dist[x] = 1;

        while(!q.isEmpty()){
            int a = q.poll();
            for(int i=0; i<3; i++){
                int nx = a + dx[i];
                if(i==2){
                    nx = a * dx[i];
                }

                //위치에 도달했을 경우
                if(nx==K){
                    dist[nx] = dist[a] + 1;
                    System.out.println(dist[nx]-1);
                    return;
                }

                if(nx<0 || nx>=100001){
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
