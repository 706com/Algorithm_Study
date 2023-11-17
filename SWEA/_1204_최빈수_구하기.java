package SWEA;

// 최빈수 구하기 9분

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1204_최빈수_구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int count = 1;
        while(count<=T){
            count = Integer.parseInt(br.readLine());
            int N = 1000;
            int[] arr = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            int cnt = 1;
            int memory = arr[0];
            int max = 0;
            int result = 0;
            for(int i=1; i<N; i++){
                if(memory == arr[i]){
                    cnt++;
                }
                else{
                    if(max<=cnt){
                        max = cnt;
                        result = memory;
                    }
                    cnt=1;
                    memory = arr[i];
                }
            }

            System.out.printf("#%d %d\n",count,result);
            count++;
        }

    }
}
