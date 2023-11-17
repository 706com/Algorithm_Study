package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1859_백만_장자_프로젝트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int count = 1;

        while(count<=T){
            int N = Integer.parseInt(br.readLine());

            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            long max = arr[N-1];
            long result = 0;
            for(int i=N-2; i>=0; i--){
                if(max>arr[i]){
                    result+=max-arr[i];
                }
                else{
                    max = arr[i];
                }
            }

            System.out.printf("#%d %d\n",count,result);
            count++;
        }
    }
}
