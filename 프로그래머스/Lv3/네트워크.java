package 프로그래머스.Lv3;

//소요 시간 : 17분

class 네트워크 {
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
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