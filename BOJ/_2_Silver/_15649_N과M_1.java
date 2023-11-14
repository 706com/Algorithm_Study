package BOJ._2_Silver;
//[백준]15649 : N과 M(1) - JAVA(자바)

//< 나의 알고리즘 >

//< 답안 알고리즘 >
// 백트래킹 첫 번째 문제.
// 재귀를 사용. 그림으로써 머릿속 연상시키는게 필요하다.

//< 새로 알게된 것 >
// 백트래킹

//< 궁금한 것 >

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _15649_N과M_1 {
    static int N,M;
    static int[] arr;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        visit =  new boolean[N];

        dfs(0);
        System.out.println(sb);
    }
    static void dfs(int depth){
        if(depth==M){
            for(int value : arr){
                sb.append(value).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0; i<N; i++){
            if(!visit[i]){
                visit[i] = true;    //방문처리
                arr[depth] = i+1;   //값 넣기
                dfs(depth+1); //자식노드 보내기
                visit[i] = false;   //dfs 돌면 부모노드 방문 풀기
            }
        }
    }
}
