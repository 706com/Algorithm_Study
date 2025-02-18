package BOJ._3_Gold;

//[250218] 40분

import java.util.*;
import java.io.*;

public class _1504_특정한_최단_경로{
    static List<Node>[] list;
    static int[][] dist;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        list = new List[N+1];
        dist = new int[N+1][N+1];

        for(int i=0; i<=N; i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        for(int i=0; i<=N; i++){
            list[i] = new ArrayList<>();
        }
        for(int i=0;i<E; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b,cost));
            list[b].add(new Node(a,cost));
        }
        st = new StringTokenizer(br.readLine());
        int first = Integer.parseInt(st.nextToken());
        int second = Integer.parseInt(st.nextToken());
        dijkstra(1);
        dijkstra(first);
        dijkstra(second);

        // 비교
        // start -> first -> second -> end
        // start -> second -> first -> end
        int result = Math.min(dist[1][first] + dist[first][second] + dist[second][N],dist[1][second] + dist[second][first] + dist[first][N]);
//        for(int i=1; i<=N; i++){
//            System.out.println(Arrays.toString(dist[i]));
//        }

        //갈 수 있는 경로가 없으면, -1 출력
        if(dist[1][first] == Integer.MAX_VALUE || dist[first][second] == Integer.MAX_VALUE || dist[second][N] == Integer.MAX_VALUE ||
        dist[1][second] == Integer.MAX_VALUE || dist[second][N] == Integer.MAX_VALUE){
            System.out.println(-1);
            return;
        }
        System.out.println(result);
    }
    public static void dijkstra(int num){
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2) -> o1.cost-o2.cost);
        pq.offer(new Node(num,0));
        dist[num][num] = 0;

        while(!pq.isEmpty()){
            Node node = pq.poll();
            for(Node x : list[node.num]){
                int target = x.num;
                if(dist[num][target] > dist[num][node.num] + x.cost){
                    dist[num][target] = dist[num][node.num] + x.cost;
                    pq.offer(x);
                }
            }
        }

    }
    static class Node{
        int num;
        int cost;
        Node(int num, int cost){
            this.num = num;
            this.cost = cost;
        }
    }
}
