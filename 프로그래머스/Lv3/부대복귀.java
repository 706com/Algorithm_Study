package 프로그래머스.Lv3;

//[241227] 🔍

// 하나의 목적지에서 여러 출발지까지 가는 가중치를 구하는 문제
// 하나의 시점에서 다른 노드들로 가는 최소 가중치를 구하는 문제이므로 다익스트라
// 다익스트라 시간 복잡도는 O(VlogV + ElogV)

import java.util.*;

public class 부대복귀 {
    static List<Integer>[] list;
    static int[] cost;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer;
        list = new ArrayList[n+1];
        cost = new int[n+1];

        //경로 입력
        for(int i=0; i<=n; i++){
            list[i] = new ArrayList<>();
        }
        for(int i=0; i<roads.length; i++){
            list[roads[i][0]].add(roads[i][1]);
            list[roads[i][1]].add(roads[i][0]);
        }

        //경로 가중치 초기화
        Arrays.fill(cost,Integer.MAX_VALUE);

        // for(List<Integer> x : list){
        //     for(int num : x){
        //         System.out.print(num+" ");
        //     }
        //     System.out.println();
        // }

        search(destination);

        answer = new int[sources.length];
        for(int i=0; i<sources.length; i++){
            answer[i] = cost[sources[i]];
            if(answer[i] == Integer.MAX_VALUE){
                answer[i] = -1;
            }
        }

        return answer;
    }

    public void search(int start){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        cost[start] = 0;

        while(!q.isEmpty()){
            int cur = q.poll();
            for(int i=0; i<list[cur].size(); i++){
                int next = list[cur].get(i);
                if(cost[next] > cost[cur]+1){
                    cost[next] = cost[cur]+1;
                    q.offer(next);
                }
            }
        }
    }
}
