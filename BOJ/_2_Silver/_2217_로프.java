package BOJ._2_Silver;
//< 나의 알고리즘 >
// 뭔 말인지 모르겠다.

//< 답안 알고리즘 >
// 그리디 알고리즘..? 그리디라고 표현하기에는 쫌 난해한 것 같다.
// 특정 로프를 사용할 경우,
// 그 로프보다 무게가 큰 로프를 모두 사용하는 것이 이득이다.
// 따라서, 최대 무게 w는 rope[i] * (N - i)와 같다.

//< 새로 알게된 것 >

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//< 궁금한 것 >
public class _2217_로프 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());    //로프의 개수
        int[] arr = new int[N];

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int result = 0;

        for(int i=0; i<N; i++){
            result = Math.max(result,arr[i]*(N-i));
        }

        System.out.println(result);
    }
}
