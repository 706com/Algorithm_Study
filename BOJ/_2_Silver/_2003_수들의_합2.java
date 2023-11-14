package BOJ._2_Silver;

//[백준]2805 : 나무자르기 - JAVA(자바)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2003_수들의_합2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;


        for(int i=0; i<N; i++){

            int p = i+1 ;
            int sum = arr[i];

            //만일, arr[i] 그 자체가 M 과 같을시 while문 볼 필요도 없이
            //카운트 증가하고 continue
            if(sum == M){
                /*System.out.println("cnt 증가 되는 i구간 : " + i)*/
                cnt++;
                continue;
            }

            // p < N : 조건을 안추가해주면 인덱스 벗어남
            while(sum < M && p<N){

                //sum 이 포인터로 뒤에꺼 하나하나 더해가면서 M 과 같을때까지 중첩
                sum += arr[p];
                p++;

                if(sum == M){
                    /*System.out.println("cnt 증가 되는 i구간 : " + i);*/
                    cnt++;
                    break;
                }
            }
        }
        System.out.println(cnt);
    }
}
