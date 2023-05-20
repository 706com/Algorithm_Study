package 백준.Silver;
//[백준]1182 : 부분수열의 합 - JAVA(자바)

//< 알고리즘 유형 >
// 백트래킹
// STL : next_permultation

//< 알고리즘 풀이 >
// 공집합부터 모든 수열의 조합을 만들어나가고, 답안 확인
// dfs (재귀)를 이용.

//< 새로 알게된 것 >

//< 궁금한 것 >

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1182_부분수열의_합 {
    static int N,S;
    static int answer = 0;
    static int[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        num = new int[N];


        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0,0);   //공집합부터 시작

        if(S == 0) {
            System.out.println(answer-1);   //공집합 빼주기
        }
        else{
            System.out.println(answer);
        }
    }
    static void dfs(int depth,int sum){
        //끝까지 내려왔을때, 합이 S와 같으면 answer증가
        if(depth == N){
            if(sum == S) {
                answer++;
            }
            return;
        }

        dfs(depth + 1,sum + num[depth]);
        dfs(depth + 1, sum);
    }
}
