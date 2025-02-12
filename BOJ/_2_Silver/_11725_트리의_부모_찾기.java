package BOJ._2_Silver;

//[250212] 🔍

// < 알고리즘 유형 >
// 그래프 탐색

// < 풀이 접근 >
// *. 인접 행렬로 구현하면 메모리 초과 ! 100,000^2 ]
// *. 따라서 인접리스트로 구현하기.
// 1. 인접리스트를 구현한다.
// 2. bfs 를 돌려 1 부터 차례대로 방문한다.
// 3. 방문한 노드는 부모노드를 뜻하므로 , father 배열을 구현하여 저장시킨다.
// 4. 출력값이 많을 수 있으므로, stringBuilder 를 사용한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class _11725_트리의_부모_찾기 {
    static int N;
    static List<Integer>[] list;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];
        parent = new int[N+1];

        // 노드 - 간선 정보 입력
        for(int i=0; i<=N; i++){
            list[i] = new ArrayList<>();
        }
        for(int i=0; i<N-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        bfs(1);
        StringBuilder sb = new StringBuilder();
        for(int i=2; i<=N; i++){
            sb.append(parent[i]+"\n");
        }
        System.out.println(sb);
    }
    public static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        while(!q.isEmpty()){
            Integer num = q.poll();

            for(int target : list[num]){
                if(parent[target] != 0){
                    continue;
                }
                q.offer(target);
                parent[target] = num;
            }
        }
    }
}
