package BOJ;

//소요시간 : 1시간(실패)

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
    static int[] dx = {-1,1,-2,2};
    static Queue<Integer> q = new LinkedList<>();
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

        int x = N;
        int y = N;
        q.offer(N);
        while(true){
            if(N==0){
                break;
            }
            x = x * 2;
            y = y * (-2);

            if(y<0 || x>=arr.length){
                break;
            }

            dist[x] = 1;
            dist[y] = 1;
            q.offer(x);
            q.offer(y);
        }
        bfs(N);
        System.out.println(dist[K]);
    }
    static void bfs(int n){
//        Queue<Integer> q = new LinkedList<>();
//        q.offer(n);
        dist[n] = 1;

        while(!q.isEmpty()){
            int x = q.poll();
            for(int i=0; i<4; i++){
                int nx = x + dx[i];

                if(i==2){
                    nx = x * dx[i];
                }
                else if(i==3){
                    nx = x * dx[i];
                }

                if(nx == K){
                    if(dist[nx] == 0){
                        if (i == 2 || i == 3){
                            dist[nx] = dist[x] -1;
                        }
                        else{
                            dist[nx] = dist[x];
                        }
                    }

                    else {
                        if(dist[nx]> dist[x]){
                            if (i == 2 || i == 3){
                                dist[nx] = dist[x] -1;
                            }
                            else{
                                dist[nx] = dist[x];
                            }
                        }
                    }
                }

                if(nx<0 || nx>=arr.length){
                    continue;
                }

                if(dist[nx] != 0){
                    continue;
                }
                q.offer(nx);
                dist[nx] = dist[x] + 1;

                if(i== 2 || i==3){
                    dist[nx] = dist[x];
                }
            }
        }
    }
}
