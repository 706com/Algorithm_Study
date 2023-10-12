package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.Arrays;
public class _9229_한빈이와_Spot_Mart {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int count = 1;


        while(count<=T){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] arr = new int[N];

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);

            int max = 0;

            for(int i=N-1; i>=0; i--){
                int sum = 0;
                // 1개뽑았는데 무게 초과하면 볼필요도 x
                if(arr[i] > M){
                    continue;
                }

                for(int j=i-1; j>=0; j--){
                    if(arr[i] + arr[j] <= M){
                        sum = arr[i] + arr[j];
                        break;
                    }
                }
                if(sum == M){
                    max = sum;
                    break;
                }
                else if(max < sum){
                    max = sum;
                }
            }
            if(max == 0){
                max = -1;
            }
            System.out.printf("#%d %d",count,max);
            System.out.println();
            count++;
        }
    }
}
