package 백준.Silver;

// < 알고리즘 유형 >
// 그리디

// < 풀이 접근 >
// *. 미래를 알고있다 ->  현재를 기준으로, 과거로 돌아가는 방식을 사용한다.
// *. !!(주의) result : 1,000,000 * 10,000 는 int 형 범위를 초과하므로, long 으로 형 설정.
// 1. 배열 안에 주식의 가격을 입력받는다.
// 2. 뒤에서부터 흝어가며 , max 값을 갱신시킨다.
// 3. max 값보다 작은 값을 만나면 result 값을 차이만큼 더한다.
// 4. max 값보다 큰 값을 만나면, max 를 갱신시킨다. (같아도 포함)
// 5. result 값을 출력시킨다.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class _11501_주식 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while(T-->0) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            // 1. 배열 안에 주식의 가격을 입력받는다.
            for(int i=0; i<N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int max = arr[arr.length-1];
            long result = 0;
            // 2. 뒤에서부터 흝어가며 , max 값을 갱신시킨다.
            for(int i=N-1; i>=0; i--){
                // 3. max 값보다 작은 값을 만나면 result 값을 차이만큼 더한다.
                if(arr[i]<max){
                    result += max - arr[i];
                }
                // 4. max 값보다 큰 값을 만나면, max 를 갱신시킨다. (같아도 포함)
                else{
                    max = arr[i];
                }
            }
            // 5. result 값을 출력시킨다.
            System.out.println(result);
        }
    }
}
