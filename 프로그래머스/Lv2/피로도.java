package 프로그래머스.Lv2;

//소요시간 : 1시간 (실패)

// 접근 : 백트래킹

class 피로도 {
    static int answer = -1;
    static boolean[] visited;
    static int N;
    public int solution(int k, int[][] dungeons) {

        N = dungeons.length;
        visited = new boolean[N];

        dfs(0,0,dungeons,k,0);
        return answer;
    }
    public void dfs(int start,int depth, int[][] dungeons,int k,int count){
        for(int i=0; i<N; i++){
            if(!visited[i] && dungeons[i][0] <= k){
                visited[i] = true;
                dfs(i,depth+1,dungeons,k-dungeons[i][1],count+1);
                visited[i] = false;
            }
        }
        answer = Math.max(answer,count);
    }
}