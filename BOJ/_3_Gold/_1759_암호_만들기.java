package BOJ._3_Gold;

// *. 조합 : 순서(x) 중복 허용x
// *. 시간복잡도 : O(2^n)  n<15 이므로 통과!
//소요시간 : 15분

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1759_암호_만들기 {
    static int N;
    static String[] arr,output;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());   // == C

        arr = new String[N];
        output = new String[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = st.nextToken();
        }
        //오름차순
        Arrays.sort(arr);

        dfs(0,0,L);

        System.out.println(sb);
    }
    static void dfs(int start,int depth, int L){
        if(depth==L){
            int consonant = 0;  //자음
            int vowel = 0;  //모음
            // 자음 모음 개수 세기
            for(int i=0; i<L; i++){
                if(output[i].equals("a") || output[i].equals("e") || output[i].equals("i")
                        || output[i].equals("o") || output[i].equals("u") ){
                    vowel++;
                }
                else{
                    consonant++;
                }
            }
            //최소 1개의 모음, 2개의 자음 조건 만족하면 출력
            if(consonant>=2 && vowel>=1){
                for(int i=0; i<L; i++){
                    sb.append(output[i]);
                }
                sb.append('\n');
            }
            return;
        }
        for(int i=start; i<N; i++){
            output[depth] = arr[i];
            if(!visited[i]){
                visited[i] = true;
                dfs(i,depth+1,L);
                visited[i] = false;
            }
        }
    }
}