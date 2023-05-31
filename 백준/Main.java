package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());

        int[] arr = new int[A];
        int[] dp = new int[A];

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        //배열에 값 담기
        for(int i=0; i<A; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<A; i++){
            dp[i] = 1;
            for(int j=0; j<i; j++){
                if(arr[i]>arr[j] && dp[i]<=dp[j]){
                    dp[i] = dp[j]+1;
                }
            }
        }

        int max = 0;
        for(int i=0; i<A; i++){
            if(max < dp[i]){
                max = dp[i];
            }
        }

        System.out.println(max);


    }
}