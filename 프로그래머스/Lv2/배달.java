package 프로그래머스.Lv2;

//소요시간
//[240618] : 40분 🔍

import java.util.*;

public class 배달 {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        // 간선 정보를 담은 맵을 초기화한다.
        int[][] map = new int[N+1][N+1];
        int[] cost = new int[N+1];
        boolean[] visited = new boolean[N+1];

        for(int i=1; i<=N; i++){
            Arrays.fill(map[i],5000000);
            map[i][i] = 0;
        }

        for(int i=0; i<road.length; i++){
            int start = road[i][0];
            int end = road[i][1];
            int costs = road[i][2];

            map[start][end] = Math.min(map[start][end],costs);
            map[end][start] = Math.min(map[end][start],costs);
        }
        Arrays.fill(cost,Integer.MAX_VALUE);
        cost[1] = 0;

        for(int i=1; i<=N; i++){
            int min = Integer.MAX_VALUE;
            int minIdx = 1;
            //방문하지 않은 노드 중 cost 최솟값과 해당 인덱스를 찾는다.
            for(int j=1; j<=N; j++){
                if(!visited[j] && min > cost[j]){
                    min = cost[j];
                    minIdx = j;
                }
            }
            //최솟값노드 방문처리
            visited[minIdx] = true;

            // 기존에 있던 값과, 왔던 경로 중, 작은값
            for (int j = 2; j <= N; j++) {
                if (cost[j] > cost[minIdx] + map[minIdx][j]) {
                    cost[j] = cost[minIdx] + map[minIdx][j];
                }
            }
        }

        for(int i=1; i<=N; i++){
            if(cost[i] <= K){
                answer++;
            }
        }

        return answer;
    }
}
