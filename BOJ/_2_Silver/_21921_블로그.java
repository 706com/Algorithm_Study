package BOJ._2_Silver;

//알고리즘 : 슬라이딩 윈도우

//소요시간 : 21분

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _21921_블로그 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int sum = 0;
        int max = 0;

        int day = 1;
        //맨 처음
        for(int i=0; i<X; i++){
            sum+= arr[i];
        }
        max = sum;

        int point = X;
        for(int i=0; i<N-X; i++){
            sum -= arr[i];
            sum += arr[point+i];
            if(max<sum){
                max = sum;
                day = 1;
            }
            else if(max == sum){
                day++;
            }
        }

        if(max == 0){
            System.out.println("SAD");
            return;
        }

        System.out.println(max);
        System.out.println(day);
    }
}
