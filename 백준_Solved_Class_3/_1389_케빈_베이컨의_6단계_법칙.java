package 백준_Solved_Class_3;
//[백준]1389 : 케빈 베이컨의 6단계 법칙 - JAVA(자바)

//<새로 알게된 것>
//플로이드 와샬 알고리즘 (여기서는 안쓰임) (*공부해보기)
//최단경로 찾기

//<궁금한 것>
//

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1389_케빈_베이컨의_6단계_법칙 {
    static int N,M;
    static int[][] connectLine;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());    //유저의 수 (2<=N<=100)
        M = Integer.parseInt(st.nextToken());    //친구 관계의 수 (1 ≤ M ≤ 5,000)

        connectLine = new int[N+1][M+1];
        visit = new boolean[M+1];

        //친구 관계 맺기(노드-간선처럼)
        for(int i=1; i<=M; i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            connectLine[a][b] = connectLine[b][a] = 1;

        }

        int min = Integer.MAX_VALUE;
        int minPeopleNumber = Integer.MAX_VALUE;
        //bfs 돌리기 1부터
        for(int i=1; i<=N; i++){
            int nowCount = bfs(i);

//          //System.out.println("nowCount: "+nowCount);

            //유저 중에서 케빈 베이컨의 수가 가장 작은 사람을 출력한다.
            // 그런 사람이 여러 명일 경우에는 번호가 가장 작은 사람을 출력한다.
            if(min>nowCount) {
                min = nowCount;
                minPeopleNumber = i;
            }

            //방문여부 초기화
            Arrays.fill(visit,false);
        }

        System.out.println(minPeopleNumber);
    }

    public static int bfs(int start){
        Queue<Node> q = new LinkedList<>();
        visit[start] = true;
        int count = 0;
        q.offer(new Node(start,count));

        while(!q.isEmpty()) {
            Node node = q.poll();
            count += node.count;
            for (int i = 1; i <= M; i++) {
                if(connectLine[node.num][i] != 1 || visit[i] == true){
                    continue;
                }
                visit[i] = true;
                q.offer(new Node(i,node.count+1));
            }
        }
        return count;
    }
    static class Node{
        int num;
        int count;
        public Node(int num,int value){
            super();
            this.num = num;
            this.count = value;
        }
    }
}

