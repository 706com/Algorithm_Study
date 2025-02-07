package 프로그래머스.Lv2;

//[240229] : 1시간
//[250121] : 🔍
//[250208] : 29분

// 접근 : 백트래킹

class 피로도 {
    static int count = 0;
    static boolean[] visited;
    public int solution(int k, int[][] dungeons) {

        visited = new boolean[dungeons.length];

        dfs(0,k,dungeons);
        return count;
    }
    public void dfs(int depth,int k, int[][] dungeons){

        count = Math.max(depth,count);

        for(int i=0; i<dungeons.length; i++){
            if(!visited[i] && k>=dungeons[i][0]){
                visited[i] = true;
                dfs(depth+1,k-dungeons[i][1],dungeons);
                visited[i] = false;
            }
        }
    }
}