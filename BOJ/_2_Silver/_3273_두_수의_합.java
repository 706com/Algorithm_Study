package BOJ._2_Silver;

//소요 시간 : 4분

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _3273_두_수의_합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        //배열 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int num = Integer.parseInt(br.readLine());
        int count = 0;

        //탐색
        for(int i=0; i<N-1; i++){
            for(int j=i+1; j<N; j++){
                if(arr[i] + arr[j] == num){
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
