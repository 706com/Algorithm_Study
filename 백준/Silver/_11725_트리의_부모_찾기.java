package 백준.Silver;

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
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class _11725_트리의_부모_찾기 {

    static int N;

    static ArrayList<ArrayList<Integer>> arr;
    static boolean[] visited;
    static int[] father;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        arr= new ArrayList<>();
        for(int i=0; i<=N; i++){
            arr.add(new ArrayList<>());
        }

        visited = new boolean[N+1];
        father = new int[N+1];

        // 인접리스트 구현
        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.get(a).add(b);
            arr.get(b).add(a);
        }

//        // 값 확인
//        for(ArrayList node : arr){
//            System.out.println(node);
//        }

        bfs(1);

        for(int i=2; i<=N; i++){
            sb.append(father[i]).append('\n');
        }
        System.out.println(sb);
    }

    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        visited[start] = true;

        while(!q.isEmpty()) {
            int node = q.poll();
            for(int v : arr.get(node)){
                if(!visited[v]){
                    visited[v] = true;
                    q.offer(v);
                    father[v] = node;
                }
            }
        }
    }
}
