package 프로그래머스.Lv2;

//소요시간
//[240618] : 40분 🔍
//[250208] : 22분

//다익스트라
//두 마을 a, b를 연결하는 도로는 여러 개 (어떻게 처리하지) -> 다익스트라에선 필요없음 (visit처리가 없어서)

import java.util.*;

public class 배달 {
    int[] dist;
    List<Node>[] list;
    public int solution(int N, int[][] road, int K) {

        list = new ArrayList[N+1];
        dist = new int[N+1];

        Arrays.fill(dist,Integer.MAX_VALUE);

        for(int i=0; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<road.length; i++){
            int a = road[i][0];
            int b = road[i][1];
            int cost = road[i][2];
            list[a].add(new Node(b,cost));
            list[b].add(new Node(a,cost));
        }

        dijkstra(1);
        int result = 0;
        for(int x : dist){
            if(x<=K){
                result++;
            }
        }
        return result;
    }
    void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)-> o1.cost- o2.cost);
        pq.offer(new Node(start,0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Node node = pq.poll();

            if(dist[node.num] < node.cost){
                continue;
            }
            for(int i=0; i<list[node.num].size(); i++){
                Node target = list[node.num].get(i);
                if(dist[target.num] > target.cost + dist[node.num]){
                    dist[target.num] = target.cost + dist[node.num];
                    pq.offer(target);
                }
            }
        }
        // System.out.println(Arrays.toString(dist));
    }
    class Node{
        int num;
        int cost;
        Node (int num,int cost){
            this.num = num;
            this.cost = cost;
        }
    }
}
