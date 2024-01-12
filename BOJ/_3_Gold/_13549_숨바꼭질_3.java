package BOJ._3_Gold;

//소요시간 : 1시간 (실패 - 우선순위 및 조건 잘못짬)
//소요시간 : 15분 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _13549_숨바꼭질_3 {
    static int N,K;
    static int[] arr;
    static int[] dist;
    static int[] dx = {2,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr= new int[200001];
        dist = new int[200001];

        if(N==K){
            System.out.println("0");
            return;
        }
        bfs(N);
        
    }
    static void bfs(int n){
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        dist[n] = 1;

        while(!q.isEmpty()){
            int x = q.poll();
            for(int i=0; i<3; i++){
                int nx = x + dx[i];

                if(i==0){
                    nx = x * dx[i];
                }

                if(nx == K){
                    // 순간이동으로 도착시 ( -1 의 이유는 맨 처음 초깃값을 1로 해줬기 때문)
                    if(i==0){
                        System.out.println(dist[x]-1);
                    }
                    // 걸어서 도착시 
                    else {
                        System.out.println(dist[x]);
                    }
                    return;
                }

                if(nx<0 || nx>=arr.length){
                    continue;
                }

                if(dist[nx] != 0){
                    continue;
                }

                q.offer(nx);
                // 순간이동 도착이면 시간변화 없이 그대로
                if(i==0) {
                    dist[nx] = dist[x];
                }
                // 걸어서 도착하면 +1 초
                else{
                    dist[nx] = dist[x] +1;
                }
            }
        }
    }
}
