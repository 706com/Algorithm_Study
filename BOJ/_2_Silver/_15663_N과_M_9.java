package BOJ._2_Silver;

//소요시간 : 20분 (실패: 구현실패)
//소요시간 : 20분

// 📌 LinkedHashSet , toString()

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class _15663_N과_M_9 {
    static int N;
    static int[] arr,output;
    static boolean[] visited;
    static LinkedHashSet<String> set = new LinkedHashSet<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        output = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
//        System.out.println(Arrays.toString(arr));

        dfs(0,0,M);
        for(String x : set){
            st = new StringTokenizer(x,",[] ");
            while(st.hasMoreTokens()){
                sb.append(st.nextToken()).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
    static void dfs(int start, int depth, int r){
        if(depth == r){
            int[] newArr = new int[depth];
            //중복 제거 및 출력
            for(int i=0; i<depth; i++){
                newArr[i] = output[i];
            }
            set.add(Arrays.toString(newArr));
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
}
