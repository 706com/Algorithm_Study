package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1244_최대_상금 {
    static int N;
    static int chance;
    static char[] arr;
    //static boolean[] visited;
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int count = 1;
        while(count<=T){
            StringTokenizer st= new StringTokenizer(br.readLine());
            String str = st.nextToken();
            N = str.length();
            chance = Integer.parseInt(st.nextToken());
            max = 0;

            arr = new char[N];
            //visited = new boolean[N];
            for(int i=0; i<N; i++){
                arr[i] = str.charAt(i);
            }

            dfs(0,0);

            System.out.printf("#%d %d\n",count,max);
            count++;
        }
    }

    static void dfs(int start,int depth){
        if(depth == chance){
            int num = Integer.valueOf(String.valueOf(arr));
            max = Math.max(max,num);
            return;
        }

        for(int i=start; i<N; i++){
            for(int j=i+1; j<N; j++){
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                dfs(i,depth+1);

                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }
}
