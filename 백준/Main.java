package 백준;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int result = black(arr,N,M);

        System.out.println(result);
    }

    public static int black(int[] arr,int N , int M) {
        int max = 0;
        for (int i = 0; i < N-2; i++) {
            for (int j = i + 1; j < N-1; j++) {
                for (int k = j + 1; k < N; k++) {
                    if(arr[i]+arr[j]+arr[k] == M){
                        return arr[i] + arr[j] + arr[k];
                    }
                    else if(arr[i]+arr[j]+arr[k] < M && max < arr[i]+arr[j]+arr[k] ){
                        max = arr[i]+arr[j]+arr[k];
                    }
                }
            }
        }
        return max;


    }
}
