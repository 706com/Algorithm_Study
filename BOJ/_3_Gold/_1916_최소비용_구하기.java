package BOJ._3_Gold;

//[250205] 🔍

// 필수
// if(node.cost > dist[node.num]){
//   continue;
// }


import java.util.*;
import java.io.*;

public class _1916_최소비용_구하기 {
    static List<Node>[] list;
    static int[] dist;
//    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        list = new ArrayList[N+1];
        dist = new int[N+1];
//        visited = new boolean[N+1];

        for(int i=1; i<=N; i++){
            list[i] = new ArrayList<>();
        }
        Arrays.fill(dist,Integer.MAX_VALUE);

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b,cost));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        dijkstra(start);
        System.out.println(dist[end]);
    }
    public static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)-> o1.cost - o2.cost);
        pq.offer(new Node(start,0));
        dist[start] = 0;
//        visited[start] = true;

        while(!pq.isEmpty()){
            Node node = pq.poll();
//            visited[node.num] = true;

            // 더 짧은 거리로 이미 방문된 노드라면 다시 처리할 필요 없으므로 건너뛴다.
            if(node.cost > dist[node.num]){
                continue;
            }

            for(Node x : list[node.num]){
//                if(visited[x.num]){
//                    continue;
//                }
                if(dist[x.num] > dist[node.num]+x.cost){
                    dist[x.num] = Math.min(dist[x.num],dist[node.num]+x.cost);
                    pq.offer(new Node(x.num,dist[node.num]+x.cost));
                }
            }
        }
    }
    static class Node{
        int num;
        int cost;
        Node(int num,int cost){
            this.num = num;
            this.cost = cost;
        }
    }
}
