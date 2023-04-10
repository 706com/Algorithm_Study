import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class src {
    static int[] map = new int [101];
    static boolean[] visit = new boolean[101];
    static int[] cnt = new int[101];
    public static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visit[1] = true;
        while (!queue.isEmpty()){
            int x = queue.poll();
            if(x == 100){
                System.out.println(cnt[x]);
                break;
            }
            for(int i =1; i<=6; i++) {
                int X = x + i;
                if (X > 100 || visit[X]) continue;
                if (map[X] != 0 && !visit[map[X]]) {
                    visit[map[X]] = true;
                    queue.add(map[X]);
                    cnt[map[X]] = cnt[x] + 1;
                } else if(map[X] == 0){
                    visit[X] = true;
                    queue.add(X);
                    cnt[X] = cnt[x] + 1;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x]=y;
        }

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            map[u]=v;
        }
        Arrays.fill(cnt, 0);
        bfs();
    }
}