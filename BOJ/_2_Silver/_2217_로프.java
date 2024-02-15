package BOJ._2_Silver;

//소요시간 : 20분

//풀이 정의 : 오름차순으로 정렬해놓았기 때문에, 가능한 풀이.
//-> 본인보다 뒤에는 어차피 다 크기 때문에 (N-i)가 가능

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _2217_로프 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int max = 0;

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        for(int i=0; i<N; i++){
            max = Math.max(max,arr[i]*(N-i));
        }
        System.out.println(max);
    }
}
