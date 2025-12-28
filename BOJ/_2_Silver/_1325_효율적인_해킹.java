package BOJ._2_Silver;

//[251228] 🔍

import java.io.*;
import java.util.*;

public class _1325_효율적인_해킹{
    static int N,M;
    static boolean[] visited;
    static List<Integer>[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 1.인접리스트 초기화
        arr = new List[N+1];
        for(int i=1; i<=N; i++){
            arr[i] = new ArrayList<>();
        }
        // start , end 는 반대로
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[end].add(start);    //단방향 (신뢰관계)
        }


        // Q) 시작점인 10000개 를 모두 탐색? -> 그렇다. 각각 구해야 하므로
        int[] result = new int[N+1];
        int maxCnt = 0;
        for(int i=1; i<=N; i++){
            visited = new boolean[N+1]; // 방문기록
            result[i] = Math.max(bfs(i),result[i]);
            maxCnt = Math.max(result[i],maxCnt);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++){
            if(maxCnt == result[i]){
                sb.append(i+" ");
            }
        }
        System.out.println(sb);
    }

    public static int bfs(int start){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visited[start] = true;
        int count = 0; // 각 출발노드에 대해서 해킹할 수 있는 갯수 세기

        while(!q.isEmpty()){
            Integer currentNode = q.poll();
            for(int nextNode : arr[currentNode]){
                if(visited[nextNode]){
                    continue;
                }
                q.offer(nextNode);
                visited[nextNode] = true;
                count++;
            }
        }
        return count;
    }
}

