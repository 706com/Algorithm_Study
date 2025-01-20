package 프로그래머스.Lv2;

//[240229] : 1시간
//[250121] : 🔍

// 접근 : 백트래킹

class 피로도 {
    static int max = 0;
    boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(k,0,dungeons);
        return max;
    }
    public void dfs(int fatigue,int count,int[][] dungeons){
        // System.out.println(fatigue);
        max = Math.max(max, count);  // 최대 탐험 수 갱신

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && fatigue >= dungeons[i][0]) {
                visited[i] = true;
                dfs(fatigue - dungeons[i][1], count + 1, dungeons);
                visited[i] = false;
            }
        }
    }
}