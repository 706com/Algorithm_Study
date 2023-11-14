package BOJ._2_Silver;

// < 알고리즘 유형 >
// dfs - bfs

// < 풀이 접근 >
// *. N 이 10,000, M 이 100,000 이므로 메모리 초과를 우려하여 인접리스트로 구현!
// 1. 신뢰관계를 인접리스트로 구현한다. (단방향)
// 2. bfs 를 돌린다.
// 3. 컴퓨터의 번호를 오룸차순으로 결과를 출력한다.


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1325_효율적인_해킹{

    static int N;
    static int line;
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static int[] result;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int line = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N+1];
        for(int i=1; i<=N;i++){
            arr[i] = new ArrayList<>();
        }

        visited = new boolean[N+1];
        result = new int[N+1];

        for(int i=0; i<line; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[b].add(a);
        }

        for(int i=1; i<=N; i++){
            bfs(i);
            result[i] = count;
            count = 0;
            visited = new boolean[N+1];
        }

        int max = 0;

        for(int x : result){
            if(max < x){
                max = x;
            }
        }

        for(int i=1; i<=N; i++){
            if(max == result[i]){
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }

    static void bfs(int num){
        Queue<Integer> q = new LinkedList<>();
        q.offer(num);
        visited[num] = true;

        while(!q.isEmpty()){
            int node = q.poll();

            for(int x : arr[node]){
                if(!visited[x]){
                    visited[x] = true;
                    q.offer(x);
                    count++;
                }
            }
        }
    }
}

