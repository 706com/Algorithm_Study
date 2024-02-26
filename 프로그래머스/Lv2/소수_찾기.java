package 프로그래머스.Lv2;
//[프로그래머스] 소수 찾기 - JAVA(자바)

//소요시간 : 45분

import java.util.HashSet;

// System.out.println();
class 소수_찾기 {
    static int[] arr;
    static int[] output;
    static boolean[] visited;
    static int N;
    static HashSet<Integer> hs = new HashSet<>();
    public int solution(String numbers) {
        int answer = 0;

        N = numbers.length();
        arr = new int[N];
        output = new int[N];
        visited = new boolean[N];

        for(int i=0; i<N; i++){
            arr[i] = numbers.charAt(i)-'0';
        }

        for(int i=1; i<=N; i++){
            dfs(0,0,i);
            visited = new boolean[N];
        }

        for(Integer x : hs){
            System.out.println(x);
            if(isPrime(x)){
                answer++;
            }
        }
        return answer;
    }
    public void dfs(int start,int depth,int r){
        if(depth == r){
            //output 출력
            String temp = "";
            for(int i=0; i<depth; i++){
                temp += output[i];
            }
            hs.add(Integer.parseInt(temp));
            return;
        }

        for(int i=0; i<N; i++){
            output[depth] = arr[i];
            if(!visited[i]){
                visited[i] = true;
                dfs(i,depth+1,r);
                visited[i] = false;
            }
        }
    }
    public boolean isPrime(int x){
        if(x<2){
            return false;
        }

        for(int i=2; i<=Math.sqrt(x); i++){
            if(x % i == 0){
                return false;
            }
        }
        return true;
    }
}