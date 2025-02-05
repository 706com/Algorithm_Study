package BOJ._3_Gold;

//[250205] 🔍

import java.util.*;
import java.io.*;

public class _1753_최단경로 {

    static List<Node>[] list;
    static int[] costs;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int startV = Integer.parseInt(br.readLine());

        list = new ArrayList[V+1];
        costs = new int[V+1];
        visited = new boolean[V+1];

        Arrays.fill(costs,Integer.MAX_VALUE);
        for(int i=0; i<=V; i++){
            list[i] = new ArrayList<>();
        }

        //간선 입력
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            Node node = new Node(b,cost);
            list[a].add(node);
        }

        bfs(startV);

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=V; i++){
            if(costs[i] == Integer.MAX_VALUE){
                sb.append("INF").append('\n');
                continue;
            }
            sb.append(costs[i]).append('\n');
        }
        System.out.println(sb);
    }
    public static void bfs(int start){
        PriorityQueue<Node> q = new PriorityQueue<>((o1,o2)-> o1.cost - o2.cost);
//        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(start,0));
        visited[start] = true;
        costs[start] = 0;

        while(!q.isEmpty()){
            Node node = q.poll();
            for(Node x : list[node.V]){
                if(visited[x.V]){
                    continue;
                }
                if(costs[x.V]>costs[node.V]+x.cost){
                    costs[x.V] = Math.min(costs[x.V],costs[node.V]+x.cost);
                    q.offer(new Node(x.V,costs[x.V]));
                }
            }
        }
    }

    public static class Node{
        int V;
        int cost;
        Node(int V, int cost){
            this.V= V;
            this.cost = cost;
        }
    }
}
