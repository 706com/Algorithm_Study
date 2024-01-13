package BOJ._3_Gold;

// 소요시간 : 15분(실패 : 구현실패)
// 소요시간 : 30분

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class _13913_숨바꼭질_4 {
    static int N,K;
    static int[] arr, dist;

    static int[] dx = {-1,1,2};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[200001];      // 이전 인덱스 담을 공간
        dist = new int[200001];     // 거리 담을 공간

        // 같을 때 예외처리
        if(N==K){
            System.out.println("0");
            System.out.println(N);
            return;
        }
        bfs(N);
    }
    static void bfs(int a){
        Queue<Integer> q = new LinkedList<>();  // 도착 최소거리 찾기
        Stack<Integer> stk = new Stack<>(); // 최소거리 어떻게 이동하는지
        q.offer(a);
        dist[a] = 1;
        arr[a] = a; 

        while(!q.isEmpty()){
            int x = q.poll();
            for(int i=0; i<3; i++){
                int nx = x + dx[i];

                if(i==2){
                    nx = x * dx[i];
                }

                if(nx==K){
                    // 최소거리 출력
                    System.out.println(dist[x]);

                    // 스택에 현재 인덱스부터 이전 노드값까지 담기
                    stk.push(nx);
                    arr[nx] = x;
                    stk.push(arr[nx]);
                    while(arr[nx] != N){
//                        sb.append(arr[nx]).append(" ");
                        nx = arr[nx];
                        stk.push(arr[nx]);
                    }

                    // 출력 역순
                    while(!stk.isEmpty()){
                        sb.append(stk.pop()).append(" ");
                    }
                    System.out.println(sb);
                    return;
                }

                if(nx<0 || nx>=arr.length){
                    continue;
                }
                if(dist[nx] != 0){
                    continue;
                }

                q.offer(nx);
                dist[nx] = dist[x] + 1;
                arr[nx] = x;
            }
        }
    }
}
