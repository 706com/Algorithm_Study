package BOJ._2_Silver;

//소요시간 : 13분

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2847_게임을_만든_동준이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int max = arr[N-1]; //가장 높은 레벨의 점수
        int result = 0;

        for(int i=N-2; i>=0; i--){
            if(arr[i]>=max){
                result += (arr[i] - max) + 1;
                max = max-1;
            }
            else{
                max = arr[i];
            }
        }
        System.out.println(result);
    }
}
