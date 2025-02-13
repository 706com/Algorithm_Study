package BOJ._3_Gold;

//[250213] 45분

import java.util.*;
import java.io.*;

public class _1939_중량제한 {
    static List<Node>[] list;
    static int[] dist;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        dist = new int[N+1];

        for(int i=0; i<=N; i++){
            list[i] = new ArrayList<>();
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b,c));
            list[b].add(new Node(a,c));
        }
        Arrays.fill(dist,Integer.MIN_VALUE);

        st= new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int max = 0;
        for(Node x : list[start]){
            max = Math.max(max,x.edge);
        }

        int end = Integer.parseInt(st.nextToken());
        dijkstra(start,max);

        System.out.println(dist[end]);
    }
    public static void dijkstra(int start,int maxStart){
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)-> o2.edge-o1.edge);
        pq.offer(new Node(start,maxStart));
        dist[start] = maxStart;    //본인한테 도착한 것 중 가장 큰 것
        while(!pq.isEmpty()){
            Node node = pq.poll();

            //이미 갈 중량보다 더 큰 값 보유
            if(dist[node.num] > node.edge){
                continue;
            }
            // 도착한 것 중에는 최대를 가져야 함
            // 갈때는 갈 수 있는 것 중 최소여야함
            for(Node x : list[node.num]){
                //도착한 것 중에선 최대를 가져야해
                //근데 edge 가 최선인지 어떻게 알지? (이전노드가 가지고 있는거랑, edge 중 최솟값)
                if(Math.min(dist[node.num],x.edge) > dist[x.num]) {
                    dist[x.num] = Math.max(dist[x.num], Math.min(dist[node.num], x.edge));
                    pq.offer(x);
                }
            }
        }
//        System.out.println(Arrays.toString(dist));
    }
    static class Node{
        int num;
        int edge;
        Node(int num, int edge){
            this.num= num;
            this.edge = edge;
        }
    }
}
