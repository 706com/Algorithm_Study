package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class _6485_삼성시의_버스_노선 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int count = 1;

        while(count<=T){
            int N  = Integer.parseInt(br.readLine());
            int[][] arr = new int[N+1][2];
            int max = 0;


            // B(i) 중에 가장 큰 값 도출
            for(int i=1; i<=N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
                if(max<arr[i][1]){
                    max = arr[i][1];
                }
            }
            // 버스 정류장 노선 카운팅 할 배열
//            int[] bus = new int[max+1];
            int[] bus = new int[5001]; // 실수했던 부분. 노선이 지나가지 않는 버스 정류장도 생각해서 5001 까지 해놔야한다.

            // bus 정류장마다 카운팅
            for(int i=1; i<=N; i++){
                for(int j=arr[i][0]; j<=arr[i][1]; j++){
                    bus[j] += 1;
                }
            }
            int P  = Integer.parseInt(br.readLine());

            int[] result = new int[P];
            for(int i=0; i<P; i++){
                int C = Integer.parseInt(br.readLine());
                result[i] = bus[C];
            }

            System.out.printf("#%d",count);
            for(int i=0; i<P; i++){
                System.out.printf(" %d", result[i]);
            }
            System.out.println();
            count++;

        }
    }
}
