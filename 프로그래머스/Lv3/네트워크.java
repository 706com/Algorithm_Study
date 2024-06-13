package 프로그래머스.Lv3;

//소요 시간 : 17분
//[240613] : 14분

import java.util.LinkedList;
import java.util.Queue;

class 네트워크 {
    /*
    * BFS 풀이
    * */
    static int N;
    static boolean[] visited;
    Queue<Integer> q = new LinkedList<>();

    public int solution(int n, int[][] computers) {
        N = n;
        visited = new boolean[n];
        int count = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!visited[i] && computers[i][j] == 1){
                    bfs(i,computers);
                    count++;
                }
            }
        }
        return count;
    }
    public void bfs(int x,int[][] computers){
        q.offer(x);
        visited[x] = true;

        while(!q.isEmpty()){
            int num = q.poll();
            for(int i=0; i<N; i++){
                if(visited[i]){
                    continue;
                }
                if(computers[num][i] == 0){
                    continue;
                }
                q.offer(i);
                visited[i] = true;
            }
        }
    }

    /*
    * DFS 풀이
    * */
//    static boolean[] visited;
    public int solution2(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(computers[i][j] == 1 && !visited[i]){
                    dfs(j,n,computers);
                    answer++;
                }
            }
        }
        return answer;
    }
    public void dfs(int num,int n,int[][] computers){
        visited[num] = true;
        for(int i=0; i<n; i++){
            if(computers[num][i] == 1 && !visited[i]){
                dfs(i,n,computers);
            }
        }
    }
}