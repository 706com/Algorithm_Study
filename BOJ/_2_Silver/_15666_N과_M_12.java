package BOJ._2_Silver;

//소요시간 : 9분

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class _15666_N과_M_12 {
    static int N;
    static int[] arr,output;
    static LinkedHashSet<String> set = new LinkedHashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        output = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        dfs(0,0,M);

        for(String x : set){
            st = new StringTokenizer(x,"[],");
            while(st.hasMoreTokens()){
                sb.append(st.nextToken());
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
    static void dfs(int start, int depth, int r){
        if(depth == r){
            int[] newArr = new int[depth];
            for(int i=0; i<depth; i++){
                newArr[i] = output[i];
            }
            set.add(Arrays.toString(newArr));
            return;
        }
        for(int i=start; i<N; i++){
            output[depth] = arr[i];
            dfs(i,depth+1,r);
        }
    }
}
