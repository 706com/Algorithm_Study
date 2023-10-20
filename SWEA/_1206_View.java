package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class _1206_View {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        int count =1;
        while(count<=T){
            int N = Integer.parseInt(br.readLine());

            int[] arr = new int[N];

            StringTokenizer st =new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int result = 0;
            boolean check = true;
            for(int i=2; i<=N-2; i++){
                check = false;
                for(int j=1; j<=2; j++) {
                    if (arr[i - j] < arr[i] && arr[i] > arr[i + j]) {
                        check = true;
                    }
                    else {
                        check = false;
                        break;
                    }
                }
                if(check){
                    int distOne = Math.min(arr[i]-arr[i - 1], arr[i]- arr[i + 1]);
                    int distTwo = Math.min(arr[i]-arr[i - 2], arr[i]- arr[i + 2]);
                    result += Math.min(distOne, distTwo);
                }
            }

            System.out.printf("#%d %d",count,result);
            System.out.println();
            count++;
        }
    }
}
