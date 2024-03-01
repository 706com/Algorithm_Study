package 프로그래머스.Lv2;
// https://school.programmers.co.kr/learn/courses/30/lessons/86971

//소요시간 : 50분

import java.util.Arrays;

class 전력망을_둘로_나누기 {
    static boolean[] visited;
    static int[][] arr;
    static int N;
    static int count = 0;

    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        N = n;
        arr = new int[N+1][N+1];    //노드-간선 그래프

        //그래프 잇기
        for(int i=0; i<wires.length; i++){
            int a = wires[i][0];
            int b = wires[i][1];

            arr[a][b] = arr[b][a] = 1;
        }

        for(int i=0; i<wires.length; i++){
            //일시적으로 한 번 간선 끊기
            int a = wires[i][0];
            int b = wires[i][1];

            arr[a][b] = arr[b][a] = 0;

            visited = new boolean[N+1]; //방문여부 초기화
            count = 0;

            //노드 1번부터 탐색
            dfs(1);

            // 두 전력망으로 나누었을 때,
            // 두 전력망이 가지고 있는 송전탑 개수의 차이(절대값)를 return
            answer = Math.min(answer,Math.abs(n-count-count));

            //일시적으로 끊은 간선 복구
            arr[a][b] = arr[b][a] = 1;
        }
        return answer;
    }

    public void dfs(int start){
        visited[start] = true;
        count++;

        for(int i=1; i<=N; i++){
            if(visited[i] || arr[start][i] != 1){
                continue;
            }
            dfs(i);
        }
    }
}