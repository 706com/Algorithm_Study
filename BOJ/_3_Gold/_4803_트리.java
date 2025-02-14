package BOJ._3_Gold;

//[250214] 🔍📌

//트리의 성질 -> 한 사이클에서 간선의 수는 무조건 N-1 개이다.
//input:
//4 4
//1 4
//2 4
//3 4
//3 1
//0 0
//output: Case 1: There is one tree.
//answer: Case 1: No trees.


import java.util.*;
import java.io.*;

public class _4803_트리 {
    static List<Integer>[] list;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int tc = 1;
        while(true){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            if(N==0 && M==0){
                break;
            }
            list = new ArrayList[N+1];
            visited = new boolean[N+1];
            for(int i=0; i<=N; i++){
                list[i] = new ArrayList<>();
            }
            //간선 정보 입력 -> 단방향 이어야함
            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list[a].add(b);
                list[b].add(a);
            }

            //순차탐색
            int count = 0;
            for(int i=1; i<=N; i++){
                if(!visited[i]){
                    boolean isTree = checkTree(i);
                    if(isTree){
//                        System.out.println(Arrays.toString(visited));
                        count++;
                    }
                }
            }
//            System.out.println(count);
            if(count >= 2){
                sb.append("Case "+ tc +": A forest of "+count+" trees.\n");
            } else if(count == 1){
                sb.append("Case "+ tc +": There is one tree.\n");
            } else{
                sb.append("Case "+ tc +": No trees.\n");
            }
            tc++;
        }
        System.out.println(sb);
    }
    public static boolean checkTree(int start){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        int node = 0;
        int edge = 0;

        while(!q.isEmpty()){
            int num = q.poll();
            if(visited[num]){
                continue;
            }
            node++;
            visited[num] = true;
            //사이클 판별이 핵심 (어떻게?) -> 단방향
            for(int x : list[num]){
                edge++;
                if(!visited[x]){
                    q.offer(x);
//                    visited[x] = true;
                }
            }
        }
//        System.out.println(node + " " + edge);
        // 트리의 성질 : 하나의 트리에서 간선의 수는 무조건 N-1 개이다.
        if(edge/2 == node-1){
            return true;
        }
        else {
            return false;
        }
    }
}
