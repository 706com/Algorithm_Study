package BOJ._2_Silver;

// < 알고리즘 유형 >
// dfs-bfs

// < 풀이 접근 >
// *. 쉽게 생각해서, 그래프(노드-간선) 으로 나타내서 , 두 사람이 간선 몇개로 이루어져 있는지를 출력하면 될 것
// 1. bfs 를 돌 때 마다 카운트를 세준다.
// 2. dist 를 구현하여 노드에 도착할 때 마다의 거리를 구해준다.
// 3. 해당 노드에 도착 할 시의 dist 를 출력한다.
// 4. 만일 아무 관계가 없을 시에는 -1 을 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2644_촌수계산 {

    static int N;
    static int first;
    static int second;
    static int line;

    static int[][] arr;
    static boolean[] visited;
    static int[] dist;

    static boolean check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        first = Integer.parseInt(st.nextToken());
        second = Integer.parseInt(st.nextToken());

        line = Integer.parseInt(br.readLine());

        arr = new int[N+1][N+1];
        visited = new boolean[N+1];
        dist = new int[N+1];

        // 노드 - 간선 잇기
        for(int i=0; i<line; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = arr[b][a] = 1;
        }

//        //확인
//        for(int i=1; i<=N; i++){
//            for(int j=1; j<=N; j++){
//                System.out.print(arr[i][j]+" ");
//            }
//            System.out.println();
//        }

        bfs(first);

        // dfs 돌면서 만나지 못했다면, -1 출력
        if(!check){
            System.out.println("-1");
        }
    }

    static void bfs(int x) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        visited[x] = true;

        while (!q.isEmpty()) {
            int num = q.poll();
            // x(first 로 부터 시작) 가 second를 만났을 때 break;
            if (num == second) {
                System.out.println(dist[num]);
                check = true;
                return;
            }

            for (int i = 1; i <= N; i++) {
                if (!visited[i] && arr[num][i] == 1) {
                    visited[i] = true;
                    q.offer(i);
                    dist[i] = dist[num]+1;
                }
            }
        }
    }
}
