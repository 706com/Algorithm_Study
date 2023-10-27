package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 반례 : vistied 해제 안했을때.
1
6 6
1 3
1 2
2 5
5 4
4 6
2 4
* */
public class _2814_최장_경로 {

    static int result;
    static int N,M;
    static int[][] arr;
    static boolean[] visited;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T= Integer.parseInt(br.readLine());
        int count = 1;

        while(count<=T) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            max = 0;
            arr = new int[N+1][N+1];
            visited = new boolean[N+1];

            for(int i=0; i<M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr[a][b] = arr[b][a] = 1;
            }


            for(int i=1; i<=N; i++) {
                dfs(1,i);
                visited = new boolean[N+1];

            }
            System.out.printf("#%d %d\n",count,max);
            count++;
        }
    }

    static void dfs(int cnt,int start) {

        visited[start] = true;

        for(int i=1; i<=N; i++) {
            if(arr[start][i] == 1 && !visited[i]) {
                dfs(cnt+1,i);
                visited[i] = false;
            }
        }
        max = Math.max(cnt,max);
    }
}
