package BOJ._2_Silver;

//[251221] : 50분

import java.util.*;
import java.io.*;

public class _18352_특정_거리의_도시_찾기 {
    static int N,M,K,X;
    static List<Integer>[] arr;
    static List<Integer> answer = new ArrayList<>();
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 도시의 개수
        M = Integer.parseInt(st.nextToken());   // 도로의 개수
        K = Integer.parseInt(st.nextToken());   // 원하는 거리 정보
        X = Integer.parseInt(st.nextToken());   // 출발 도시 번호


        // 거리 정보 초기화
        dist = new int[N+1];
        Arrays.fill(dist,-1);

        // 인접 리스트 정보 생성
        arr = new ArrayList[N+1];
        for(int i=0; i<=N; i++){
            arr[i] = new ArrayList<>();
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            arr[S].add(E);
        }

//        for(List x : arr){
//            System.out.println(x);
//        }
        //본인 거리 정보는 0
        dist[X] = 0;    //본인 위치는 0

        // 시작점 으로부터 DFS
        dfs(X,0);

//        System.out.println(Arrays.toString(dist));
        // 원하는 거리와 같으면 정답 위치로 산출
        for(int i=1 ;i<dist.length; i++){
            if(dist[i] == K){
                answer.add(i);
            }
        }
        Collections.sort(answer);

        //최단거리 K인 도시가 하나도 존재하지 않음
        if(answer.isEmpty()){
            System.out.println("-1");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for(int x : answer){
            sb.append(x).append('\n');
        }
        System.out.println(sb);
    }

    public static void dfs(int start, int depth){
        // 거리와 같은 도착지 add
        if(depth > K){
            return;
        }
        //이미 최단거리보다 많으면 더이상 갈 필요 없음
        if(dist[start] < depth){
            return;
        }
        depth++;
        for(Integer x : arr[start]){
            // 최단거리 산출
            if(dist[x] == -1) {  //처음이면 depth 값
                dist[x] = depth;
            } else{ // 이미 방문했던 곳이면 최단거리 산출
                dist[x] = Math.min(dist[x], depth);
            }
            dfs(x,depth);
        }
    }
}
